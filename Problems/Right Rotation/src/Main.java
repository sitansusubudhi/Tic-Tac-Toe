import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int arrLength = arr.length;
        int rotation = scanner.nextInt();
        int startIdx = (0 + rotation) % arrLength;


        String[] rotatedArray = new String[arrLength];

        int k = 0;
        for (int i = startIdx; i < arrLength; i++) {
            rotatedArray[i] = arr[k++];
        }

        for (int x = 0; x < startIdx; x++) {
            rotatedArray[x] = arr[k++];
        }

        for (String elem: rotatedArray) {
            System.out.print(elem + " ");
        }
    }
}