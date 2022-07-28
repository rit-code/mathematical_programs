package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    private static final DecimalFormat df = new DecimalFormat("0.000000");

    public static void plusMinus(List<Integer> inputList) {

        float n = inputList.size();
        int positiveNumbers = 0;
        int negativeNumbers = 0;
        int zeroes = 0;

        for (int entry : inputList) {
            if (entry > 0) {
                positiveNumbers++;
            } else if (entry < 0) {
                negativeNumbers++;
            } else {
                zeroes++;
            }
        }
        float positiveProp = (float) positiveNumbers / n;
        float negativeProp = (float) negativeNumbers / n;
        float zerosProp = (float) zeroes / n;
        System.out.println(df.format(positiveProp));
        System.out.println(df.format(negativeProp));
        System.out.println(df.format(zerosProp));
    }

}

public class NumRatio {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result1.plusMinus(arr);

        bufferedReader.close();
    }
}

