package com.studentlist.studentlist.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    Long id;
    String first;
    String last;
    int exam;
    String grade;
}
