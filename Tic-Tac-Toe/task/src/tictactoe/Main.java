package tictactoe;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        char[] inputArray = "_________".toCharArray();
        displayMatrix(inputArray);

        Scanner scanner = new Scanner(System.in);
        boolean gameNotFinished = printGameState(inputArray).equals("Game not finished");
        boolean player1Turn = true;

        while(gameNotFinished) {
            if (player1Turn) {
                makeMove(inputArray, scanner, 'X');
            } else {
                makeMove(inputArray, scanner, 'O');
            }
            displayMatrix(inputArray);
            player1Turn = !player1Turn;
            gameNotFinished = printGameState(inputArray).equals("Game not finished");
        }

        System.out.println(printGameState(inputArray));


        scanner.close();
    }

    private static void makeMove(char[] matrix, Scanner scanner, char inputChar) {
        boolean validCoordinatesEntered = false;
        int x, y;

        String[] coordMap = {"(1,1)", "(1,2)", "(1,3)",
                "(2,1)", "(2,2)", "(2,3)",
                "(3,1)", "(3,2)", "(3,3)",};
        Map<String, Boolean> occupiedCoordMap = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == 'X' || matrix[i] == 'O') {
                occupiedCoordMap.put(coordMap[i], true);
            } else {
                occupiedCoordMap.put(coordMap[i], false);
            }
        }

        do {
            System.out.print("Enter the coordinates: ");
            try {
                x = scanner.nextInt();
                y = scanner.nextInt();

                String coordinate = String.format("(%d,%d)", x, y);

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (occupiedCoordMap.get(coordinate)) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    validCoordinatesEntered = true;
                    int idx = Arrays.asList(coordMap).indexOf(coordinate);
                    matrix[idx] = inputChar;
                    occupiedCoordMap.put(coordinate, true);
                }
            } catch(InputMismatchException inputMismatchException) {
                System.out.println("You should enter numbers");
            }

        } while (!validCoordinatesEntered);
    }

    private static void displayMatrix(char[] matrix) {
        int k = 0;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[k++] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static String printGameState(char[] inputArray) {

        boolean checkThreeXsInRow = checkCharInRow(inputArray, 'X');
        boolean checkThreeOsInRow = checkCharInRow(inputArray, 'O');
        int countOfXs = getCountOfChar(inputArray, 'X');
        int countOfOs = getCountOfChar(inputArray, 'O');

        boolean isImpossible = (checkThreeXsInRow && checkThreeOsInRow) || (Math.abs(countOfXs - countOfOs) > 1);

        if (isImpossible) {
            return "Impossible";
        }

        if (checkThreeXsInRow) {
            return "X wins";
        }

        if (checkThreeOsInRow) {
            return "O wins";
        }

        if (countOfXs + countOfOs == inputArray.length) {
            return "Draw";
        }

        return "Game not finished";
    }

    private static int getCountOfChar(char[] inputArray, char charToCheck) {
        int count = 0;
        for (char c : inputArray) {
            if (c == charToCheck) {
                count++;
            }
        }

        return count;
    }

    private static boolean checkCharInRow(char[] inputArray, char charToCheck) {

        // Row-wise check
        for (int i = 0; i < inputArray.length; i += 3) {
            if (inputArray[i] == charToCheck) {
                if (inputArray[i] == inputArray[i + 1] && inputArray[i + 1] == inputArray[i + 2]) {
                    return true;
                }
            }
        }

        // Column-wise check
        for (int j = 0; j < 3; j++) {
            if (inputArray[j] == charToCheck) {
                if (inputArray[j] == inputArray[j + 3] && inputArray[j + 3] == inputArray[j + 6]) {
                    return true;
                }
            }
        }

        // Diagonal check
        if (inputArray[0] == charToCheck) {
            if (inputArray[0] == inputArray[4] && inputArray[4] == inputArray[8]) {
                return true;
            }
        }

        if (inputArray[2] == charToCheck) {
            return inputArray[2] == inputArray[4] && inputArray[4] == inputArray[6];
        }

        return false;
    }

}
