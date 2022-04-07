package peaksoft.project_rest_api.peaksoft.entity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.project_rest_api.peaksoft.entity.entities.AuthenticationInfo;
import peaksoft.project_rest_api.peaksoft.entity.entities.Course;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.*;

@Entity
@Table
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "firs_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "email", nullable = false)
    String email;

    @JsonIgnore
    @OneToOne(cascade = ALL, fetch = LAZY)
    @JoinColumn(name = "course_id")
    Course course;

    @OneToOne(
            optional = false,
            cascade = {PERSIST, REMOVE, REFRESH},
            fetch = LAZY
    )
    AuthenticationInfo authenticationInfo;
}
