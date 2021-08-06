package krt.wid.demo.base;

import android.content.Context;
import android.content.SharedPreferences;

import krt.wid.update.UpdateInfo;
import krt.wid.util.ParseJsonUtil;

/**
 * @author: MaGua
 * @create_on:2021/8/2 16:25
 * @description
 */
public class SpUtil {

    private Context mContext;

    private static final String USER = "demo";
    private SharedPreferences sp;

    public SpUtil(Context context) {
        this.mContext = context;
        sp = mContext.getSharedPreferences(USER, Context.MODE_PRIVATE);
    }

    public int getInt(String key, int defaultVal) {
        return sp.getInt(key, defaultVal);
    }

    public void putInt(String key, int val) {
        sp.edit().putInt(key, val).commit();
    }

    public boolean getBoolean(String key, boolean defaultVal) {
        return sp.getBoolean(key, defaultVal);
    }

    public void putBoolean(String key, boolean val) {
        sp.edit().putBoolean(key, val).commit();
    }

    public String getString(String key, String defaultVal) {
        return sp.getString(key, defaultVal);
    }

    public void putString(String key, String val) {
        sp.edit().putString(key, val).commit();
    }

}
