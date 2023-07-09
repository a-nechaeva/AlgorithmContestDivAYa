import java.io.*;
import java.util.*;


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
        // here we get an array of keys
        Character[] keysASCII = dict.keySet().toArray(new Character[0]);
        
        //sort keys based on ASCII code
        AbstractList<Character> keysSortedASCII = new ArrayList<>();
        // use stream API and lambda
        Arrays.stream(keysASCII).sorted().forEach(keysSortedASCII::add);

        for (int i = 0; i < keysASCII.length; i++)
            System.out.println(keysSortedASCII.get(i));

        for (char key: dict.keySet()) {
            System.out.println(key + " : " + dict.get(key));
        }
    }
}