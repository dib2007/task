package com.myapp.task.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.task.entity.node.Task;
import com.myapp.task.service.TaskServiceImpl;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	@Qualifier("taskService")
	TaskServiceImpl taskService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Task getTask(@PathVariable("id") long id) {
		return taskService.getById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveTask(@RequestAttribute Task task) {
		taskService.saveOrUpdate(task);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}
}
