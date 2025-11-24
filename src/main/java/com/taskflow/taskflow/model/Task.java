package com.taskflow.taskflow.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private boolean completed = false;

    // Bir kullanıcıya bağlı task
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
