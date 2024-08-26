package tech.silva.classNotesAPI.web.dto;

import jakarta.validation.constraints.NotBlank;
import tech.silva.classNotesAPI.entity.NoteTask;

public record TaskCreateDto (@NotBlank
                             String title,
                             @NotBlank
                             String description,
                             @NotBlank
                             String annotation){

    public NoteTask toTask(){
        return new NoteTask(
          title,
          description,
          annotation
        );
    }
}
