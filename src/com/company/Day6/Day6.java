package com.company.Day6;

import com.company.Day;

import java.util.Arrays;

public class Day6 extends Day {
    public Day6(String path){
        super(path, 6);
    }
    @Override
    protected int task1() {
        char[] characters = new char[4];
        String line =  data.get(0);
        Arrays.fill(characters, line.charAt(0));
        for (int i=0; i < line.length(); i++) {
            pushCharacter(characters, line.charAt(i));
            if(isEveryCharUnique(characters)) return i+1;
        }
        return -1;
    }

    private void pushCharacter(char[] characters, char c){

        if (characters.length - 1 >= 0) System.arraycopy(characters, 0, characters, 1, characters.length - 1);
        characters[0]= c;
    }

    private boolean isEveryCharUnique(char[] characters) {
        for(int i=0; i < characters.length; i++){
            for(int j=i+1; j < characters.length; j++){
                if(characters[i] == characters[j]) return false;
            }
        }
        return true;
    }

    @Override
    protected int task2() {
            char[] characters = new char[14];
            String line =  data.get(0);
            Arrays.fill(characters, line.charAt(0));
            for (int i=0; i < line.length(); i++) {
                pushCharacter(characters, line.charAt(i));
                if(isEveryCharUnique(characters)) return i+1;
            }
            return -1;
    }
}
