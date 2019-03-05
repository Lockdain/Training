package com.lckdn.io.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;

public class IOHelper {

    public static HashMap<String, AverageStudentGrade> createGrades() {
        HashMap<String, AverageStudentGrade> grades = new HashMap<String, AverageStudentGrade>();

        grades.put("1", new AverageStudentGrade("Alex" , 5));
        grades.put("2", new AverageStudentGrade("John" , 3));
        grades.put("3", new AverageStudentGrade("Mary" , 2));
        grades.put("4", new AverageStudentGrade("Jennifer" , 4));
        grades.put("5", new AverageStudentGrade("Luthor" , 5));

        return grades;
    }
}
