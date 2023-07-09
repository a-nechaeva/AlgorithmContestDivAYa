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
            currentSequenceLen += 1;
            int curK = k;

            while (start < strArray.length - 2) {
                while ((start < strArray.length - 2) && (strArray[start] == strArray[start + 1])) {
                    currentSequenceLen += 1;
                    start += 1;
                }

                while ((start < strArray.length - 2) && (strArray[start] != strArray[start + 1]) && (curK > 0)) {
                    start += 1;
                    currentSequenceLen +=1;
                    curK -= 1;
                }
            }

            if ((start == strArray.length - 1) && (curK > 0)) {
                while (start > 1) {
                    while ((start > 1) && (strArray[start] == strArray[start - 1])) {
                        currentSequenceLen += 1;
                        start -= 1;
                    }

                    while ((start > 1) && (strArray[start] != strArray[start - 1]) && (curK > 0)) {
                        start -= 1;
                        currentSequenceLen += 1;
                        curK -= 1;
                    }
                }
            }

            maxSequenceLen = Math.max(maxSequenceLen, currentSequenceLen);

        }
        System.out.println(maxSequenceLen);
    }
}
