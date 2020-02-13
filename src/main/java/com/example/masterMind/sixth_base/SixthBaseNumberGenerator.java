package com.example.masterMind.sixth_base;

public class SixthBaseNumberGenerator {
    public static void increment(int[] num) {
        num[0] += 1;
        if (num[0] == 6) {
            incrementOnPos(num, 0);
            if (num[1] == 6) {
                incrementOnPos(num, 1);
                if (num[2] == 6) {
                    incrementOnPos(num, 2);
                    overflow(num);
                }
            }
        }
    }

    private static void incrementOnPos(int[] number, int pos) {
        number[pos] = 0;
        number[pos + 1] += 1;
    }

    private static void overflow(int[] number) {
        if (number[3] == 6) {
            throw new RuntimeException("No Possible Number!");
        }
    }
}
