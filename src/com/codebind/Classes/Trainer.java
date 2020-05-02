package com.codebind.Classes;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Класс для управления процессом тренировки со свойствами <b>currentIndex</b>, <b>symbolSequence</b>, <b>timeResult</b> и <b>date</b> .
 * @autor Цветкова
 * @version 1.0
 */
public class Trainer {
    ArrayList<String> symbolSequence;
    int currentIndex;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param size - размер таблицы
     * @param symbolType - тип символов
     */
    public Trainer(int size, String symbolType) {
        createsymbolSequence(size, symbolType);

        currentIndex = 0;
    }
    /**
     * Функция создает последовательность символов для тренировки {@link Trainer#symbolSequence} в засисимости от размера таблицы и типа символов
     * @param size - размер таблицы
     * @param symbolType - тип символов
     */
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
    /**
     * Функция проверяет явлется ли символ, требуемым для нажатия
     * @param checkingSymbol - проверяемый символ
     * @return  возвращает true если символы совпадают
     */
    public  boolean checkSymbol(String checkingSymbol) {
        if(currentIndex >= symbolSequence.size()) return  false;
        String currentSymbol = symbolSequence.get(currentIndex);
        if(currentSymbol.equals(checkingSymbol)){
            currentIndex++;
            return  true;
        }
        return  false;
    }
    /**
     * Функция проверяет пройдены ли все символы в тренировке
     * @return  возвращает true если все символы пройдены
     */
    public boolean checkEndTrainig() {
        return currentIndex == symbolSequence.size();
    }
    /**
     * Функция создает таблицу Шульте из последовательности символов для тренировки {@link Trainer#symbolSequence}
     * @return  возвращает таблицу Шульте в виде списка
     */
    public ArrayList<String> getShulteTable() {
        ArrayList<String> shulteTable = new ArrayList<String>();
        shulteTable.addAll(symbolSequence);
        Collections.shuffle(shulteTable);
        return  shulteTable;
    }
    /**
     * Функция возвращает следующий символ который необходимо нажать
     * @return  возвращает следующий символ который необходимо нажать
     */
    public String getNextSymbol() {
        return  symbolSequence.get(currentIndex);
    }
    /**
     * Функция возвращает русский алфавит для {@Trainer#createsymbolSequence}
     * @return  русский алфавит в виде массива строк
     */
    private String[] getRussianAlphabet() {
        String[] alphabet = {
                "А","Б","В","Г","Д","Е","Ё","Ж","З","И","Й","К","Л","М","Н","О","П","Р","С","Т","У","Ф","Х","Ц","Ч","Ш","Щ","Ъ","Ы","Ь","Э","Ю","Я"
        };
        return alphabet;
    }

}
