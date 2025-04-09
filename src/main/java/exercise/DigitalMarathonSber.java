package exercise;

import java.util.*;

/**
 * Задача о купце, которому нужно собрать требуемую сумму из монет, указанного номинала
 */
public class DigitalMarathonSber {

    public static void main(String[] args) {
        String[] stringNominals = getFromConsole("Введите номиналы монет через пробел").split(" ");
        int[] intNominals = new int[stringNominals.length];
        for (int i = 0;i < intNominals.length; i++) {
            intNominals[i] = Integer.parseInt(stringNominals[i]);
        }
        int sum = Integer.parseInt(getFromConsole("Введите требуемую сумму"));

        List<Integer> result = findCoinCombination(intNominals, sum);

        if (result == null) {
            System.out.println(-1);
        } else {
            // Выводим результат в порядке возрастания
            System.out.println(result.stream().sorted().toList());
        }

    }

    /**
     * Читает ввод с клавиатуры
     * @param message сообщение перед ожиданием ввода
     * @return введённая строка
     */
    static String getFromConsole(String message) {
        Scanner scanner = new Scanner(System.in);
    System.out.print(message + "->");
    return scanner.nextLine();

}

    /**
     * Этот код любезно предоставлен GigaChat
     * подбирает комбинацию монет, из которых можно составить указанную сумму
     * @param coins список номиналов монет
     * @param targetSum целевая сумма
     * @return список монет или null, если это невозможно сделать
     */
    private static List<Integer> findCoinCombination(int[] coins, int targetSum) {
        // Используем динамическое программирование для нахождения минимальной комбинации монет
        int[] dp = new int[targetSum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2); // Инициализируем массив значениями "бесконечности"
        dp[0] = 0; // Для суммы 0 нужно 0 монет

        for (int i = 1; i <= targetSum; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE / 2) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[targetSum] == Integer.MAX_VALUE / 2) {
            return null; // Невозможно набрать данную сумму
        }

        // Теперь собираем сами монеты, которые использовались для набора суммы
        List<Integer> result = new ArrayList<>();
        int remaining = targetSum;
        while (remaining > 0) {
            for (int coin : coins) {
                if (coin <= remaining && dp[remaining - coin] == dp[remaining] - 1) {
                    result.add(coin);
                    remaining -= coin;
                    break;
                }
            }
        }
        return result;
    }
        }
