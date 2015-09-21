package com.jpventura.popularmovies.app;

import android.app.Activity;
import android.os.Build;

import com.jpventura.popularmovies.R;

public class SetContentView {
    public static void execute(Activity activity) {
        if (isSamsung_4_2_2()) {
            activity.setContentView(R.layout.activity_main);
        } else {
            activity.setContentView(R.layout.activity_main);
        }
    }

    private static boolean isSamsung_4_2_2() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
            return false;
        }

        return Build.VERSION.RELEASE.startsWith("4.2.2");
    }
}
