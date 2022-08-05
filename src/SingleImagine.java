import java.util.Scanner;

public class SingleImagine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите десятичное число");
        double input = scanner.nextDouble();

        float result = (float) input;
        System.out.println(result);
    }
}
