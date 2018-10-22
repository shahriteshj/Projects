package com.ca.app;

import java.io.*;

public class StreamDemo {
    public static void main(String[] args) {
        String name = null;
        BufferedReader br = null;
        File f = new File("D:/Projects/SampleText.txt");
        try {

            //Buffered Stream
            System.out.println("Enter your name: ");
            InputStreamReader reader = new InputStreamReader(System.in);
//            char c = (char)reader.read();
//            while((int)c!=0){
//                System.out.println(c);
//                c= (char)reader.read();
//            }
            br = new BufferedReader(reader);
            System.err.println(br.readLine());


            //Manual Buffered Stream
            System.out.println("Enter your name: ");
            byte[] buffer = new byte[100];
            int size = System.in.read(buffer);
            name = new String(buffer, 0, size);
            System.out.println(size + " " + name);

        } catch (FileNotFoundException fnoex) {
            System.out.println(fnoex.getMessage());

        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());

        } finally {
            try {
                br.close();
            } catch (IOException ioex) {
                System.out.println("");
            }

        }

    }
}
