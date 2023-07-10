import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Диего собрал N наклеек с разными номерами (возможно, совпадающими). К нему пришли K коллекционеров, каждый из которых
собрал все наклейки с номерами не меньше, чем p_i. Вывести, сколько недастоющих каждому коллекционнеру наклеек есть
у Диего, не считая повторные экземпляры.

Ниже неэффективный по времени алгоритм :(
 */
public class Task_3_DiegoCollection {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int diegoHas = Integer.parseInt(reader.readLine());
        ArrayList<Integer> diegoStickers = new ArrayList<>();
        String[] inputD = reader.readLine().split("\\s");
        Arrays.stream(inputD).mapToInt(Integer::parseInt).distinct().sorted().forEach(diegoStickers::add);

        int numberOfCollec = Integer.parseInt(reader.readLine());
        //HashMap<Integer, Integer> stickersCount = new HashMap<>();
        String[] inputK = reader.readLine().split("\\s");
        ArrayList<Integer> minCollectHave = new ArrayList<>();
        Arrays.stream(inputK).mapToInt(Integer::parseInt).forEach(minCollectHave::add);

        for (Integer integer : minCollectHave) {
            int countSticker = 0;
            for (int j = diegoStickers.size() - 1; j >= 0; j--) {
                if (diegoStickers.get(j) < integer) {
                    countSticker = j + 1;
                    break;
                }
            }
            System.out.println(countSticker);

        }
    }
}
