package com.test.exceptionhandlingspringbootapp.controller;

import com.test.exceptionhandlingspringbootapp.core.result.DataResult;
import com.test.exceptionhandlingspringbootapp.core.result.Result;
import com.test.exceptionhandlingspringbootapp.entity.User;
import com.test.exceptionhandlingspringbootapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public Result add(@Valid @RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping
    public DataResult<List<User>> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<User> getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id) {
        return userService.delete(id);
    }
}
