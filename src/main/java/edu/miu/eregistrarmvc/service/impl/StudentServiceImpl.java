package edu.miu.eregistrarmvc.service.impl;

import edu.miu.eregistrarmvc.model.Student;
import edu.miu.eregistrarmvc.repository.StudentRepository;
import edu.miu.eregistrarmvc.service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author idurotola on 09/15/22
 * @project eRegistrar-mvc
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addNewStudent(Student student) {
        var newStudent = studentRepository.save(student);
        return newStudent;
    }

    @Override
    public List<Student> addNewStudents(List<Student> students) {
        var newStudents = studentRepository.saveAll(students);
        return newStudents;
    }

    @Override
    public List<Student> getAllStudents() {
        var students = studentRepository.findAll(Sort.by("firstName"));
        return students;
    }

    @Override
    public Student getStudentById(Long studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalArgumentException("Student with ID " + studentId +  " Not Found"));
    }

    @Override
    public List<Student> searchStudent(String searchParam){
        return studentRepository.findBySearchParam(searchParam)
                .orElseThrow(()-> new IllegalArgumentException("Student with Firstname " + searchParam +  " Not Found"));
    }

    @Override
    public Student updateStudent(Student updatedStudent) {
        return studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
