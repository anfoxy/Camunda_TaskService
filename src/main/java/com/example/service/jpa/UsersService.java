package com.example.service.jpa;


import com.example.entity.UserEntity;
import com.example.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public UserEntity saveTask(UserEntity user) {
        return usersRepository.save(user);
    }

    public List<UserEntity> getAllTasks() {
        return usersRepository.findAll();
    }

}