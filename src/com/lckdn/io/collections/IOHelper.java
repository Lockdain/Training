package com.lckdn.io.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;

public class IOHelper {

    public static HashMap<String, AverageStudentGrade> createGrades() {
        HashMap<String, AverageStudentGrade> grades = new HashMap<String, AverageStudentGrade>();

        grades.put("1", new AverageStudentGrade("Alex" , 65));
        grades.put("2", new AverageStudentGrade("John" , 70));
        grades.put("3", new AverageStudentGrade("Mary" , 82));
        grades.put("4", new AverageStudentGrade("Jennifer" , 74));
        grades.put("5", new AverageStudentGrade("Luthor" , 65));
        grades.put("6", new AverageStudentGrade("Mike" , 95));
        grades.put("7", new AverageStudentGrade("Ken" , 75));

        return grades;
    }
}
