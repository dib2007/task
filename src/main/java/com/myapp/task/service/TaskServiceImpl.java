package com.myapp.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.task.dao.TaskRepository;
import com.myapp.task.entity.node.Task;

@Service("taskService")
public class TaskServiceImpl {

	@Autowired
	TaskRepository taskRepository;

	public Task getById(long id) {
		return taskRepository.findOne(id);
	}

	public Task saveOrUpdate(Task task) {
		taskRepository.save(task);
		return task;
	}

	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(t -> tasks.add(t));
		return tasks;
	}
}
