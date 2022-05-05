package leetCode.leetCode_2000;

import java.util.HashMap;
import java.util.Map;

public class leetCode_1629_按键持续时间最长的键 {
    public static void main(String[] args) {
        int[] releaseTimes = {12, 23, 36, 46, 62};
        String keysPressed = "spuda";
        System.out.println(slowestKey(releaseTimes, keysPressed));
    }

    private static char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxInt = releaseTimes[0];
        char maxStr = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length;i++){
            int maxTemp = releaseTimes[i]-releaseTimes[i-1];
            if (maxTemp>maxInt||(maxInt==maxTemp&&keysPressed.charAt(i)>maxStr)){
                maxInt = maxTemp;
                maxStr = keysPressed.charAt(i);
            }
        }
        return maxStr;
    }
}