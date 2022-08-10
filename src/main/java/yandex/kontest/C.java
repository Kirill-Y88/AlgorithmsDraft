package yandex.kontest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class C {

    private static List<Double> movingAverage(int n, List<Integer> arr, int windowSize) {
        // ваше решение
       // List<Double> average = new LinkedList<>();
        Double[] arrAverage = new Double[n-windowSize+1];
        double sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += arr.get(i);
        }
      //  average.add(sum/windowSize);
        arrAverage[0] = sum/windowSize;

        for (int i = windowSize; i < arr.size(); i++) {
            sum = sum + arr.get(i) - arr.get(i - windowSize);
       //     average.add(sum/windowSize);
            arrAverage[i - windowSize+1] = sum/windowSize;
        }
       return List.<Double>of(arrAverage);
       // return average;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int windowSize = readInt(reader);
            List<Double> result = movingAverage(n, arr, windowSize);
            for (double elem : result) {
                writer.write(elem + " ");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }
}
