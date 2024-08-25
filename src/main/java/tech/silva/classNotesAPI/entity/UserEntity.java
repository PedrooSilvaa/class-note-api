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
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    private Role role = Role.CLIENT;

    public enum Role{
        CLIENT, ADMIN
    }

    public UserEntity(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
