package com.example.kcra.slmsosiss.Functionality;

import android.content.Context;
import android.content.pm.PackageManager;

public class OperationZ {

    public static boolean isAppAvailable (Context context, String appName) {
        PackageManager pM = context.getPackageManager();
        try {
            pM.getPackageInfo(appName,PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
