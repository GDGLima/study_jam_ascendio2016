package com.gdglima.studyjam.samplecolor;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gdglima.studyjam.samplecolor.fragments.DrawFragment;
import com.gdglima.studyjam.samplecolor.fragments.SelectFragment;


public class ColorActivity extends AppCompatActivity implements OnColorListener{

    private SelectFragment selectFragment;
    private DrawFragment drawFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        selectFragment=(SelectFragment)getSupportFragmentManager().findFragmentById(
                R.id.fragmentSelected);
        drawFragment=(DrawFragment)getSupportFragmentManager().findFragmentById(
                R.id.fragmentDraw);
    }

    public void recibirColordelFrag1yEnviarloFrag2(int position)
    {
        Log.v("CONSOLE", "2. recibirColordelFrag1yEnviarloFrag2 " + position);
        drawFragment.onDrawColor(position);
    }

    @Override
    public void recibirColordelFrag1yEnviarloFrag2Cool(int position) {
        Log.v("CONSOLE", "2. recibirColordelFrag1yEnviarloFrag2Cool " + position);
        drawFragment.onDrawColor(position);
        /*switch (position)
        {
            case 0:
                drawFragment.getView().setBackgroundColor(Color.GREEN);
                break;
            case 1:
                drawFragment.getView().setBackgroundColor(Color.RED);
                break;
        }*/

    }
}
