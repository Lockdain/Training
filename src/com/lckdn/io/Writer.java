package com.lckdn.io;

import com.lckdn.io.collections.AverageStudentGrade;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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

    public void writeObject(List<Student> students, String fileName) {
       try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
           for (Student student : students) {
               out.writeObject(student);
           }
           out.writeObject(new Student("", -1));
       } catch (IOException e) {
           System.out.println("File cannot be opened. Exiting.");
           e.printStackTrace();
       }
    }
}
