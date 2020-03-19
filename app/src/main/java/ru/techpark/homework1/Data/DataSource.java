package ru.techpark.homework1.Data;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;


public class DataSource {
    private static List<MyData> data = null;
    private static DataSource sInstance;

    private static final int[] mColors = new int[]{
            Color.RED,
            Color.BLUE
    };

    private DataSource() {
        data = new ArrayList<>();

        for (int i = 0; i < CommonConst.num; ) {
            int color = mColors[isOdd(i)];
            data.add(new MyData("" + (++i), color));
        }
    }

    private static int isOdd(int i) {
        return i % 2 == 0 ? 1 : 0;
    }

    static public void addiction(int amount) {
        int color = mColors[isOdd(amount + 1)];
        data.add(new MyData("" + amount, color));
    }

    public synchronized static DataSource getInstance() {
        if (sInstance == null) {
            sInstance = new DataSource();
        }
        return sInstance;
    }

    public List<MyData> getData() {
        return data;
    }

    public static class MyData {
        private MyData(String count, int color) {
            this.count = count;
            this.color = color;
        }

        public final String count;
        public final int color;
    }


}
