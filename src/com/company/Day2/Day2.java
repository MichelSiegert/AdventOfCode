package com.company.Day2;

import com.company.Day;

public class Day2 extends Day {

    public Day2(String path) {
        super(path, 2);
    }

    public int task1(){
        int score = 0;
        for (String line : data){
            char[] inputs = line.toCharArray();
            score  += scoreCalculator1(inputs[0], inputs[2]);
        }
        return score;
    }

    public int task2(){
        int score = 0;
        for (String line : data){
            char[] inputs = line.toCharArray();
            score  += scoreCalculator2(inputs[0], inputs[2]);
        }
        return score;
    }

    int scoreCalculator1(char oponent, char me){
        int score  = 0;
        if (me == 'X') {
            score += 1;
            me = 'A';
        } else if (me == 'Y') {
            score += 2;
            me = 'B';
        } else if (me == 'Z') {
            score += 3;
            me = 'C';
        }
        if (me == oponent) {
            score += 3;
        } else if (me == 'A' && oponent == 'C' ||
                me == 'B' && oponent == 'A' ||
                me == 'C' && oponent == 'B') score += 6;
        return score;
    }

    int scoreCalculator2(char oponentsChoice, char result){
        int score  =0;

        if (result == 'Y') {
            score += 3;
            if (oponentsChoice == 'A') score += 1;
            else if (oponentsChoice == 'B') score += 2;
            if (oponentsChoice == 'C') score += 3;
        }
        else if (result == 'Z') {
            score += 6;
            if (oponentsChoice == 'A') score += 2;
            else if (oponentsChoice == 'B') score += 3;
            if (oponentsChoice == 'C') score += 1;
        }
        else{
            if (oponentsChoice == 'A') score += 3;
            else if (oponentsChoice == 'B') score += 1;
            if (oponentsChoice == 'C') score += 2;
        }
        return score;
    }
}
