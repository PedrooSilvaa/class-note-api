package tech.silva.classNotesAPI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.silva.classNotesAPI.repository.INoteTaskRepository;

@AllArgsConstructor
@Service
public class NoteTaskService {

    private final INoteTaskRepository noteTaskRepository;

}

