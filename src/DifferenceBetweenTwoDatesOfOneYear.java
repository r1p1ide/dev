import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

public class DifferenceBetweenTwoDatesOfOneYear {

    /**
     * Cчитывает данные из источника.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Регулярное выражение на формат даты.
     */
    private static final String REGEX = "^([0-2][0-9]||3[0-1]).(0[0-9]||1[0-2]).([0-9][0-9])?[0-9][0-9]$";

    /**
     * Класс для форматирования и анализа дат.
     */
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

    /**
     * Запускающий метод.
     */
    public static void main(String[] args) throws ParseException {

        System.out.println("Введите первую дату в формате дд.мм.гггг:");
        String firstDate = input(scanner.nextLine());

        System.out.println("Введите вторую дату в формате дд.мм.гггг:");
        String secondDate = input(scanner.nextLine());

        System.out.println("Разница: " + solution(firstDate, secondDate));
    }

    /**
     * Вычисляет разницу между двумя датами в днях.
     * @param firstDate входной параметр первой даты.
     * @param secondDate входной параметр второй даты.
     * @return возвращает модуль разницы между двумя датами в днях.
     * @throws ParseException выбрасывает исключение при несовпадении даты паттерну.
     */
    private static Integer solution(String firstDate, String secondDate) throws ParseException {
        if (!checkCondition(firstDate, secondDate)) {
            System.out.println("Год должен совпадать.");
            System.exit(-1);
        }
        return diffInDays(simpleDateFormat.parse(firstDate), simpleDateFormat.parse(secondDate));
    }

    /**
     * Проверка входного параметра на соответствие регулярному выражению и максимальное количество дней в месяце.
     * @param input входной параметр даты.
     * @return возвращает дату при успешной проверке.
     */
    private static String input(String input) {
        // Проверка на regex и максимальное количество дней в месяце.
        if (input.matches(REGEX) &&
                Integer.parseInt(input.substring(0, 2)) <=
                        Month.of(Integer.parseInt(input.substring(3, 5))).maxLength()) {
            // Проверка на високосный год (если ввели февраль).
            if (!isLeapYear(Integer.parseInt(input.substring(6, 10)))) {
                if (Integer.parseInt(input.substring(3, 5)) == Month.FEBRUARY.getValue()) {
                    if (Integer.parseInt(input.substring(0, 2)) <= Month.FEBRUARY.minLength()) {
                        return input;
                    } else {
                        System.out.println("В невисокосном году не может быть 29 дней в феврале.");
                        System.exit(-1);
                    }
                }
            }
        } else {
            System.out.println("Неверный формат даты.");
            System.exit(-1);
        }
        return input;
    }

    /**
     * Проверка условия совпадения годов.
     * @param firstDate входной параметр первой даты.
     * @param secondDate входной параметр второй даты.
     * @return возвращает результат проверки true/false.
     */
    private static boolean checkCondition(String firstDate, String secondDate) {
        return Integer.parseInt(firstDate.substring(6, 10)) == Integer.parseInt(secondDate.substring(6, 10));
    }

    /**
     * Вычисляет разницу между двумя датами в днях.
     * @param firstDate входной параметр первой даты.
     * @param secondDate входной параметр второй даты.
     * @return возвращает модуль разницы между двумя датами в днях.
     */
    private static Integer diffInDays(Date firstDate, Date secondDate) {
        return (int) Math.abs((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
    }

    /**
     * Проверка года на високосность.
     * @param year входной параметр года.
     * @return возвращает результат проверки true/false.
     */
    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else return year % 100 != 0;
    }
}
