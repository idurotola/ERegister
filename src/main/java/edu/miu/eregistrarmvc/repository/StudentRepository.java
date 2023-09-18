package edu.miu.eregistrarmvc.repository;

import edu.miu.eregistrarmvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author idurotola on 09/15/22
 * @project eRegistrar-mvc
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select s from Student s where s.firstName like %:searchParam% or " +
            "s.lastName like %:searchParam% or " +
            "s.middleName like %:searchParam% or " +
            "s.studentNumber like %:searchParam% or " +
            "s.isInternational like %:searchParam% ")
    Optional<List<Student>> findBySearchParam(String searchParam);
}
