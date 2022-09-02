package com.example.restfulService;

import com.example.restfulService.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class UserService {

    private static List<User> userList = new ArrayList<>();
    private static Long userCount = 4L;

    static{
        userList.add(new User(1L,"kimyubi1",new Date()));
        userList.add(new User(2L,"kimyubi2",new Date()));
        userList.add(new User(3L,"kimyubi3",new Date()));
        userList.add(new User(4L,"kimyubi4",new Date()));
    }

    public List<User> findAll(){
        return userList;
    }

    public User findById(Long id){
        for(User user : userList){
            if (user.getId().equals(id)){
                return user;
            }
        }

        return null;
    }

    public User save(User user){
        if (user.getId() == null){
            user.setId(++ userCount);
        }

        userList.add(user);
        return user;
    }

}

