package com.example.websocket.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @MessageMapping("/user.addUser")
    @SendTo("/topic/user")
    public User addUser(
           @Payload User user
    ){
        service.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/topic/user")
    public User disconnect(
            @Payload User user
    ){
        service.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers(){
        return ResponseEntity.ok(service.findConnectedUsers());
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> allTheUsers(){
        return ResponseEntity.ok(service.findAlLUsers());
    }
}
