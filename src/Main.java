import javax.swing.*;
import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>(4);
        MyArrayList<Integer> Arr = new MyArrayList<>(4);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Arr.addAll(arr);
        for(Integer m:Arr){
            System.out.println(m);
        }





    }

}