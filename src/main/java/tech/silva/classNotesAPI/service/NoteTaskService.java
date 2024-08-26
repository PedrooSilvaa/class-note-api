package tech.silva.classNotesAPI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.silva.classNotesAPI.entity.NoteTask;
import tech.silva.classNotesAPI.entity.UserEntity;
import tech.silva.classNotesAPI.exception.ObjectNotFoundException;
import tech.silva.classNotesAPI.repository.INoteTaskRepository;
import tech.silva.classNotesAPI.repository.IUserRepository;
import tech.silva.classNotesAPI.web.dto.TaskCreateDto;

@AllArgsConstructor
@Service
public class NoteTaskService {

    private final INoteTaskRepository noteTaskRepository;
    private final IUserRepository userRepository;

    public NoteTask saveTask(Long id, NoteTask noteTask) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(
                () -> new ObjectNotFoundException(String.format("User id: %s not found", id))
        );

        noteTask.setUser(user);
        return noteTaskRepository.save(noteTask);
    }

}

