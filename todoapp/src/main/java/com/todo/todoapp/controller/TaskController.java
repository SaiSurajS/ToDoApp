package com.todo.todoapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.todoapp.Service.TaskService;
import com.todo.todoapp.models.Task;


// Handles the request from client and respond
//create reference for service class
//Connect with the HTML using thymeleaf- Java Template Engine


@Controller
//@RequestMapping("/tasks")
public class TaskController {
	
	private final TaskService taskservice;

	public TaskController(TaskService taskservice) {
		this.taskservice = taskservice;
	}
	
	@GetMapping
	public String getTasks(Model model) {
		List<Task> tasks=taskservice.getAllTask();
		model.addAttribute("tasks", tasks);                                //access to the object
		return "tasks";                                                    //Thymeleaf template under resources
		
	}
	
	
	@PostMapping
	public String createTask(@RequestParam String title) { //param should same name as name of input
		taskservice.createTask(title);                            
		return "redirect:/";                                                    
		
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable Long id) {
		taskservice.deleteTask(id);                               
		return "redirect:/";                                                   
		
	}
	
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable Long id) {
		taskservice.toggleTask(id);                               
		return "redirect:/";                                                   
		
	}
}
