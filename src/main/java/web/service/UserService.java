package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    User readUserById(Long id);
    void updateUser(User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
