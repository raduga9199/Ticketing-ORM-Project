package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Role;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserService {

    List<UserDTO> listAllUser();
    UserDTO findByUserName(String username);
    // SELECT * FROM USERS WHERE ROLES='manager'
    List<UserDTO> listAllByRole(String role);
    User assignedManager();


    void save(UserDTO dto);
    UserDTO update(UserDTO dto);
    void deleteByUserName(String username);
    void delete(String username);

}
