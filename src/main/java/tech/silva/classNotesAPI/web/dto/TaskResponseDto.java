package tech.silva.classNotesAPI.web.dto;

import tech.silva.classNotesAPI.entity.NoteTask;

import java.util.List;
import java.util.stream.Collectors;

public record TaskResponseDto (Long id,
                               String username,
                               String title,
                               String descrption,
                               String annotation){

    public TaskResponseDto(Long id, String username, String title, String descrption, String annotation) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.descrption = descrption;
        this.annotation = annotation;
    }

    public static TaskResponseDto toResponse(NoteTask noteTask){
        return new TaskResponseDto(
                noteTask.getId(),
                noteTask.getUser().getUsername(),
                noteTask.getTitle(),
                noteTask.getDescription(),
                noteTask.getAnnotation()
        );
    }

    public static List<TaskResponseDto> toListProductResponse(List<NoteTask> products){
        return products.stream()
                .map(product -> toResponse(product)).collect(Collectors.toList());
    }
}
