package com.taskflow.taskflow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore       // JSON'a çevirirken bu alanı atla (Döngüyü kırar)
    @ToString.Exclude // <--- YENİ EKLEME: Lombok'un yazdırırken döngüye girmesini engeller
    private User user;
}