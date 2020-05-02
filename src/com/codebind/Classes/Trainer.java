package com.codebind.Classes;

import java.util.ArrayList;
import java.util.Collections;

public class Trainer {
    ArrayList<String> symbolSequence;
    int currentIndex;
    public Trainer(int size, String symbolType) {
        createsymbolSequence(size, symbolType);

        currentIndex = 0;
    }
    private void createsymbolSequence(int size, String symbolType) {
        symbolSequence = new ArrayList<>();
        switch (symbolType) {
            case ("Цифры"):
                for (int i = 1; i <= size; ++i) {
                    symbolSequence.add(String.valueOf(i));
                }
                break;
            case ("РУС"):
                String[] alphabet = getRussianAlphabet();
                for (int i = 0; i < size; ++i) {
                    symbolSequence.add(alphabet[i]);
                }
                break;
            case ("АНГЛ"):
                for (int i = 0; i < size; ++i) {
                    symbolSequence.add(Character.toString ((char) (i + 65)));
                }
                break;
        }
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

    private String[] getRussianAlphabet() {
        String[] alphabet = {
                "А","Б","В","Г","Д","Е","Ё","Ж","З","И","Й","К","Л","М","Н","О","П","Р","С","Т","У","Ф","Х","Ц","Ч","Ш","Щ","Ъ","Ы","Ь","Э","Ю","Я"
        };
        return alphabet;
    }

}
