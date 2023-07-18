import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class Task_10_BoringLecture {
    // не проходит 9 тест (WA)
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Hashtable<Character, Long> alphabet = new Hashtable<>();
        char[] input = in.next().toCharArray();
        Character[] alexFavouriteWord = new Character[input.length];

        // почему не работает автоупаковка char в Character? или как обойтись без дополнительных массивов?
        for (int i = 0; i < input.length; i++) {
            alexFavouriteWord[i] = input[i];
        }

        Arrays.stream(alexFavouriteWord).distinct().forEach(s -> alphabet.put(s, 0L));

        for (int i = 0; i < input.length; i++) {
            int wordInStringsCounter = (i + 1) * (input.length - i);
            alphabet.put(alexFavouriteWord[i], alphabet.get(alexFavouriteWord[i]) + wordInStringsCounter);
        }
        Arrays.stream(alphabet.keySet().toArray()).sorted().forEach(s -> System.out.println(s + ": " + alphabet.get(s)));
    }

}
