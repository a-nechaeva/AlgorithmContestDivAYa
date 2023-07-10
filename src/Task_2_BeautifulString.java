import java.util.Scanner;

public class Task_2_BeautifulString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String str = in.next();

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
    }
}
