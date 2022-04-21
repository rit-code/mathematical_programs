package permutationandcombination;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

    public static void main(String[] args) {

        Set<String> collector = new HashSet<>();
        int constant = args[0].length() - Integer.parseInt(args[1]);
        stringPermuteAndPrint(collector, "", args[0], constant);
        System.out.print("Possible permutation for entry " + "'" + args[0] + "'" + " for a set of " + args[1] + " is : ");
        for (String entry : collector) {
            System.out.print(entry + " ");
        }

    }

    private static void stringPermuteAndPrint(Set<String> collector, String prefix, String str, final int constant) {
        int n = str.length();
        if (n == constant) {
            collector.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                stringPermuteAndPrint(collector, prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), constant);
            }
        }
    }

}
