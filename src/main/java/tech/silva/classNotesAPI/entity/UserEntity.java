package tech.silva.classNotesAPI.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    public UserEntity(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
