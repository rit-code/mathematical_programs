package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PairSum {

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.print("Enter size of array and pair sum value : ");
            List<Integer> sizeInput = Arrays.stream(bf.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.printf("Size of array is %d and pair sum value is %d", sizeInput.get(0), sizeInput.get(1));
            System.out.print("\nEnter array input : ");
            List<Integer> inputList = Arrays.stream(bf.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            if (sizeInput.get(0) != inputList.size()) {
                throw new IllegalArgumentException();
            }
            findPairSum(inputList, sizeInput.get(1));
        } catch (IOException e) {
            System.out.println("IO exception occurred");
        } catch (IllegalArgumentException e) {
            System.out.println("Input array size is not matching the entered value");
        }
    }

    private static void findPairSum(List<Integer> inputList, Integer pairSumVal) {

        int[] inputArray = inputList.stream().mapToInt(Integer::intValue).toArray();

        Set<Integer> tempSet = new HashSet<>();
        int pairNum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (tempSet.contains(pairSumVal - inputArray[i])) {
                System.out.printf("\nPair %d is : %d, %d", ++pairNum, inputArray[i], pairSumVal - inputArray[i]);
            } else {
                tempSet.add(inputArray[i]);
            }
        }
    }
}
