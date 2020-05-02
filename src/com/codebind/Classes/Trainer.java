package com.codebind.Classes;

import java.util.ArrayList;
import java.util.Collections;

public class Trainer {
    ArrayList<String> symbolSequence;
    int currentIndex;
    public Trainer(int size) {
        symbolSequence = new ArrayList<>();
        for (int i = 1; i <= size; ++i) {
            symbolSequence.add(String.valueOf(i));
        }
        currentIndex = 0;
    }
    public  boolean checkSymbol(String checkingSymbol) {
        String currentSymbol = symbolSequence.get(currentIndex);
        if(currentSymbol.equals(checkingSymbol)){
            currentIndex++;
            return  true;
        }
        return  false;
    }
    public boolean checkEndTrainig() {
        return currentIndex == symbolSequence.size();
    }
    public ArrayList<String> getShulteTable() {
        ArrayList<String> shulteTable = new ArrayList<String>();
        shulteTable.addAll(symbolSequence);
        Collections.shuffle(shulteTable);
        return  shulteTable;
    }
    public String getNextSymbol() {
        return  symbolSequence.get(currentIndex);
    }
}
