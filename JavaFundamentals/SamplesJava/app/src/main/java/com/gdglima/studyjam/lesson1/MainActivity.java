package com.gdglima.studyjam.lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Fundamentos de Java
 * Referencia:
 *      http://www.java-examples.com/java-language-fundamentals
 *      https://docs.oracle.com/javase/tutorial/java/nutsandbolts/
 *      https://github.com/vhf/free-programming-books/blob/master/free-programming-books-es.md#java
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app();
    }

    private void app() {
        Log.v(TAG, "Hola ISIL Android");

        AssigningValues assigningValues= new AssigningValues();
        showMessage(assigningValues.getMessage());

        BooleanType booleanType= new BooleanType();
        showMessage(booleanType.getMessage());
    }
    private void samples()
    {

        //TODO escribir código aquí

        int n1 = 5;
        int n2 = 4;

        writeLine(n1 + n2); // 9
        writeLine(n1 + n2++); // 9
        writeLine(n1 + n2); // 10
        writeLine(n1 + (++n2)); // 11
        writeLine(n1 + n2); // 11


        writeLine(11 / 3); // 3
        writeLine(11 % 3); // 2
        writeLine(12 / 3); // 4

        writeLine(11.0 / 3); // 3.66666666666665
        writeLine(11 / 3.0); // 3.66666666666665
        writeLine(11 % 3);   // 2
        writeLine(11 % -3);  // 2
        writeLine(-11 % 3);  // -2

        writeLine("1.5 / 0.0 = " + (1.5 / 0.0)); // Infinity
        writeLine("-1.5 / 0.0 = " + (-1.5 / 0.0)); // -Infinity
        writeLine("0.0 / 0.0 = " + (0.0 / 0.0)); // NaN


        //------------------------------

        boolean a = true;
        boolean b = false;

        String day1="Lunes";
        String day2="Martes";

        writeLine(a && b); // False
        writeLine(a || b); // True
        writeLine(!b); // True
        writeLine(a==b); // False

        //En String no usar '=='
        writeLine(day1.equals(day2));//
        writeLine(!day1.equals(day2));//

        String estado=(a==b)?("TRUE"):("FALSE");
        writeLine(estado);

        int month=15;
        switch (month) {
            case 1:
                writeLine("January");
                break;
            case 2:
                writeLine("February");
                break;
            case 3:
                writeLine("March");
                break;
            case 4:
                writeLine("April");
                break;
            case 5:
                writeLine("May");
                break;
            case 6:
                writeLine("June");
                break;
            case 7:
                writeLine("July");
                break;
            case 8:
                writeLine("August");
                break;
            case 9:
                writeLine("September");
                break;
            case 10:
                writeLine("October");
                break;
            case 11:
                writeLine("November");
                break;
            case 12:
                writeLine("December");
                break;
            default:
                writeLine("no hay :P");
                break;
        }


        //----------------------------------

        int mA = 1;
        int mB = 2;
        if (mA < mB ) {
            writeLine("mA=1 , mB=2 --- mA < mB");
        }
        else {
            writeLine("mA=1 , mB=2 --- mA >= mB");
        }

        //--------------------------------------

        for (int i = 0; i < 10; ++i) {
            writeLine("elemento i "+i);
        }


        String[] days = new String[] {
                "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"
        };
        String[] nDays= new String[7];
        nDays[0]="Monday";
        nDays[1]="Tuesday";
        nDays[2]="Wednesday";
        nDays[3]="Thursday";
        nDays[4]="Friday";
        nDays[5]="Saturday";
        nDays[6]="Sunday";

        writeLine(nDays+" "+nDays.toString()+" longitud "+nDays.length);
        writeLine(days+" longitud "+days.length);

        for (String day : days) {
            writeLine(day);
        }
        // writeLine("Horror "+days[20]);
        writeLine("Horror "+days[days.length-1]);



    }

    private void writeLine(Object object)
    {
        Log.v(TAG, "--> " + object);
    }

    private void writeLine(String message)
    {
        Log.v(TAG, "--> " + message);
    }

    public void showMessage(String message)
    {
        Log.v(TAG, message);
    }


}
