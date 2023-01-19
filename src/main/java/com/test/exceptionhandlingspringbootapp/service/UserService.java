package com.test.exceptionhandlingspringbootapp.service;

import com.test.exceptionhandlingspringbootapp.core.result.DataResult;
import com.test.exceptionhandlingspringbootapp.core.result.Result;
import com.test.exceptionhandlingspringbootapp.core.result.SuccessDataResult;
import com.test.exceptionhandlingspringbootapp.core.result.SuccessResult;
import com.test.exceptionhandlingspringbootapp.entity.User;
import com.test.exceptionhandlingspringbootapp.exception.CustomException;
import com.test.exceptionhandlingspringbootapp.exception.ErrorStatus;
import com.test.exceptionhandlingspringbootapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Result add(User user) {
        userRepository.save(user);
        return new SuccessResult("User added. Name: " + user.getName());
    }

    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(userRepository.findAll(), "All users listed.");
    }

    public DataResult<User> getById(long id) {
        return new SuccessDataResult<>(userRepository.findById(id)
                .orElseThrow(
                        () -> new CustomException(ErrorStatus.USER_NOT_FOUND)), "User listed.");
    }

    public Result delete(long id) {
        userRepository.deleteById(id);
        return new SuccessResult(id + ". user deleted.");
    }
}
