package com.example.imgod.md_6;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.transition.Transition;
import android.util.Pair;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        img_main = (ImageView) findViewById(R.id.img_main);
        img_main.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startSecondActivity();
    }

    private void startSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = new ChangeImageTransform();
            transition.setDuration(3000);
            getWindow().setExitTransition(transition);
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, Pair.create((View) img_main, "big_img"));
            Bundle bundle = activityOptions.toBundle();
            startActivity(intent, bundle);
        } else {
            Toast.makeText(this, "低版本", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }
}
