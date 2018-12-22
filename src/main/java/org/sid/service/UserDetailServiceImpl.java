package org.sid.service;

import org.sid.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User  user=accountService.findUserByUsername(username);

        if (user==null)throw new UsernameNotFoundException("the user "+ username+" doesn't exists");

        Collection<GrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(role -> {( authorities).add(new SimpleGrantedAuthority((role.getRoleName())));});

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
    }
}
