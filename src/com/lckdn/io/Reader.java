package com.lckdn.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
    }

    public List<Student> readObject(String fileName) {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            boolean keepReading = true;
            while (keepReading) {
                Student student = (Student) in.readObject();
                if (!"".equals(student.getName())) {
                    students.add(student);
                } else {
                    keepReading = false;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void readFullFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
        for (String s : lines) {
            System.out.println(s);
        }
    }
}
