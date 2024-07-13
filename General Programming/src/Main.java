import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        IntegerSet mySet = new IntegerSet();
        mySet.insert(3);
        mySet.insert(7);
        System.out.println(mySet.size());
        System.out.println(mySet);
        mySet.remove(3);
        System.out.println(mySet.size());
        System.out.println(mySet.contains(3));
        System.out.println(mySet);
    }
}