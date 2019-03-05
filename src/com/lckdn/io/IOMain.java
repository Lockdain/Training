package com.lckdn.io;

import com.lckdn.io.collections.AverageStudentGrade;
import com.lckdn.io.collections.IOHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IOMain {

    public static void main(String[] args) {
        Map<String, AverageStudentGrade> grades = IOHelper.createGrades();
        FileWriter writer = null;
        try {
            writer = new FileWriter("GradeBook.txt");

            for (Map.Entry<String, AverageStudentGrade> entry : grades.entrySet()) {

                writer.write("======================\n");
                writer.write("Student: " + entry.getValue().getName() + "\nAverage grade: " + entry.getValue().getAverageGrade() + "\n");
            }
            //writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
