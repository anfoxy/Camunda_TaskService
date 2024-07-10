package com.example.task_service.service.jpa;


import com.example.task_service.entity.UserEntity;
import com.example.task_service.repository.UsersRepository;
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