package com.lckdn.io;

import com.lckdn.io.collections.AverageStudentGrade;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Writer {
    public void writeWithFormatter(String fileName) throws FileNotFoundException {
        Formatter formatter = new Formatter(fileName);
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        System.out.println("Insert your clientId, clientName and surname:");
        while (i < 3) {
            try {
                formatter.format("%d, %s, %s", scanner.nextInt(), scanner.next(), scanner.next() + "\n");
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Input was incorrect. Try again!");
                scanner.nextLine();
            }
        }
        formatter.close();
    }

    public void writeFile(Map<String, AverageStudentGrade> grades, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, AverageStudentGrade> entry : grades.entrySet()) {
                writer.write("======================\n");
                writer.write("Student: " + entry.getValue().getName() + "\nAverage grade: " + entry.getValue().getAverageGrade() + "\n");
            }
            writer.flush();
        }
    }
}
