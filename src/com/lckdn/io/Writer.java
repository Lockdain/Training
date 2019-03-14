package com.lckdn.io;

import com.lckdn.io.collections.AverageStudentGrade;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    public void nioWriteWithBuffer(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(fileName, 0, fileName.length());
        }
    }

    public void nioWriteWithStream(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        String str = "File cannot be opened. Exiting.";
        byte[] bytes = str.getBytes();
        try (OutputStream stream = Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            stream.write(bytes, 0, bytes.length);
        }
    }

    public void nioWriteWithChannel(String fileName) throws IOException {
        String str = "You can also create a new file by using the newOutputStream methods" +
                " as described in Creating and writing a File using Stream I/O. " +
                "If you open a new output stream and close it immediately, an empty file is created.";

        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();

        byte[] bytes = str.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.clear();
        buffer.compact();
        buffer.mark();
        buffer.reset();
        channel.write(buffer);
        channel.close();
    }
}
