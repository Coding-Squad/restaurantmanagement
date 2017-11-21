package com.restaurant.management.services.impl;

import com.restaurant.management.model.Role;
import com.restaurant.management.model.Users;
import com.restaurant.management.repository.RoleRepository;
import com.restaurant.management.repository.UsersRepository;
import com.restaurant.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Programmer on 21-Nov-17.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Qualifier("usersRepository")
    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Qualifier("roleRepository")
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setPassword(user.getPassword());
        user.setActive(1);
        /*Role userRole = roleRepository.findByRole("GENERAL");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));*/

        userRepository.save(user);
    }
}
