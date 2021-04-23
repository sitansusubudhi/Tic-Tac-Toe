import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str;
        List<List<Integer>> rectMatrixInput = new ArrayList<>();
        List<List<Integer>> rectMatrixOutput = new ArrayList<>();

        while (!(str = sc.nextLine()).equals("end")) {
            List<Integer> integerList = Arrays.stream(str.split(" "))
                    .map(Integer::valueOf).collect(Collectors.toList());

            rectMatrixInput.add(integerList);

            // Initializing rectMatrixOutput elements
            List<Integer> zeroesList = IntStream.of(new int[integerList.size()])
                    .boxed()
                    .collect(Collectors.toList());

            rectMatrixOutput.add(zeroesList);
        }

        calculateOutputMatrix(rectMatrixInput, rectMatrixOutput);
        // System.out.println("Output Matrix ");
        for (List<Integer> intList : rectMatrixOutput) {
            for (Integer i : intList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }


    }

    private static void calculateOutputMatrix(List<List<Integer>> rectMatrixInput, List<List<Integer>> rectMatrixOutput) {
        for (int i = 0; i < rectMatrixInput.size(); i++) {
            for (int j = 0; j < rectMatrixInput.get(i).size(); j++) {
                rectMatrixOutput.get(i).set(j, sumOfNeighbors(rectMatrixInput, i, j, rectMatrixInput.size(), rectMatrixInput.get(i).size()));
            }
        }
    }

    private static int sumOfNeighbors(List<List<Integer>> rectMatrixInput, int i, int j, int rowSize, int colSize) {
        int topIdx = (i - 1 + rowSize) % rowSize;
        int rightIdx = (j + 1 + colSize) % colSize;
        int bottomIdx = (i + 1 + rowSize) % rowSize;
        int leftIdx = (j - 1 + colSize) % colSize;

        int sum = rectMatrixInput.get(topIdx).get(j);
        sum += rectMatrixInput.get(i).get(rightIdx);
        sum += rectMatrixInput.get(bottomIdx).get(j);
        sum += rectMatrixInput.get(i).get(leftIdx);

        return sum;
    }
}