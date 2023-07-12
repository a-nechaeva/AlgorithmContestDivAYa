import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.*;

public class Task_8_MinRectangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int coloredSquares = in.nextInt();
        int minX = MAX_VALUE;
        int minY = MAX_VALUE;
        int maxX = MIN_VALUE;
        int maxY = MIN_VALUE;

        for (int i = 0; i < coloredSquares; i++) {
            int curX = in.nextInt();
            int curY = in.nextInt();

            minX = min(curX, minX);
            minY = min(curY, minY);

            maxX = max(curX, maxX);
            maxY = max(curY, maxY);

        }

        System.out.println(minX + " " + minY + " " + maxX + " " + maxY );

    }
}
