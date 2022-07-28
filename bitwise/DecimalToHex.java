package bitwise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DecimalToHex {

    static final char[] hexchars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main(String[] args) {

        int decimal = 0;
        boolean wantToContinue = false;
        Scanner sc = new Scanner(System.in);
        do {
            String hex = "";
            System.out.print("Enter a decimal value : ");
            try {
                decimal = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Input not a decimal.");
                sc.close();
            }
            while (decimal > 0) {
                int rem = decimal % 16;
                hex = hexchars[rem] + hex;
                decimal = decimal / 16;
            }
            System.out.println("Hex representation value is : " + hex);

            // More input
            System.out.print("Wish to continue for some more values, press y : ");
            wantToContinue = sc.hasNext() ? "y".equalsIgnoreCase(sc.next()) : false;
        } while (wantToContinue);
        sc.close();
    }
}
