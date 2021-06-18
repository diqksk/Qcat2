package com.Qcat.Qcat.chat.controller;

import com.Qcat.Qcat.chat.service.ChatService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Controller
@ServerEndpoint("/websocket")
public class MessageController extends Socket {
    private static final List<Session> session = new ArrayList<Session>();

    @Autowired
    ChatService chatService;


    @GetMapping("/")
    public String index(){
        return "/chat/chat";
    }

    @OnOpen
    public void open(Session newUser) {
        System.out.println("connected");
        session.add(newUser);
        System.out.println(newUser.getId());
    }

    @OnClose
    public void close(Session closedUser){
        System.out.println("closed");
        for(int i = 0 ; i < session.size() ; i++){
            if (session.get(i) == closedUser) {
                session.remove(i);
                System.out.println("사용자 지워짐");
            }
        }

    }

    @OnError
    public void onError(Session session, Throwable thr){
        System.out.println("에러입니다에러ㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ");
        System.out.println(thr);
    }

    @OnMessage
    public void getMsg(Session recieveSession, String msg){

        for (int i = 0; i < session.size(); i++) {
            if (!recieveSession.getId().equals(session.get(i).getId())) {
                try {
                    session.get(i).getBasicRemote().sendText(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
