import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int colIdx1 = scanner.nextInt();
        int colIdx2 = scanner.nextInt();

        for (int i = 0; i < rows; i++) {
            swapELements(arr, colIdx1, colIdx2, i);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void swapELements(int[][] arr, int colIdx1, int colIdx2, int rowIdx) {
        int temp;
        temp = arr[rowIdx][colIdx1];
        arr[rowIdx][colIdx1] = arr[rowIdx][colIdx2];
        arr[rowIdx][colIdx2] = temp;
    }
}