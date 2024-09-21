import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        /*
        byte[] data = new byte[10];
        System.out.println("Type");
        System.in.read(data);
        for (byte b : data){
            System.out.println("Byte: " + b + "\tChar: " + (char)b);
        }

        FileInputStream in;
        FileOutputStream out;
        in = new FileInputStream("C:\\All Milad Coding\\Intellij\\Computer Programming 11\\General Programming\\in.txt");
        out = new FileOutputStream("C:\\All Milad Coding\\Intellij\\Computer Programming 11\\General Programming\\out.txt");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        String addToFile = "\rAdding another line";
        byte[] adding = addToFile.getBytes();
        for (byte b : adding){
            out.write(b);
        }


        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("C:\\All Milad Coding\\Intellij\\Computer Programming 11\\General Programming\\in.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println("Just read " + line);
            lines.add(line);
        }
        br.close();
        for (String s : lines){
            System.out.println(s);
        }

        FileWriter fw = new FileWriter("C:\\All Milad Coding\\Intellij\\Computer Programming 11\\General Programming\\out.txt"); //Add true here to append
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Writing to out file from IN file\r");
        for (String s : lines){
            bw.write(s + "\r");
        }
        bw.close();
        */
    }
}