package com.lckdn.io;

import com.lckdn.io.collections.AverageStudentGrade;
import com.lckdn.io.collections.IOHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IOMain {

    public static final String STUDENTS_BIN = "Students.bin";

    public static void main(String[] args) throws IOException {
        Map<String, AverageStudentGrade> grades = IOHelper.createGrades();
        // read file
        Reader reader = new Reader();
        reader.readFile(Constants.GRADE_BOOK_TXT);

        // write file
        Writer writer = new Writer();
//        writer.writeFile(grades, Constants.GRADE_BOOK_TXT);
//        writer.writeWithFormatter(Constants.BANK_ACCOUNTS__TXT);

        processGrades(grades, writer, STUDENTS_BIN);

    }

    private static void processGrades(Map<String, AverageStudentGrade> grades, Writer writer, String fileName) {
        List<Student> students = new ArrayList<>();

        for (Map.Entry<String, AverageStudentGrade> entry : grades.entrySet()) {
            students.add(new Student(entry.getValue().getName(), entry.getValue().getAverageGrade()));
        }

        writer.writeObject(students, fileName);
    }

}
