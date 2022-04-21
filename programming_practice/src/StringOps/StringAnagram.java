package StringOps;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringAnagram {

    public static void main(String[] args) throws IOException {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter 2 strings separated by space, type 'exit' to complete input : ");

            String inputString = "";
            String tempString = "";
            while (sc.hasNext()) {
                if (!(tempString = sc.nextLine()).equalsIgnoreCase("exit")) {
                    inputString = inputString + " " + tempString;
                } else {
                    break;
                }
            }
            String[] stringSet = inputString.trim().split("\\s+");
            if (stringSet.length > 2) {
                throw new IllegalArgumentException("Passed more than 2 string values");
            }
            boolean anagram = findAnagram(stringSet[0], stringSet[1]);
            if (anagram) {
                System.out.println("Entered string is anagram");
            } else {
                System.out.println("Entered string is not an anagram");
            }

            System.out.println("Wanted to check another string set ? Press 'y' if yes : ");
            sc.next().equalsIgnoreCase("y");
        } while (true);
    }

    private static boolean findAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] charSet1 = s1.toCharArray();
        char[] charSet2 = s2.toCharArray();

        Map<Character, Integer> charSet1Map = new HashMap();
        Map<Character, Integer> charSet2Map = new HashMap();

        fillMapwithValues(charSet1Map, charSet1);
        fillMapwithValues(charSet2Map, charSet2);

        return charSet1Map.entrySet().equals(charSet2Map.entrySet());

    }

    private static void fillMapwithValues(Map<Character, Integer> map, char[] charSet) {
        for (char entry : charSet) {
            if (map.containsKey(entry)) {
                map.put(entry, map.get(entry) + 1);
            } else {
                map.put(entry, 1);
            }
        }
    }
}

