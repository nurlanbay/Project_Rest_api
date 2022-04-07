package peaksoft.project_rest_api.peaksoft.entity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import peaksoft.project_rest_api.peaksoft.entity.enums.Role;
import peaksoft.project_rest_api.peaksoft.entity.enums.StudyFormat;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.FetchType.LAZY;
import static peaksoft.project_rest_api.peaksoft.entity.enums.Role.*;

@Entity
@Setter
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;

    String lastName;

    String email;

    StudyFormat studyFormat;

    @JsonIgnore
    @ManyToOne(cascade = {PERSIST, MERGE}, fetch = FetchType.LAZY)
    Group group;

    @OneToOne(cascade = {PERSIST, REMOVE, REFRESH})
    AuthenticationInfo authenticationInfo;

}
