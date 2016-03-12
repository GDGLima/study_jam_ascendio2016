package com.gdglima.studyjam.lesson1;

/**
 * Created by emedinaa on 5/01/16.
 */
public class BooleanType {

    int n1 = 1;
    int n2 = 2;

    boolean greater = (n1 > n2);
    boolean equalN1To1 = (n1 == 1);

    public String getMessage()
    {
        String message= "greater :"+greater+" equalN1To1:"+equalN1To1;
        return message;
    }
}
