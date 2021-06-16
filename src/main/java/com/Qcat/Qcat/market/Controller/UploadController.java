package com.Qcat.Qcat.market.Controller;

import com.Qcat.Qcat.market.dto.UploadResultDTO;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class UploadController {

    @Value("${com.qcat.upload.path}")
    private String uploadPath;

    @PostMapping("/uploadAjax")
    public ResponseEntity<List<UploadResultDTO>> uploadFile(MultipartFile[] uploadFiles) { //ResponseEntity는 사용자의 httpRequest에 대한 응답 데이터를 포함(헤더,바디,스테이터스 포함)

        List<UploadResultDTO> resultDTOList = new ArrayList<>();

        System.out.println(uploadFiles);

        for (MultipartFile uploadFile : uploadFiles) {

            if (uploadFile.getContentType().startsWith("image") == false) { //<<-- 이미지 업로드한 파일이 image글자로 시작하지 않을때
                log.warn("this file is not image type");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            String originalName = uploadFile.getOriginalFilename(); //원래 저장된 이름 필요(나중에보여주기위해)
            String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1); //제일마지막에쓰인 \\의 인덱스다음인덱스부터 짤라줌(경로떼기)

            log.info("fileNAme:" + fileName);
            //날짜 폴더
            String folderPath = makeFolder(); //날짜대로 폴더만들어주기

            //UUID
            String uuid = UUID.randomUUID().toString(); //랜덤글씨생성

            String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
            Path savePath = Paths.get(saveName); //패스를 정의한다. ------------

            try {
                uploadFile.transferTo(savePath); //원본 파일 저장

                String thumbnailSaveName = uploadPath + File.separator + folderPath + File.separator + "s_" + uuid + "_" + fileName;//썸네일을 생성한다.

                File thumbnailFile = new File(thumbnailSaveName); //pathName에 해당하는 파일의 객체를 생성
                //savePath를 파일객체로 변환
                Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 100, 100); //가로세로 100
                resultDTOList.add(new UploadResultDTO(fileName, uuid, folderPath)); //dto에 파일경로들을만들수있게 넣어준다음 뷰페이지로 반환할예정


            } catch (IOException e) {
                e.printStackTrace();
            }

        } //for문 끝
        return new ResponseEntity<>(resultDTOList, HttpStatus.OK); //모든 업로드요청한 파일이 정상적으로 수행되면 썸네일이미지정보를 반환
    }


    private String makeFolder() {

        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")); //현재시간 년월일
        String folderPath = str.replace("//", File.separator); //시스템마다 다른 파일 구분자를 통일시켜준다

        File uploadPathFolder = new File(uploadPath, folderPath);

        if (uploadPathFolder.exists() == false) {
            uploadPathFolder.mkdirs(); // 폴더패스가 없으면 폴더만듬
        }
        return folderPath;
    }


    @PostMapping("removeFile")
    public ResponseEntity<Boolean> removeFile(String fileName) {

        String srcFileName = null;
        try {
            srcFileName = URLDecoder.decode(fileName, "UTF-8");
            File file = new File(uploadPath + File.separator + srcFileName); //파일객체 생성

            boolean result = file.delete(); //파일지우기

            File thumbnail = new File((file.getParent()), "s_" + file.getName());

            result = thumbnail.delete(); //썸네일지우기

            return new ResponseEntity<>(result, HttpStatus.OK); //썸네일다지우면 오케이보내주기

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/display")
    public ResponseEntity<byte[]> getFile(String fileName, String size) {
        ResponseEntity<byte[]> result = null;

        try{
            String srcFileName = URLDecoder.decode(fileName, "UTF-8"); //받은파일이름 디코딩
            
            log.info("fileName:" + srcFileName);

            File file = new File(uploadPath + File.separator + srcFileName); //경로에있는 파일찾아서 객체화

            log.info("file path:: " + uploadPath + File.separator + srcFileName);

            if (size != null && size.equals("1")) {
                file = new File(file.getParent(), file.getName().substring(2)); //인덱스 1에는 어떤게 들어있지?
            }

            log.info("file"+file);

            HttpHeaders header = new HttpHeaders(); //해더를 생성

            header.add("Content-Type", Files.probeContentType(file.toPath())); //MIME타입을 Content-Type으로 변환

            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK); //파일 데이터 처리
        }catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }


}
