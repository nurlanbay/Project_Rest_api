package peaksoft.project_rest_api.peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.project_rest_api.peaksoft.entity.entities.Course;


public interface CourseRepo extends JpaRepository<Course,Long> {

     @Query("select case when count (c) > 0 then true else false end " +
             "from Course c where c.courseName = :courseName")
    boolean existsByCourseName(@Param("courseName") String name);
}
