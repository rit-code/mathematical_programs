package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {

        int[] inputArray = arr.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(inputArray);

        int minSum = 0;
        int maxSum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (i != 0) {
                maxSum = maxSum + inputArray[i];
            }
            if (i != inputArray.length - 1) {
                minSum = minSum + inputArray[i];
            }
        }

        System.out.print(minSum + " ");
        System.out.print(maxSum);
    }

}

public class MinMax {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

