package com.myapp.task.dao;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.myapp.task.entity.node.Task;

@Repository("taskRepository")
public interface TaskRepository extends GraphRepository<Task>{
	
}
