package com.company.Day1;

import com.company.Day;

import java.util.Arrays;

public class Day1 extends Day {

    public Day1(int day) {
        super(day);
    }

    public int task1() {
        int sum = 0;
        int maximum = 0;

        for (String line : this.data) {
            if (line.equals("")) {
                if (sum > maximum) {
                    maximum = sum;
                }
                sum = 0;
            } else {
                try {
                    sum += Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Error: " + e + "! Value:" + line);
                }
            }
        }
        return maximum;

    }

    public int task2() {
        int[] topThree = new int[3];
        int sum = 0;

        for (String line : data) {
            if (line.equals("")) {
                if (sum > topThree[0]) {
                    topThree[2] = topThree[1];
                    topThree[1] = topThree[0];
                    topThree[0] = sum;
                } else if (sum > topThree[1]) {

                    topThree[2] = topThree[1];
                    topThree[1] = sum;
                } else if (sum > topThree[2]) {
                    topThree[2] = sum;
                }
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }

        }
        return Arrays.stream(topThree).sum();
    }
}
