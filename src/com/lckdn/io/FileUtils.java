package com.lckdn.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
}
