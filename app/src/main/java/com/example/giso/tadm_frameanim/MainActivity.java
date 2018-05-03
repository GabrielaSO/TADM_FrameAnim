package com.example.giso.tadm_frameanim;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button run, stop;
    ImageView imagen;
    AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        run=findViewById(R.id.run);
        stop=findViewById(R.id.stop);
        imagen = findViewById(R.id.imagen);

        if(imagen==null){
            throw new AssertionError();}
        imagen.setBackgroundResource(R.drawable.bunny_animation);
        imagen.setVisibility(View.INVISIBLE);

        anim = (AnimationDrawable) imagen.getBackground();

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen.setVisibility(View.VISIBLE);
                if (anim.isRunning()){
                    anim.stop();
                }else{
                    anim.start();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.stop();
            }
        });
    }
}
