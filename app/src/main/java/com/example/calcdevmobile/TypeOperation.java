package com.example.calcdevmobile;

public enum TypeOperation {
    ADD("+"),
    SUBSTRACT("-"),
    DIVIDE("/"),
    MULTIPLY("x");

    private String symbole;

    TypeOperation(String s){
        symbole = s;
    }

    public String getSymbole() {
        return symbole;
    }
}
