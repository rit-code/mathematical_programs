package bitwise;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class TwosComplement {

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
            System.out.println("Binary representation of user decimal is : " + binary);

            char[] binaryArray = binary.toCharArray();

            for (int i = 0; i < binaryArray.length; i++) {
                binaryArray[i] = binaryArray[i] == '0' ? '1' : '0';
            }
            System.out.print("1's complement binary representation of user decimal is : ");
            Stream.of(binaryArray).forEach(System.out::print);

            char[] binaryArray2sComplement = new char[binaryArray.length + 1];
            int remainder = 1;
            for (int i = binaryArray.length - 1; i >= 0; i--) {
                if (binaryArray[i] == '1' && remainder == 1) {
                    binaryArray2sComplement[i + 1] = '0';
                    remainder = 1;
                } else if (binaryArray[i] == '0' && remainder == 1) {
                    binaryArray2sComplement[i + 1] = '1';
                    remainder = 0;
                } else if (binaryArray[i] == '1' && remainder == 0) {
                    binaryArray2sComplement[i + 1] = '1';
                    remainder = 0;
                } else {
                    binaryArray2sComplement[i + 1] = '0';
                    remainder = 0;
                }
            }
            binaryArray2sComplement[0] = remainder == 1 ? '1' : '0';
            System.out.print("\n2's complement binary representation of user decimal is : ");
            Stream.of(binaryArray2sComplement).forEach(System.out::print);


            System.out.println();

            // More input
            System.out.print("\nWish to continue for some more values, press y : ");
            wantToContinue = sc.hasNext() ? "y".equalsIgnoreCase(sc.next()) : false;
        } while (wantToContinue);
        sc.close();
    }
}
