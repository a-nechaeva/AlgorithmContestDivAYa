import java.util.Scanner;
import static java.lang.Math.*;

public class Task_7_SNTP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String clientTimeRequest = in.nextLine();
        String serverTimeRequest = in.nextLine();
        String clientTimeResponse = in.nextLine();

        int absClientTimeRequest = timeDecoder(clientTimeRequest);
        int absServerTimeRequest = timeDecoder(serverTimeRequest);
        int absClientTimeResponse = timeDecoder(clientTimeResponse);

        // случай, когда со стороны клиента наступили новые сутки
        if (absClientTimeRequest > absClientTimeResponse)
            absClientTimeResponse += 24 * 60 * 60;

        int difference = round((float) (absClientTimeResponse - absClientTimeRequest) / 2);
        int absRealTime = (absServerTimeRequest + difference) % (24 * 60 * 60);
        String realTime = timeCoder(absRealTime);
        System.out.println(realTime);
       // System.out.println(absClientTimeRequest + " " +  absServerTimeRequest + " " + absClientTimeResponse);
    }
    public static int timeDecoder(String strTime) {
        String[] hMS = strTime.split(":");
        int time = (( Integer.parseInt(hMS[0]) * 60 ) + Integer.parseInt(hMS[1])) * 60 + Integer.parseInt(hMS[2]);
        return time;
    }

    public static String timeCoder(int absTime) {
        int ss = absTime % 60;
        int mm = (absTime / 60) % 60;
        int hh = absTime / (60 * 60);

        String s = (ss / 10 > 0) ? Integer.toString(ss) : "0" + ss;
        String m = (mm / 10 > 0) ? Integer.toString(mm) : "0" + mm;
        String h = (hh / 10 > 0) ? Integer.toString(hh) : "0" + hh;
        return h + ":" + m + ":" + s;
    }
}
