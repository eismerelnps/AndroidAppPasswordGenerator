package com.elnps.passwordgenerator;

public class Character {

    private final char[] capitalChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y','Z'};
    private final char[] MinChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y','z'};
    private final char[] Numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private final char[] especialChars = {'!','@','#','$','%','&','*','(',')','_','+','-','=','[',']','|','.','/','?','>','<'};
    public Character(){
    }
    public char[] getCapitalChars() {
        return capitalChars;
    }

    public char[] getMinChars() {
        return MinChars;
    }

    public char[] getNumbers() {
        return Numbers;
    }

    public char[] getEspecialChars() {
        return especialChars;
    }
}
