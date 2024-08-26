package tech.silva.classNotesAPI.web.dto;

import tech.silva.classNotesAPI.entity.NoteTask;

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
}
