package com.example.nt.Video.VideoCallApplication.User;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private String userName;
    private String email;
    private String password;
    private String status;

}