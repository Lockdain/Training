package com.lckdn.io;

import java.io.*;
import java.nio.file.*;

public class FileUtils {

    public void printIOFileDetails(String path) throws IOException {
        File file = new File(path);

        // Get path details
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Relative path: " + file.getPath());
        System.out.println("Free space in mb: " + file.getFreeSpace() / 1000000);
        System.out.println("Parent directory: " + file.getParent());
        System.out.println("Is absolute path: " + file.isAbsolute());

        System.out.println("Current directory is: " + System.getProperty("user.dir"));

        if (file.isDirectory()) {
            System.out.println("It is a directory. Printing content:");
            String[] list = file.list();
            if (list != null) {
                for (String s : list) {
                    System.out.println(s);
                }
            }

        } else {
            System.out.println("This is a file.");
            System.out.println("Creating a new file " + file.createNewFile());

            // Permissions
            System.out.println("Can read - " + file.canRead());
            System.out.println("Can write - " + file.canWrite());
            System.out.println("Can execute - " + file.canExecute());
            System.out.println("File is hidden - " + file.isHidden());
            System.out.println("Last modified - " + file.lastModified());

//            FileInputStream in = new FileInputStream(file);
//            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        }
    }

    public void printNioFileDetails(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Path path1 = FileSystems.getDefault().getPath(fileName);

        System.out.println("File name: " + path.getFileName());
        Path absPath = path.toAbsolutePath();
        System.out.println("Absolute path: " + absPath);
        System.out.println("Root dir: " + absPath.getRoot());
        System.out.println("Parent dir: " + absPath.getParent());
        System.out.println("Name count: " + path.getNameCount());
        System.out.println("Subpath: " + absPath.subpath(0, 2));
        Path path3 = Paths.get("../../");
        System.out.println("Real path: " + path3.toRealPath());

        System.out.println("File exists: " + Files.exists(path));
        System.out.println("File doesn't exist: " + Files.notExists(path));

        System.out.println("Is readable: " + Files.isReadable(path));
        System.out.println("Is writable: " + Files.isWritable(path));
        System.out.println("Is executable: " + Files.isExecutable(path));

        System.out.println("Is same file: " + Files.isSameFile(path, path1));

        Path parentPath = absPath.getParent();
        Path filesPath = parentPath.resolve("files");

        if (Files.notExists(filesPath)) {
            Files.createDirectory(filesPath);
        }
        Files.copy(absPath, filesPath.resolve(path), StandardCopyOption.REPLACE_EXISTING);
        Files.delete(filesPath);
    }
}
