import java.util.Scanner;
import static java.lang.Math.*;

public class Task_4_PetyaVasyaMathTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int classmates = in.nextInt();
        int options = in.nextInt();
        int rowDeskPetya = in.nextInt();
        int sitSidePetya = in.nextInt();

        // нахождение "абсолютного" места Пети
        int placePetya = (rowDeskPetya - 1) * 2 + sitSidePetya;

        // нахождение "абсолютного" места Васи впереди Пети
        int placeVasya1 = placePetya - options;

        // нахождение "абсолютного" места Васи позади Пети
        int placeVasya2 = placePetya + options;

        int rowDeskVasya;
        int sitSideVasya;
        if (placeVasya2 <= classmates) {
            int optimalSitVasya  = (abs((placeVasya2 + 1) / 2 - rowDeskPetya) > abs((placeVasya1 + 1) / 2 - rowDeskPetya)) ?
                    placeVasya1 : placeVasya2;
            rowDeskVasya = (optimalSitVasya + 1) / 2;
            sitSideVasya = (optimalSitVasya % 2 == 0) ? 2 : 1;
            System.out.println(rowDeskVasya + " " + sitSideVasya);
        } else {
            if (placeVasya1 < 1)
                System.out.println(-1);
            else {
                rowDeskVasya = (placeVasya1 + 1) / 2;
                sitSideVasya = (placeVasya1 % 2 == 0) ? 2 : 1;
                System.out.println(rowDeskVasya + " " + sitSideVasya);
            }

        }
    }
}
