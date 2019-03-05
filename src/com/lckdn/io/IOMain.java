package com.lckdn.io;

import com.lckdn.io.collections.AverageStudentGrade;
import com.lckdn.io.collections.IOHelper;

import java.io.*;
import java.util.Map;

public class IOMain {

    public static void main(String[] args) throws IOException {
        Map<String, AverageStudentGrade> grades = IOHelper.createGrades();
        // read file
        Reader reader = new Reader();
        reader.readFile(Constants.GRADE_BOOK_TXT);

        // write file
        Writer writer = new Writer();
        writer.writeFile(grades, Constants.GRADE_BOOK_TXT);
        writer.writeWithFormatter(Constants.BANK_ACCOUNTS__TXT);
    }

}
