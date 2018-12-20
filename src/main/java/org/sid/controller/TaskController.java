package org.sid.controller;

import org.sid.model.Task;
import org.sid.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/tasks")
    public Task save(@RequestBody Task t){

        return taskRepository.save(t);
    }
}
