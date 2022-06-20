package com.studentlist.studentlist.controllers;

import com.studentlist.studentlist.DB.Database;
import com.studentlist.studentlist.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<Student> students = Database.getAllStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping(value = "/addstudent")
    public String addStudent(){
        return "addstudent";
    }

    @PostMapping(value = "/addstudent")
    public String addStudent(@RequestParam(name = "first") String first,
                             @RequestParam(name = "last") String last,
                             @RequestParam(name = "exam") int exam){
        Student student = new Student();
        student.setFirst(first);
        student.setLast(last);
        student.setExam(exam);
        String Mark = "F";
        if(exam >= 50 && exam < 60)
            Mark = "D";
        if(exam >= 60 && exam < 75)
            Mark = "C";
        if(exam >= 75 && exam < 90)
            Mark = "B";
        if(exam >= 90)
            Mark = "A";
        student.setGrade(Mark);
        Database.addStudent(student);
        return "redirect:/";
    }
}
