package com.gdglima.studyjam.lesson1;

/**
 * Created by emedinaa on 5/01/16.
 */
public class AssigningValues {

    int firstValue = 5;
    int secondValue;
    int thirdValue;

    float heightInMeters = 1.74f;

    String greeting = "Hello World!";


    public String getMessage()
    {
        String message= "firstValue :"+firstValue+" secondValue :"+secondValue+" thirdValue:"+thirdValue+ " heightInMeters:"+heightInMeters+
               " greeting:"+greeting;

        return message;
    }
}
