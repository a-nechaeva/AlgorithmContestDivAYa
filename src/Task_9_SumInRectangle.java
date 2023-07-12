import java.util.Scanner;

public class Task_9_SumInRectangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int matrixLength = in.nextInt();
        int matrixWidth = in.nextInt();
        int numberOfRequests = in.nextInt();

        int[][] matrix = new int[matrixLength][matrixWidth];

        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                matrix[i][j] = (j == 0) ? in.nextInt(): matrix[i][j - 1] + in.nextInt();
            }
        }
        for (int i = 0; i < numberOfRequests; i++) {
            int Y1 = in.nextInt();
            int X1 = in.nextInt();
            int Y2 = in.nextInt();
            int X2 = in.nextInt();

            int sum = 0;
            for (int n = Y1 - 1; n < Y2; n++) {
                X1 = (X1 > 1) ? X1 - 1 : X1;
                sum += (matrix[n][X2 - 1] - matrix[n][X1 - 1]);
            }
            System.out.println(sum);
        }
    }
}
