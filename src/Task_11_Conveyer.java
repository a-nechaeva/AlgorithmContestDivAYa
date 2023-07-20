import java.util.Scanner;

public class Task_11_Conveyer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTests = in.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            int numberOfBoxes = in.nextInt();
            double[] boxes = new double[numberOfBoxes];
            for (int j = 0; j < numberOfBoxes; j++) {
                boxes[j] = in.nextDouble();
            }
        }
    }
}
