package com.example.proyectofab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity
{

    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_v2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                click = !click;
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Interpolator interpolator = AnimationUtils.loadInterpolator(getBaseContext(), android.R.interpolator.fast_out_slow_in);
                    view.animate()
                            .rotation(click ? 45f : 0)
                            .setInterpolator(interpolator)
                            .start();
                    Toast.makeText(getApplicationContext(), "FAB", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
