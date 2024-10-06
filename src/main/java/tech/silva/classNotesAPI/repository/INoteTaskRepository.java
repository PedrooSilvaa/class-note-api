package tech.silva.classNotesAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.classNotesAPI.entity.NoteTask;
import tech.silva.classNotesAPI.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface INoteTaskRepository extends JpaRepository<NoteTask, Long> {
    List<NoteTask> findAllByUser(UserEntity user);

    Optional<NoteTask> findByIdAndUser(Long idTask, UserEntity user);
}
