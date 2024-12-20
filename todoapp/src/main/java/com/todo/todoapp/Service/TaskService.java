package com.todo.todoapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.repository.TaskRepository;

//Srevice class handles business login and create a reference of repositior class

@Service
public class TaskService {

	private final TaskRepository taskrepository;
	
	
	public TaskService(TaskRepository taskrepository) {
		this.taskrepository = taskrepository;
	}


	public List<Task> getAllTask() {
		return taskrepository.findAll();
	}


	public void createTask(String title) {
		Task task= new Task();
		task.setTitle(title);
		task.setCompleted(false);
		taskrepository.save(task);
	}


	public void deleteTask(Long id) {
		taskrepository.deleteById(id);
		
	}


	public void toggleTask(Long id) {
		Task task =taskrepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Task Id"));
		task.setCompleted(!task.isCompleted());
		taskrepository.save(task);
	
		
	}

}
