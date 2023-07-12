import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.*;

/*
Подсчет хорошести строки: количество пар подряд идущих букв алфавита

Упало на 41 тесте с WA(
 */
public class Task_5_StringGoodnessIppolit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfLetters = in.nextInt();
        ArrayList<Integer> letters = new ArrayList<>();
        letters.add(in.nextInt());

        int stringGoodness = 0;

        for (int i = 1; i < numberOfLetters; i++) {
            letters.add(in.nextInt());
            stringGoodness += min(letters.get(i), letters.get(i - 1));
        }
        System.out.println(stringGoodness);
    }
}
