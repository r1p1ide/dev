import java.util.Scanner;

public class Razryadi1234 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число");
        Integer input = scanner.nextInt();

        System.out.println("Результат:");
        System.out.println(solution(input));
    }

    static String solution(Integer x) {

        StringBuilder result = new StringBuilder(x.toString());
        int flag = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            result.insert(i + 1, addLine(flag));
            flag++;
        }
        return result.toString();
    }

    static String addLine(int flag) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < flag; i++) {
            result.append("_");
        }
        return result.toString();
    }
}
