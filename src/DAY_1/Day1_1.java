package DAY_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1_1 {
    public static void main(String[] args) {
        List<List<Integer>> arrays = readInput("src/DAY_1/input-1.txt");
        int result = findDistance(arrays);
        System.out.println(result);
    }

    public static List<List<Integer>> readInput(String path) {
        List<Integer> firstColumn = new ArrayList<>();
        List<Integer> secondColumn = new ArrayList<>();

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    firstColumn.add(Integer.parseInt(parts[0]));
                    secondColumn.add(Integer.parseInt(parts[1]));
                }
            }
            scanner.close();

            List<List<Integer>> result = new ArrayList<>();
            result.add(firstColumn);
            result.add(secondColumn);
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Wrong format: " + e.getMessage());
        }
        return null;
    }

    private static int findDistance (List<List<Integer>> input) {
        List<Integer> leftColumn = input.get(0);
        leftColumn.sort(Comparator.comparingInt(a -> a));
        List<Integer> rightColumn = input.get(1);
        if (leftColumn.size() == 0 || rightColumn.size() == 0) {
            return 0;
        }
        rightColumn.sort(Comparator.comparingInt(a -> a));
        int result = 0;
        for (int i = 0; i < leftColumn.size(); i++) {
            result += Math.abs(leftColumn.get(i) - rightColumn.get(i));
        }
        return result;
    }
}
