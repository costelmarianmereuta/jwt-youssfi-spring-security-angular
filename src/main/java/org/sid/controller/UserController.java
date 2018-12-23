package org.sid.controller;

import org.sid.model.RegisterForm;
import org.sid.model.User;
import org.sid.repository.UserRepository;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AccountService accountService;



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterForm registerForm) throws RuntimeException{



        if (!registerForm.getPassword().equals(registerForm.getConfirmPassword()))
            return new ResponseEntity<>("the password doesn't match", HttpStatus.BAD_REQUEST);

        User user=accountService.findUserByUsername(registerForm.getUsername());

      if (user != null)
          return new ResponseEntity<>("user already exists", HttpStatus.BAD_REQUEST);

        user=new User();
        user.setUsername(registerForm.getUsername());
        user.setPassword(registerForm.getPassword());
        accountService.save(user);
        accountService.addRoleToUser(user.getUsername(),"USER");

        return new ResponseEntity<>(user, HttpStatus.OK) ;
    }
}
