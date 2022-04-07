package peaksoft.project_rest_api.peaksoft.dto.student;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import peaksoft.project_rest_api.peaksoft.entity.enums.StudyFormat;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class StudentRequestDto {

    String firstName;

    String lastName;

    String email;

    StudyFormat studyFormat;

    Long groupId;

    String password;
}
