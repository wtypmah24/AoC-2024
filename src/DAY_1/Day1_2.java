package DAY_1;

import java.util.Comparator;
import java.util.List;

public class Day1_2 {
    public static void main(String[] args) {
        List<List<Integer>> input = Day1_1.readInput("src/DAY_1/input-1.txt");
        int similarityScore = calculateSimilarityScore(input.get(0), input.get(1));
        System.out.println("left array: " + input.get(0));
        System.out.println("Right array: " + input.get(1));
        System.out.println(similarityScore);
    }

    private static int calculateSimilarityScore(List<Integer> leftColumn, List<Integer> rightColumn) {
        int similarityScore = 0;
        int i = 0, j = 0;
        leftColumn.sort(Comparator.comparingInt(a -> a));
        rightColumn.sort(Comparator.comparingInt(a -> a));

        while (i < leftColumn.size()) {
            int currentNumber = leftColumn.get(i);
            int count = 0;

            while (j < rightColumn.size() && rightColumn.get(j) < currentNumber) {
                j++;
            }

            while (j < rightColumn.size() && rightColumn.get(j) == currentNumber) {
                count++;
                j++;
            }

            similarityScore += currentNumber * count;
            i++;
            j = 0;
        }

        return similarityScore;
    }
}
