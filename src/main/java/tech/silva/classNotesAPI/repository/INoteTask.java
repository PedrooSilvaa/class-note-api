package tech.silva.classNotesAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.classNotesAPI.entity.NoteTask;

public interface INoteTask extends JpaRepository<NoteTask, Long> {
}
