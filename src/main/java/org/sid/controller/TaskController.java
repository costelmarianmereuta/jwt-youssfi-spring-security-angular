package org.sid.controller;

import org.sid.model.Task;
import org.sid.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> taskList(){

        return taskRepository.findAll();
    }

//Request body permet de dire a spring qu'il cherche le contenu de la requete et c'est ça qui va mettre dans
// le task - dans notre cas cest ce que nous avnons tapé dans json
    @Secured("ROLE_USER")
    @PostMapping("/tasks")
    public Task save(@RequestBody Task t){

        return taskRepository.save(t);
    }
}
