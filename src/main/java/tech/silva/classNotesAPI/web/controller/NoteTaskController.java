package tech.silva.classNotesAPI.web.controller;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tech.silva.classNotesAPI.entity.NoteTask;
import tech.silva.classNotesAPI.jwt.JwtUserDetails;
import tech.silva.classNotesAPI.service.NoteTaskService;
import tech.silva.classNotesAPI.web.dto.TaskCreateDto;
import tech.silva.classNotesAPI.web.dto.TaskResponseDto;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
public class NoteTaskController {

    private final NoteTaskService noteTaskService;

    //Method to save new Task
    @PostMapping
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<TaskResponseDto> saveTask(@RequestBody @Valid TaskCreateDto createDto,
                                                    @AuthenticationPrincipal JwtUserDetails userDetails){
        NoteTask task = noteTaskService.saveTask(userDetails.getId(), createDto.toTask());
        return ResponseEntity.status(HttpStatus.CREATED).body(TaskResponseDto.toResponse(task));
    }

    //Method for searching logged in user tasks
    @GetMapping("/current")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<List<TaskResponseDto>> listMyTasks(@AuthenticationPrincipal JwtUserDetails userDetails){
        List<NoteTask> tasks = noteTaskService.findAllByUser(userDetails.getId());
        return ResponseEntity.ok().body(TaskResponseDto.toListTaskResponse(tasks));
    }

    @DeleteMapping("/{idTask}")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<Void> deleteById(@AuthenticationPrincipal JwtUserDetails userDetails,
                                           @PathVariable Long idTask){
        noteTaskService.deleteById(userDetails.getId(), idTask);
        return ResponseEntity.ok().build();
    }
}
