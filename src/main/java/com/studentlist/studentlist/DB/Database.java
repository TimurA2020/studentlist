package com.studentlist.studentlist.DB;

import com.studentlist.studentlist.models.Student;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Database {
    static ArrayList<Student> students = new ArrayList<>();
    private static long id = 3L;

    public static ArrayList<Student> getAllStudents(){
        return students;
    }

    public static void addStudent(Student student){
        student.setId(id);
        students.add(student);
        id++;
    }

    static {
        students.add(new Student(1L, "John", "Doe", 50, "F"));
        students.add(new Student(2L, "John", "Doe", 60, "D"));
        students.add(new Student(3L, "John", "Doe", 90, "A"));
    }

    public static Student getStudent(Long id){
        return getAllStudents().stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);
    }

}
