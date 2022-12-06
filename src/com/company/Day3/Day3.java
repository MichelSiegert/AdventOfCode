package com.company.Day3;

import com.company.Day;

import java.util.ArrayList;

public class Day3 extends Day {

    public Day3(int day) {
        super(day);
    }
    @Override
    protected int task1() {
        int sum = 0;
        for(String line: data){
            int mid = line.length()/2;
            String[] compartments  = {line.substring(0,mid), line.substring(mid)};
            sum += getRepeatingNumbers(compartments[0], compartments[1]);
        }

        return sum;
    }
    int scoring(char letter){
        String scoring = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return scoring.indexOf(letter)+1;
        }

    int getRepeatingNumbers(String compartmentA, String compartmentB){
        int sum = 0;
        ArrayList<Character> uniqueLetters = new ArrayList<>();
        for (char letter: compartmentA.toCharArray()){
            if (!uniqueLetters.contains(letter)) uniqueLetters.add(letter);
        }
        for(char letter: uniqueLetters){
            if(compartmentB.contains(""+letter)) {
                sum += scoring(letter);
            }
        }
        return sum;
    }

    @Override
    protected int task2() {
        int sum=0;
        for(int i =0; i < data.size(); i+= 3){
            String commonLetters = collectCommonLetters(data.get(i), data.get(i+1));
            String resultString = collectCommonLetters(commonLetters, data.get(i+2));
            char result = resultString.charAt(0);
            sum += scoring(result);
        }

        return sum;
    }

    String collectCommonLetters(String lineA, String lineB){
        StringBuilder collectedLetters= new StringBuilder();
        char[] letters = lineA.toCharArray();
        for(char letter: letters){
            if(lineB.contains(""+letter)){
                collectedLetters.append(letter);
            }
        }
        return collectedLetters.toString();
    }
}
