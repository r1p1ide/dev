import java.util.Scanner;

public class GenerateCommonDivisor {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите первое натуральное число:");
        long a = isValidNumber(scanner.nextInt());

        System.out.println("Введите второе натуральное число:");
        long b = isValidNumber(scanner.nextInt());

        System.out.println("НОД двух чисел равен: " + gcd(a, b));
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private static long isValidNumber(long a) {
        if (a < 1) {
            System.out.println("Вы ввели не натуральное число.");
            System.exit(-1);
        }
        return a;
    }
}
