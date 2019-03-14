package com.lckdn.eckel.io.dir;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Пример использования паттерна "Стратегия" совместно с анонимным классом DirFilter
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File("./");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }

     static class DirFilter implements FilenameFilter {
         private Pattern pattern;

         @Override
         public boolean accept(File dir, String name) {
             return pattern.matcher(name).matches();
         }

         public DirFilter(String regex) {
             pattern = Pattern.compile(regex);
         }
     }

}
