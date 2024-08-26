package tech.silva.classNotesAPI.web.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.silva.classNotesAPI.service.NoteTaskService;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "/api/v1/tasks")
public class NoteTaskController {

    private final NoteTaskService noteTaskService;

}
