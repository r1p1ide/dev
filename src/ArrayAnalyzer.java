import java.util.Scanner;

public class ArrayAnalyzer {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Введите размер массива N:");
        int size = scanner.nextInt() + 1;

        System.out.println("Заполните массив:");
        String[] input = new String[size];
        for (int i = 0; i < input.length; i++) {
            input[i] = scanner.nextLine();
        }

        int countOfNumbers = 0;
        for (String s : input) {
            for (int j = 0; j < s.length(); j++) {
                if (Character.isDigit(s.charAt(j))) {
                    countOfNumbers++;
                }
            }
        }
        System.out.println(countOfNumbers);
    }

//    private static int countOfNumbers(String[] input) {
//        return ;
//    }
}
