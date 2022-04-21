package bitwise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DecimalToBinary {


    static final char[] binaryChars = {'0', '1'};

    public static void main(String[] args) {

        int decimal = 0;
        boolean wantToContinue = false;
        Scanner sc = new Scanner(System.in);
        do {
            String binary = "";
            System.out.print("Enter a decimal value : ");
            try {
                decimal = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Input not a decimal.");
                sc.close();
            }
            while (decimal > 0) {
                int rem = decimal % 2;
                binary = binaryChars[rem] + binary;
                decimal = decimal / 2;
            }
            System.out.println("Binary representation value is : " + binary);

            // More input
            System.out.print("Wish to continue for some more values, press y : ");
            wantToContinue = sc.hasNext() ? "y".equalsIgnoreCase(sc.next()) : false;
        } while (wantToContinue);
        sc.close();
    }

}
