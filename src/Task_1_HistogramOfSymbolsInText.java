import java.io.*;
import java.util.*;

/*
Эта программа читает текст из файла (гарантируется, что в файле содержится хотя бы 1 символ),
подсчитывает частоту встречаемости каждого символа и представляет данные в виде гистограммы.
Вывод в консоль. Высоты столбцов решеток соответствуют частоте встречаемости каждого символа
за исключением пробелов и переносов строк. Символы отсортированы в порядке увеличения кодов символов.
 */

public class Task_1_HistogramOfSymbolsInText {
    public static void main(String[] args) {

        //create an empty map
        HashMap<Character, Integer> dict = new HashMap<>();
      /*  Scanner in = new Scanner(System.in);

        // read from console while there are some symbols
        while (true) {
            //read string from console
            String newString = in.nextLine();
            //split string to char array
            if (newString.isEmpty())
                break;
            char[] splitString = newString.toCharArray();
            //add elements to dictionary and update counter
            for (char symbol: splitString) {
                // if dict doesn't contain current symbol and this symbol isn't whitespace
                if (!Character.isWhitespace(symbol)) {
                    if (!dict.containsKey(symbol))
                        dict.put(symbol, 0);
                    dict.put(symbol, dict.get(symbol) + 1);
                }
            }
        }
        in.close();

        for (char key: dict.keySet()) {
            System.out.println(key + " : " + dict.get(key));
        }

       */

        // FILE input / output
        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNextLine()) {
                String newString = scanner.nextLine();
                //split string to char array
                char[] splitString = newString.toCharArray();
                //add elements to dictionary and update counter
                for (char symbol: splitString) {
                    // if dict doesn't contain current symbol and this symbol isn't whitespace
                    if (!Character.isWhitespace(symbol)) {
                        if (!dict.containsKey(symbol))
                            dict.put(symbol, 0);
                        dict.put(symbol, dict.get(symbol) + 1);
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // here we get an array of keys
        Character[] keysASCII = dict.keySet().toArray(new Character[0]);

        //sort keys based on ASCII code
        AbstractList<Character> keysSortedASCII = new ArrayList<>();
        // use stream API and lambda
        Arrays.stream(keysASCII).sorted().forEach(keysSortedASCII::add);

       /* for (char key: dict.keySet()) {
            System.out.println(key + " : " + dict.get(key));
        }
        */
        int maxValue = 0;
        for (char key: keysSortedASCII) {
           // System.out.println(key + " : " + dict.get(key));
            if (maxValue < dict.get(key))
                maxValue = dict.get(key);
        }

        //beautiful histogram output
        char[][] print = new char[maxValue][keysSortedASCII.size()];
        for (int i = 0; i < keysSortedASCII.size(); i++) {
            for (int j = 0; j < maxValue; j++) {
                print[j][i] = ' ';
            }
            for (int j = 0; j < dict.get(keysSortedASCII.get(i)); j++) {
                print[maxValue - 1 - j][i] = '#';
            }
        }
        for (int i = 0; i < maxValue; i++) {
            for (int j = 0; j < keysSortedASCII.size(); j++) {
                System.out.print(print[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < keysSortedASCII.size(); i++){
            System.out.print(keysSortedASCII.get(i));
        }

    }
}