package com.example;

public class StringJoin {
    /**
     * Field Initialisation
     */
    private String strings;
    private String setStrings;
    final private String sp = " ";
    final private String sp2 = "   ";

    /**
     * First constructor to handle four string arguments
     * @param s1 First String Parameter
     * @param s2 Second String Parameter
     * @param s3 Third String Parameter
     * @param s4 Fourth String Parameter
     */
    public StringJoin(String s1,String s2,String s3,String s4){
        strings = (s1+sp+s2+sp2+s3+sp+s4);
    }
    
    /**
     * Second constructor to handle six string arguments
     * @param s1 First String Parameter
     * @param s2 Second String Parameter
     * @param s3 Third String Parameter
     * @param s4 Fourth String Parameter
     * @param s5 Fifth String Parameter
     * @param s6 Sixth String Parameter
     */
    public StringJoin(String s1,String s2,String s3,String s4,String s5,String s6){
        strings = (s1+sp+s2+sp2+s3+sp+s4+sp2+s5+sp+s6);
    }

    /**
     * Function that gets concatenated strings from constructors and returns them upon call
     * @return returns concatenated strings
     */
    public String getStrings(){
        setStrings = strings;
        return setStrings;
    }
}
