import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] seats = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = scanner.nextInt();
            }
        }

        int reqConsecutiveTickets = scanner.nextInt();

        System.out.println(getRowNum(reqConsecutiveTickets, seats));
    }

    private static int getRowNum(int reqConsecutiveTickets, int[][] seats) {
        int freq;
        for (int i = 0; i < seats.length; i++) {
            freq = getMaxConsecutiveFrequencies(seats[i], 0);

            if (freq >= reqConsecutiveTickets) {
                return i + 1;
            }
        }
        return 0; // if never returned till now, return 0
    }

    private static int getMaxConsecutiveFrequencies(int[] seat, int val) {
        int maxFreq = 0;
        int currFreq = 0;
        if (seat[0] == val) {
            currFreq++;
        }

        for (int i = 1; i < seat.length; i++) {
            if (seat[i] == val) {
                if (seat[i] == seat[i - 1]) {
                    currFreq++;
                } else {
                    currFreq = 1;
                }
            } else {
                currFreq = 0;
            }
            maxFreq = Math.max(currFreq, maxFreq);
        }
        return maxFreq;
    }
}