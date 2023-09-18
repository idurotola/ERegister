package edu.miu.eregistrarmvc;

import edu.miu.eregistrarmvc.model.Student;
import edu.miu.eregistrarmvc.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ERegistrarMvcApplication implements CommandLineRunner {

    private final StudentService studentService;

    public ERegistrarMvcApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ERegistrarMvcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student alex = new Student("611112",
                "Robert",
                "Benjamin",
                "Martin",
                4.0,
                LocalDate.of(2022, 1, 1),
                "Yes",
                "Male",
                true);
        Student dave = new Student("611113",
                "Joe",
                "",
                "Rogan",
                3.9,
                LocalDate.of(2021, 1, 1),
                "No",
                "Male",
                false);

        Student wayne = new Student("611114",
                "Wayne",
                "",
                "Rooney",
                3.8,
                LocalDate.of(2020, 2, 11),
                "No",
                "Male",
                false);

        Student christiano = new Student("611115",
                "Christiano",
                "",
                "Ronaldo",
                4.0,
                LocalDate.of(2020, 12, 12),
                "Yes",
                "Male",
                true);

        Student ryan = new Student("611116",
                "Ryan",
                "Mathew",
                "Holiday",
                2.0,
                LocalDate.of(2021, 7, 7),
                "No",
                "Male",
                false);


        List<Student> students = studentService.addNewStudents(List.of(alex, dave, wayne, christiano, ryan));

    }
}
