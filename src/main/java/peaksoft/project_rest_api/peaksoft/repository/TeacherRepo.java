package peaksoft.project_rest_api.peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.project_rest_api.peaksoft.entity.entities.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    @Query("select case when count (t) > 0 then true else false end "+
    "from Teacher t where t.email = :email")
    boolean existsByEmail(@Param("email") String email);
}
