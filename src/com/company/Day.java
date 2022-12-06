package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

abstract public class Day {
    protected ArrayList<String> data;

    public Day(String pathToData, int day) {
        data = readFile(pathToData);
        System.out.println("Das Ergebnis von Task 1 Day "+ day +" ist "+task1());
        System.out.println("Das Ergebnis von Task 2 Day "+ day +" ist "+task2()+"\n");
    }

    //Reads files.
    private ArrayList<String> readFile(String filePath){
        BufferedReader reader;
        ArrayList<String> words = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {

                words.add(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    abstract protected int task1();
    abstract protected int task2();
}
