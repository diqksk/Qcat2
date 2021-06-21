package com.Qcat.Qcat.admin.repository;

import com.Qcat.Qcat.market.domain.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdminMapper {
    List<HashMap<String, Object>> getResumeList(Criteria cri);
    int countTotalResume();
    int createNewStore(HashMap<String, String> formInfo);
    int updateResumeRole(HashMap<String, String> formInfo);
    int refuseResume(HashMap<String, String> formInfo);
}
