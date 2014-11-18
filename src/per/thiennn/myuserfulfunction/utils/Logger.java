package per.thiennn.myuserfulfunction.utils;
/*
 * Created by ThienNN : 18/11/2014
 * Create log for debug mod
 */
import per.thiennn.myusefulfunction.BuildConfig;
import android.util.Log;
public class Logger {
    private static boolean debug = BuildConfig.DEBUG;

    public static void d(String tag, String msg) {
        if (debug) {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (debug) {
            Log.e(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (debug) {
            Log.i(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (debug) {
            Log.v(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (debug) {
            Log.w(tag, msg);
        }
    }
}
