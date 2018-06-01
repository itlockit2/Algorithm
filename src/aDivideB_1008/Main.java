package aDivideB_1008;

import java.util.Scanner;

public class Main {


    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
  
        Scanner scan = new Scanner(System.in);
  
        //int a = 1;
        //int b = 3;
  
        int a = scan.nextInt();
        int b = scan.nextInt();
  
        double c = a / (double) b;
        System.out.println(c);
        //System.out.println(a + b);
    }

}
