import java.util.Scanner;

public class Task_6_OSLight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfSectors = in.nextInt();
        int numberOfOperations = in.nextInt();
        int[][] startFinishOfSegments = new int[2][numberOfOperations];
        boolean[] isSystemDamage = new boolean[numberOfOperations];

        for (int i = 0; i < numberOfOperations; i++) {
            startFinishOfSegments[0][i] = in.nextInt();
            startFinishOfSegments[1][i] = in.nextInt();
        }
        for (int i = 0; i < numberOfOperations - 1; i++) {
            for (int j = i + 1; j < numberOfOperations; j++) {
                if ((startFinishOfSegments[0][i] <= startFinishOfSegments[1][j]) &&
                        (startFinishOfSegments[0][j] <= startFinishOfSegments[1][i]))
                    isSystemDamage[i] = true;
            }
        }
        int countSystems = 0;
        for (int i = 0; i < numberOfOperations; i++)
            countSystems = (isSystemDamage[i]) ? countSystems : 1 + countSystems;

        System.out.println(countSystems);

    }
}
