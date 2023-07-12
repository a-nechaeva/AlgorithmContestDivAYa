import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
Консольный ввод, вывод. В первой строке задано целое неотрицательное число - количество возможных замен.
Во второй - непустая строка, состоящая из строчных латинских букв.
Красотой строки назовем максимальное число подряд идущих одинаковых символов. Нужно определить максимальную
красоту строки с заданными параметрами.
 */

// алгоритм правильный, но слишком медленный

public class Task_2_BeautifulString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String str = in.next();
/*
        int maxSequenceLen = 0;
        char[] strArray = str.toCharArray();

        for (int i = 0; i < strArray.length; i++) {
            int currentSequenceLen = 0;
            int start = i;
            int tick = start;
            char symbol = strArray[start];
            currentSequenceLen += 1;
            int curK = k;

            int safeCountLoop1 = start;

            while ((tick < strArray.length - 1) && (safeCountLoop1 < strArray.length - 1)) {
                int safeTemp = 0;

                while ((tick < strArray.length - 1) && (symbol == strArray[tick + 1])) {
                    currentSequenceLen += 1;
                    tick += 1;
                    safeTemp += 1;
                }

                while ((tick < strArray.length - 1) && (symbol != strArray[tick + 1]) && (curK > 0)) {
                    tick += 1;
                    currentSequenceLen +=1;
                    curK -= 1;
                    safeTemp += 1;
                }

                if (safeTemp == 0)
                    safeCountLoop1 += 1;
                else safeCountLoop1 += safeTemp;

            }

            if ((start == strArray.length - 1) && (curK > 0)) {

                int safeCountLoop2 = start;

                while ((start > 0) && (safeCountLoop2 > 0)) {

                    int safeTemp = 0;

                    while ((start > 0) && (symbol == strArray[start - 1])) {
                        currentSequenceLen += 1;
                        start -= 1;
                        safeTemp += 1;
                    }

                    while ((start > 0) && (symbol != strArray[start - 1]) && (curK > 0)) {
                        start -= 1;
                        currentSequenceLen += 1;
                        curK -= 1;
                        safeTemp += 1;
                    }

                    if (safeTemp == 0)
                        safeCountLoop2 -= 1;
                    else safeCountLoop2 -= safeTemp;
                }
            }

            maxSequenceLen = Math.max(maxSequenceLen, currentSequenceLen);

        }
        System.out.println(maxSequenceLen);

 */
//======================================================================================================================
        //решение через префиксные суммы и двоичный поиск
        //составим массив, входящих в строку символов -- алфавит
        char[] st = str.toCharArray();
        Character[] input = new Character[st.length];
        for (int i = 0; i < st.length; i++) {
            input[i] = st[i];
        }
        ArrayList<Character> alphabet = new ArrayList<>();

        Arrays.stream(input).distinct().forEach(alphabet::add);

        int maxSequenceLen = 0;

        for (Character letter:  alphabet) {
            // для каждого символа алфавита составляем массив префиксных сумм
            int[] prefixSum = new int[st.length];
            prefixSum[0] = (st[0] == letter) ? 0 : 1;

            if (st.length > 1) {
                for (int i = 1; i < st.length; i++) {
                    prefixSum[i] = (st[i] == letter) ? prefixSum[i - 1] : prefixSum[i - 1] + 1;
                }
            }

        }
    }
}
