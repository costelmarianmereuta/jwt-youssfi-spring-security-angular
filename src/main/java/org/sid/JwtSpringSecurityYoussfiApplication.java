package org.sid;

import org.sid.model.Role;
import org.sid.model.Task;
import org.sid.model.User;
import org.sid.repository.TaskRepository;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class JwtSpringSecurityYoussfiApplication implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AccountService accountService;



    public static void main(String[] args) {
        SpringApplication.run(JwtSpringSecurityYoussfiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        accountService.save(new User("admin","1234",null));
        accountService.save(new User("user","1234",null));
        accountService.saveRole(new Role("ADMIN"));
        accountService.saveRole(new Role("USER"));
        accountService.addRoleToUser("admin", "ADMIN");
        accountService.addRoleToUser("user", "USER");




        Stream.of("T1", "T2","T3").forEach(s ->{
            taskRepository.save(new Task(null, s));  });


        taskRepository.findAll().forEach(task -> {
            System.out.println(task.getTaskName());
        });
    }
}

