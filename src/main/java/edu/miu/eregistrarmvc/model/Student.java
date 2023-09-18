package edu.miu.eregistrarmvc.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author idurotola on 09/15/22
 * @project eRegistrar-mvc
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue Long studentId;

    @NotNull
    @NotEmpty(message = "Student number cannot be empty")
    @NotBlank(message = "Student number cannot be null or blank")
    @Column(nullable = false)
    private String studentNumber;

    @NotEmpty(message = "Student Firstname cannot be empty")
    @NotBlank(message = "Student Firstname cannot be null or blank")
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String middleName;

    @NotEmpty(message = "Student Lastname cannot be empty")
    @NotBlank(message = "Student Lastname cannot be null or blank")
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private double cgpa;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;

    @Column(nullable = false)
    private String isInternational;

    @NotNull
    @NotEmpty(message = "Gender cannot be empty")
    @NotBlank(message = "Gender cannot be null or blank")
    private String gender;

    @Column(columnDefinition="boolean default false")
    private boolean fpp=false;

    public Student(String studentNumber, String firstName, String middleName,
                   String lastName, double cgpa,
                   LocalDate enrollmentDate, String isInternational, String gender, boolean fpp) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
        this.gender = gender;
        this.fpp = fpp;
    }
}
