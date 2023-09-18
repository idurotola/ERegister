package edu.miu.eregistrarmvc.service;

import edu.miu.eregistrarmvc.model.Student;

import java.util.List;

/**
 * @author idurotola on 09/15/22
 * @project eRegistrar-mvc
 */
public interface StudentService {

    Student addNewStudent(Student student);

    List<Student> addNewStudents(List<Student> students);

    List<Student> getAllStudents();

    Student getStudentById(Long studentId) throws IllegalArgumentException;

    List<Student> searchStudent(String firstName) throws IllegalArgumentException;

    Student updateStudent(Student updatedStudent);

    void deleteStudentById(Long studentId);

}
