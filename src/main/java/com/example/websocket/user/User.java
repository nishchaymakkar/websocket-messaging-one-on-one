package com.example.websocket.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Users")
public class User {

    @Id
    private String nickName;
    private String fullName;
    private Status status;
}
