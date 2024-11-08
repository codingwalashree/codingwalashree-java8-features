package org.cws.stringops;

public class StringOperation {
    public String toSpecialUpperCase(String input){
        if(input == null || input.isEmpty()) {
            return "EMPTY";
        }
        return input.toUpperCase();
    }
}
