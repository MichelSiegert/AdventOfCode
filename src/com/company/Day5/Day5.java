package com.company.Day5;

import com.company.Day;

import java.util.ArrayList;

public class Day5 extends Day {
    public Day5(int day) {
        super(day);
    }
    @Override
    protected int task1() {
        ArrayList<ArrayList<Character>> towers =  declareTowers();
        moving(towers);

        return 0;
    }

    private void moving(ArrayList<ArrayList<Character>> towers) {
        for (String line:data){
            if (line.contains("move")){
                String[] words = line.split(" ");
                int numberBoxes = Integer.parseInt(words[1]);
                int fromTower = Integer.parseInt(words[3]) - 1;
                int toTower = Integer.parseInt(words[5]) - 1;

                for (int i=0; i < numberBoxes; i++){
                    if(towers.get(fromTower).size() > 0) {
                        int sizeOfTower = towers.get(fromTower).size();
                        char box = towers.get(fromTower).get(sizeOfTower-1);
                        towers.get(toTower).add(box);
                        towers.get(fromTower).remove(sizeOfTower-1);
                    }
                }
            }
        }
    }

    ArrayList<ArrayList<Character>> declareTowers(){
        ArrayList<ArrayList<Character>> towers = new ArrayList<>();
        int lastIndex;
        for (int i=0; i< 9; i++) {
            towers.add(0, new ArrayList<>());
        }
        for(String line: data){
            int index;
            lastIndex=0;
            if (!line.contains("["))return towers;
            while(line.length() > lastIndex &&line.substring(lastIndex).contains("[")){
                index = line.indexOf("[", lastIndex);
                towers.get(index/4).add(0,line.charAt(index+1));
                line = line.substring(0,index)+'_'+line.substring(index+1);
                lastIndex = index+1;
            }
        }
        return towers;
    }

    @Override
    protected int task2() {
        ArrayList<ArrayList<Character>> towers =  declareTowers();
        movingB(towers);
        return 0;
    }

    private void movingB(ArrayList<ArrayList<Character>> towers) {
        for (String line:data){
            if (line.contains("move")){
                String[] words = line.split(" ");
                int numberBoxes = Integer.parseInt(words[1]);
                int fromTower = Integer.parseInt(words[3]) - 1;
                int toTower = Integer.parseInt(words[5]) - 1;

                int sizeOfTower = towers.get(fromTower).size();

                for (int i=0; i < numberBoxes; i++){
                    if(towers.get(fromTower).size() > 0) {
                        char box = towers.get(fromTower).get(sizeOfTower - numberBoxes);
                        towers.get(toTower).add(box);
                        towers.get(fromTower).remove(sizeOfTower-numberBoxes);
                    }
                }
            }
        }
    }
}
