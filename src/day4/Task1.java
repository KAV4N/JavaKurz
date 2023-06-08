package day4;

public class Task1 {
    public static void main(String[] args) {
        int a = (int) (Math.random() * 50) + 1;
        int b = (int) (Math.random() * 50) + 1;
        // (int) (Math.random() * (max - min + 1) + min)

        if (a > b) {
            System.out.println(a+" "+b+" Max number: "+ a);
        }
        else if (b > a) {
            System.out.println(a+" "+b+" Max number: "+ b);
        }
        else {
            System.out.println("Both numbers are equal.");
        }


    }
}
