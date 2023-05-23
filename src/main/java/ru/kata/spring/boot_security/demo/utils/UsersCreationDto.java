package ru.kata.spring.boot_security.demo.utils;

import lombok.Data;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsersCreationDto {
    private List<User> users;

    public UsersCreationDto() {
        this.users = new ArrayList<>();
    }

    public UsersCreationDto(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
