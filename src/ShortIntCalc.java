import java.util.Scanner;

public class ShortIntCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte result = 0;

        System.out.println("Введите первое число СО ЗНАКОМ");
        Long a = scanner.nextLong();

        System.out.println("Введите второе число БЕЗ ЗНАКА");
        Long b = scanner.nextLong();

        System.out.println("\'+\' - 1; \'-\' - 0");
        int c = scanner.nextInt();

        if (c == 1) {
            result = (byte) (a.byteValue() + b.byteValue());
        }
        if (c == 0) {
            result = (byte) (a.byteValue() - b.byteValue());
        }

        System.out.println("Результат: " + result);
    }
}