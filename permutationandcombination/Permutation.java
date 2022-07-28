package permutationandcombination;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

    static Set<String> collector = new HashSet<>();
    private static int constant = 0;

    public static void main(String[] args) {

        // Set<String> collector = new HashSet<>();
        constant = args[0].length() - Integer.parseInt(args[1]);
        if (constant <= 0) {
            throw new RuntimeException("Invalid input for 2nd parameter");
        }
        stringPermuteAndPrint("", args[0]);
        System.out.print("Possible permutation for entry " + "'" + args[0] + "'" + " for a set of " + args[1] + " is : ");
        for (String entry : collector) {
            System.out.print(entry + " ");
        }

    }

    private static void stringPermuteAndPrint(String prefix, String str) {
        int n = str.length();
        if (n == constant) {
            collector.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                stringPermuteAndPrint(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

}
