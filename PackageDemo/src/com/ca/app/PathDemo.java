package com.ca.app;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Iterator;

public class PathDemo {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("/users/");
        System.out.println(path);
        System.out.println(path.toUri());

        System.out.println( path.getNameCount());

        System.out.println(FileSystems.getDefault().getClass());

        Iterable it = FileSystems.getDefault().getRootDirectories();
        it.forEach(System.out::println);

        Iterator it1 = FileSystems.getDefault().getRootDirectories().iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
    }
}
