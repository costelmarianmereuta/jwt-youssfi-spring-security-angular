package org.sid.service;

import org.sid.model.Role;
import org.sid.model.User;

public interface AccountService {
    public User save(User user);
    public Role saveRole(Role role);
    public  void addRoleToUser(String userName, String roleName);
    public User findUserByUsername(String username);
}
