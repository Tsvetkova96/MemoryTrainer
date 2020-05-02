package com.codebind.Classes;

import java.util.ArrayList;

public class Result {
    String size;
    String symbolType;
    String timeResult;
    String date;
    public Result(String date,String timeResult, String size, String symbolType) {
        this.date = date;
        this.timeResult = timeResult;
        this.size = size;
        this.symbolType = symbolType;
    }

    public static ArrayList<Result> GetResultsFromFile() {
        ArrayList<Result> list = new ArrayList<Result>();
        String fileResulText = FileHelper.ReadResultFromFile();
        var results = fileResulText.split("!!");
        for (String row : results) {
            var resultString = row.split(";");
            list.add(new Result(resultString[0],resultString[1],resultString[3],resultString[2]));
        }
        return  list;
    }
    public String getSize() {
        return  size;
    }
    public String getDate() {
        return  date;
    }
    public String getTimeResult() {
        return  timeResult;
    }
    public String getSymbolType() {
        return  symbolType;
    }
}
