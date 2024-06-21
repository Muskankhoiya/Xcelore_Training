package com.example.microservices.entiity;





import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;


import java.util.ArrayList;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(name = "user ID", example = "1", required = true)
    private Long id;

    @Schema(name = "user name", example = "muskan khoiya", required = true)
    private String name;

    @Schema(name = "email", example = "muskankhoiya@gmail.com", required = true)
    private String email;
    private String password;

    public User(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;

    }

    // No-argument constructor
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
