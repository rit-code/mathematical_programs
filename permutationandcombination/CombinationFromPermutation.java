package permutationandcombination;

import StringOps.StringAnagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CombinationFromPermutation {
    static int bigO = 0;

    public static void main(String[] args) {
        Set<String> collector = new HashSet<>();

/*        System.out.print("Enter String and k value for combination : ");
        String[] userInput = new String[2];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = bf.readLine();
            if (line != null) {
                userInput = line.split("\\s+");
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        int constant = args[0].length() - Integer.parseInt(args[1]);
        if (constant < 0) {
            throw new RuntimeException("Invalid input for 2nd parameter");
        }
        // Find all permutation first
        stringPermute(collector, "", args[0], constant);

        // Filtering anagram(similar in content) Strings
        String[] permuteStringArray = collector.stream().toArray(String[]::new);
        for (int i = 0; i < permuteStringArray.length - 1; i++) {
            String str1 = permuteStringArray[i];
            for (int j = i + 1; j < permuteStringArray.length; j++) {
                bigO++;
                String str2 = permuteStringArray[j];
                boolean match = StringAnagram.findAnagram(str1, str2);
                if (match) {
                    permuteStringArray[j] = permuteStringArray[i];
                }

            }
        }

        String[] distinctPermuteStringArray = Arrays.stream(permuteStringArray).distinct().toArray(String[]::new);
        System.out.print("Possible combination for entry " + "'" + args[0] + "'" + " for a set of " + args[1] + " is : ");
        for (String entry : distinctPermuteStringArray) {
            System.out.print(entry + " ");
        }
        System.out.println("\nBigO value : " + bigO);

    }

    public static void stringPermute(Set<String> collector, String prefix, String str, final int constant) {
        int n = str.length();
        if (n == constant) {
            collector.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                bigO++;
                stringPermute(collector, prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), constant);
            }
        }
    }
}
