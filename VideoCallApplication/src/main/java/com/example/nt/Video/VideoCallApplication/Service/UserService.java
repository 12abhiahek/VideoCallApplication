package com.example.nt.Video.VideoCallApplication.Service;

import com.example.nt.Video.VideoCallApplication.User.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
    private static final List<User> UserList=new ArrayList<>();

    public void  register(User user){
        user.setStatus("Online");
        UserList.add(user);
    }
    public User login(User user){
        var userIndex= IntStream.range(0,UserList.size())
                .filter(u->UserList.get(u).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(()->new RuntimeException("User Not Found"));

        var connectedUser=UserList.get(userIndex);
        if(!connectedUser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("User Password is not match");

        }
        connectedUser.setStatus("Online");
        return connectedUser;
    }

   public void logout(String email){
        var userIndex=IntStream.range(0,UserList.size())
                .filter(u->UserList.get(u).getEmail().equals(email))
                .findAny()
                .orElseThrow(()->new RuntimeException("User Not Found"));
        UserList.get(userIndex).setStatus("Offline");

   }
   public List<User>findAll(){
        return UserList;
   }

}
