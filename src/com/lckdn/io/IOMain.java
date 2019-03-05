package com.lckdn.io;

import com.lckdn.io.collections.AverageStudentGrade;
import com.lckdn.io.collections.IOHelper;

import java.io.*;
import java.util.Map;

public class IOMain {

    private static final String GRADE_BOOK_TXT = "GradeBook.txt";
    private static final String GRADE_BOOK_BYTE_TXT = "GradeBookByte.txt";

    public static void main(String[] args) throws IOException {
        Map<String, AverageStudentGrade> grades = IOHelper.createGrades();
        writeFile(grades);
        readFile();

        try (FileInputStream reader = new FileInputStream(GRADE_BOOK_TXT); FileOutputStream writer = new FileOutputStream(GRADE_BOOK_BYTE_TXT)) {

            int c;
            while ((c = reader.read()) != -1) {
                System.out.println(c);
                writer.write(c);
            }
        }
    }

    private static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(GRADE_BOOK_TXT));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
    }

    private static void writeFile(Map<String, AverageStudentGrade> grades) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(GRADE_BOOK_TXT))) {
            for (Map.Entry<String, AverageStudentGrade> entry : grades.entrySet()) {
                writer.write("======================\n");
                writer.write("Student: " + entry.getValue().getName() + "\nAverage grade: " + entry.getValue().getAverageGrade() + "\n");
            }
            writer.flush();
        }
    }
}
