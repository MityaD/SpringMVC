package com.yakut.spring.service;

import com.yakut.spring.exception.NoUserTableException;
import com.yakut.spring.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User save(User user);

    void deleteUserById(Long id);

    List<User> findAllUser();

    User findUserById(Long id) throws NoUserTableException;

    void deleteAll();
}
