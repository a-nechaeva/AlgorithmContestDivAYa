import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


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
            Scanner scanner = new Scanner(new File("C:\\Users\\user\\OneDrive\\Рабочий стол\\AlgorithmContestDivAYa\\src\\input.txt"));

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

        for (char key: dict.keySet()) {
            System.out.println(key + " : " + dict.get(key));
        }
    }
}