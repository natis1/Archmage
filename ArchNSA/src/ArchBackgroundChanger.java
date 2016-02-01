import java.util.*;

public class ArchBackgroundChanger {
    public static native int SystemParametersInfo(int uiAction,int uiParam,String pvParam,int fWinIni);

    static {
        System.loadLibrary("user32");
    }

    public int Change(String path) {
        return SystemParametersInfo(20, 0, path, 0);
    }


}