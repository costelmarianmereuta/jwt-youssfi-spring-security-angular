package org.sid.service;

import org.sid.model.Role;
import org.sid.model.User;
import org.sid.repository.RoleRepository;
import org.sid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role) ;
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {

        User user=userRepository.findByUsername(userName);
        Role role= roleRepository.findRoleByRoleName(roleName);

        user.getRoles().add(role);

        userRepository.save(user);

    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
