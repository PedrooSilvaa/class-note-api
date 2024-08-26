package tech.silva.classNotesAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.classNotesAPI.entity.NoteTask;
import tech.silva.classNotesAPI.entity.UserEntity;

import java.util.List;

public interface INoteTaskRepository extends JpaRepository<NoteTask, Long> {
    List<NoteTask> findAllByUser(UserEntity user);
}
