package com.company.Day4;

import com.company.Day;

public class Day4 extends Day {

    public Day4(int day) {
        super(day);
    }

    @Override
    protected int task1() {
        int sum = 0;
        for(String line: data){
            String[] sides = line.split(",");
            String assignmentA = sides[0];
            String assignmentB = sides[1];
            int lowerBoundA = Integer.parseInt(assignmentA.split("-")[0]);
            int upperBoundA = Integer.parseInt(assignmentA.split("-")[1]);
            int lowerBoundB = Integer.parseInt(assignmentB.split("-")[0]);
            int upperBoundB = Integer.parseInt(assignmentB.split("-")[1]);
            if (upperBoundA >= upperBoundB && lowerBoundB >= lowerBoundA ||
                    upperBoundB >= upperBoundA && lowerBoundA >= lowerBoundB){
                sum++;
            }

        }

        return sum;
    }

    @Override
    protected int task2() {
        int sum = 0;
        for(String line: data){
            String[] sides = line.split(",");
            String assignmentA = sides[0];
            String assignmentB = sides[1];
            int lowerBoundA = Integer.parseInt(assignmentA.split("-")[0]);
            int upperBoundA = Integer.parseInt(assignmentA.split("-")[1]);
            int lowerBoundB = Integer.parseInt(assignmentB.split("-")[0]);
            int upperBoundB = Integer.parseInt(assignmentB.split("-")[1]);
            if (!(upperBoundB < lowerBoundA || lowerBoundB > upperBoundA) ){
                sum++;
            }

        }

        return sum;
    }
}
