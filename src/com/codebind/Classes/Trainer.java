package com.codebind.Classes;

import java.util.ArrayList;
import java.util.Collections;

public class Trainer {
    ArrayList<String> ShulteTable;
    int currentIndex;
    public Trainer(int size) {
        ShulteTable = new ArrayList<>();
        for (int i = 1; i <= size; ++i) {
            ShulteTable.add(String.valueOf(i));
        }
        Collections.shuffle(ShulteTable);
        currentIndex = 0;
    }
    public  boolean checkSymbol(String checkingSymbol) {
        String currentSymbol = ShulteTable.get(currentIndex);
        if(currentSymbol.equals(checkingSymbol)){
            currentIndex++;
            return  true;
        }
        return  false;
    }
    public boolean CheckEndTrainig() {
        return currentIndex == ShulteTable.size();
    }
    public ArrayList<String> getShulteTable() {
        return  ShulteTable;
    }
}
