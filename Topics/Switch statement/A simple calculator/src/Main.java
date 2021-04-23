import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strInput = scanner.nextLine().split(" ");
        long firstNumber = Long.parseLong(strInput[0]);
        long secondNumber = Long.parseLong(strInput[2]);

        switch (strInput[1]) {
            case "+":
                System.out.println(firstNumber + secondNumber);
                break;
            case "-":
                System.out.println(firstNumber - secondNumber);
                break;
            case "/":
                if (secondNumber == 0) {
                    System.out.println("Division by 0!");
                } else {
                    System.out.println(firstNumber / secondNumber);
                }
                break;
            case "*":
                System.out.println(firstNumber * secondNumber);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}