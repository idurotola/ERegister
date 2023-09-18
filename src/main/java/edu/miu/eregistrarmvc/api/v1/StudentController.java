package edu.miu.eregistrarmvc.api.v1;

import edu.miu.eregistrarmvc.model.Student;
import edu.miu.eregistrarmvc.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author idurotola on 09/15/22
 * @project eRegistrar-mvc
 */
@Controller
@RequestMapping(value = "/eregistrar/students/")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/about")
    public String displayAboutPage(){
        return "/public/about";
    }

    @GetMapping(value = "/list")
    public ModelAndView listStudents() {
        var students = studentService.getAllStudents();
        var searchParam="";
        System.out.println("Students :: " + students);
        var modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchParam", searchParam);
        modelAndView.setViewName("secured/students/list");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String displayNewPublisherForm(Model model) {
        var newStudent = new Student();
        model.addAttribute("student", newStudent);
        return "secured/students/new";
    }

    @PostMapping(value = {"/new"}) // PRG: Post-Redirect-Get
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/students/new";
        }
        studentService.addNewStudent(student);
        return "redirect:/eregistrar/students/list";
    }

    @GetMapping(value = "/edit/{studentId}")
    public String displayEditStudentForm(Model model, @PathVariable Long studentId) throws IllegalArgumentException {
        var student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "/secured/students/edit";
        }
        return "redirect:/eregistrar/students/list";
    }

    @PostMapping(value = "/update")
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/edit";
        }
        studentService.updateStudent(student);
        return "redirect:/eregistrar/students/list";

    }

    @GetMapping(value = "/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/students/list";
    }

    @GetMapping(value = "/search")
    public String searchStudent(Model model, @RequestParam("search") String search) {
        var students = studentService.searchStudent(search);
        model.addAttribute("students", students);
        return "secured/students/list";
    }

}
