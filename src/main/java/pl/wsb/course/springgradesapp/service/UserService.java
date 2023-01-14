package pl.wsb.course.springgradesapp.service;

import pl.wsb.course.springgradesapp.model.User;
import pl.wsb.course.springgradesapp.model.dto.UserDto;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
}
