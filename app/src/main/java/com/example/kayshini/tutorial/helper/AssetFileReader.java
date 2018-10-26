package com.example.kayshini.tutorial.helper;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class AssetFileReader {

    private static final String TAG = "Helper";
    /**
     * Helper method to read a given file from the assets, and return the contents of the file
     * @param context
     * @param fileName
     * @return the contents of a given file
     */
    public static String readElementsFromAssets(Context context, String fileName) {
        String elementsJsonString = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            elementsJsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.e(TAG, ex.getMessage(), ex.getCause());
        }

        Log.d(TAG, elementsJsonString);

        return elementsJsonString;
    }
}
