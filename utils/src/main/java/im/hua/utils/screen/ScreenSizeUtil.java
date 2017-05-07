package im.hua.utils.screen;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by hua on 2017/5/7.
 */

public class ScreenSizeUtil {
    private static DisplayMetrics mDisplayMetrics = null;

    public static DisplayMetrics getScreenSize(Context context) {
        if (mDisplayMetrics == null) {
            WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            mDisplayMetrics = new DisplayMetrics();
            display.getMetrics(mDisplayMetrics);
        }
        return mDisplayMetrics;
    }

    public static float getDeviceDensity(Context context) {
        return getScreenSize(context).density;
    }
}
