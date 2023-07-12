import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Диего собрал N наклеек с разными номерами (возможно, совпадающими). К нему пришли K коллекционеров, каждый из которых
собрал все наклейки с номерами не меньше, чем p_i. Вывести, сколько недастоющих каждому коллекционнеру наклеек есть
у Диего, не считая повторные экземпляры.

Ниже эффективный по времени алгоритм :)
 */
public class Task_3_DiegoCollection {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int diegoHas = Integer.parseInt(reader.readLine());
        if (diegoHas == 0) {
            String empty = reader.readLine();
            int numberOfCollecForEmpty = Integer.parseInt(reader.readLine());
            String inpt = reader.readLine();
            if (numberOfCollecForEmpty != 0) {
                for (int i = 0; i < numberOfCollecForEmpty; i++)
                    System.out.println(0);
            }
        } else {
            ArrayList<Integer> diegoStickers = new ArrayList<>();
            String[] inputD = reader.readLine().split("\\s");
            Arrays.stream(inputD).mapToInt(Integer::parseInt).distinct().sorted().forEach(diegoStickers::add);

            int numberOfCollec = Integer.parseInt(reader.readLine());
            if (numberOfCollec == 0) {
                String nobodyVisitDiego = reader.readLine();
            } else {
                String[] inputK = reader.readLine().split("\\s");
                ArrayList<Integer> minCollectHave = new ArrayList<>();
                Arrays.stream(inputK).mapToInt(Integer::parseInt).forEach(minCollectHave::add);

                for (Integer minP : minCollectHave) {
                    int countSticker = 0;
                    // здесь двоичный поиск вместо перебора
                    int left = -1;
                    int right = diegoStickers.size();
                    while ((left < right - 1)) {

                        int curIndex = (left + right) / 2;
                        if (diegoStickers.get(curIndex) < minP) {
                            left = curIndex;
                            countSticker = curIndex + 1;
                        } else {
                            right = curIndex;
                        }
                    }


           /* for (int j = diegoStickers.size() - 1; j >= 0; j--) {
                if (diegoStickers.get(j) < minP) {
                    countSticker = j + 1;
                    break;
                }
            }
            */
                    System.out.println(countSticker);

                }
            }
        }
    }
}
