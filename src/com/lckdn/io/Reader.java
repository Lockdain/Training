package com.lckdn.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
    }
}
