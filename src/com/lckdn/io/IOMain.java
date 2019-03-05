package com.lckdn.io;

import com.lckdn.io.collections.AverageStudentGrade;
import com.lckdn.io.collections.IOHelper;

import java.io.*;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class IOMain {

    private static final String GRADE_BOOK_TXT = "GradeBook.txt";
    private static final String GRADE_BOOK_BYTE_TXT = "GradeBookByte.txt";

    public static void main(String[] args) throws IOException {
        Map<String, AverageStudentGrade> grades = IOHelper.createGrades();
//        writeFile(grades);
//        readFile();

        Formatter formatter = new Formatter("BankAccounts.txt");
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
