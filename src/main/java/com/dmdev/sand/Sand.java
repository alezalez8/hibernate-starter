package com.dmdev.sand;

public class Sand {
    public static void main(String[] args) {
        int n = 435364722;

        int m = 0;

        long start = System.currentTimeMillis();
        System.out.println("1 time = " + start);

        for (int i = 0; i < 1_000_000; i++) {

            m = (int) (Math.floor(Math.log10(n)) + 1);
        }
        System.out.println("1: " + m);

        long time = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            m = String.valueOf(n).split("").length;

        }
        System.out.println("2: " + m);

        time = System.currentTimeMillis() - start;

        System.out.println("2 time = " + start);



    }
}
