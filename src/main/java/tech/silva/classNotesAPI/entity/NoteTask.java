package tech.silva.classNotesAPI.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "NoteTask")
public class NoteTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private UserEntity user;
    private LocalDateTime date = LocalDateTime.now();

    public NoteTask(String title, String description, UserEntity user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }
}
