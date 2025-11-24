package com.taskflow.taskflow.repository;

import com.taskflow.taskflow.model.Task;
import com.taskflow.taskflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Bir kullanıcıya ait tüm task'leri getirir
    List<Task> findByUser(User user);
}
