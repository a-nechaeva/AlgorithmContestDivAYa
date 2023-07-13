import java.util.Scanner;

/*
 подсчет через использование двумерной префиксной суммы -- где-то ошибка((
 */
public class Task_9_SumInRectangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int matrixLength = in.nextInt();
        int matrixWidth = in.nextInt();
        int numberOfRequests = in.nextInt();

        int[][] matrix = new int[matrixLength][matrixWidth];
        for (int j = 0; j < matrixWidth; j++) {
            matrix[0][j] = (j == 0) ? in.nextInt(): matrix[0][j - 1] + in.nextInt();
        }
        if (matrixLength > 1) {
            for (int i = 1; i < matrixLength; i++) {
                for (int j = 0; j < matrixWidth; j++) {

                    matrix[i][j] = (j == 0) ? in.nextInt() + matrix[i - 1][j] :
                            in.nextInt() + matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
                }
            }
        }
        for (int i = 0; i < numberOfRequests; i++) {
            int Y1 = in.nextInt();
            int X1 = in.nextInt();
            int Y2 = in.nextInt();
            int X2 = in.nextInt();

            int sum = matrix[Y2 - 1][X2 - 1];

            if ( (X1 > 1) && (Y1 > 1)) {
                sum += matrix[Y1 - 2][X1 - 2] - matrix[Y2 - 1][X1 - 2] - matrix[Y1 - 2][X2 - 1];
            } else if (X1 > 1) {
                sum += matrix[Y1 - 1][X1 - 2] - matrix[Y2 - 1][X1 - 2];
            } else if (Y1 > 1) {
                sum -= matrix[Y1 - 2][X2 - 1];
            }

           /* for (int n = Y1 - 1; n < Y2; n++) {

                sum += (X1 > 1) ? (matrix[n][X2 - 1] - matrix[n][X1 - 2]) : matrix[n][X2 - 1];
            }

            */
            System.out.println(sum);
        }
    }
}
