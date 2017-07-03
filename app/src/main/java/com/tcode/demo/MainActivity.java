package com.tcode.demo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.tcode.demo.util.blurutil.BlurLayout;

public class MainActivity extends AppCompatActivity {


    private Context mContext;
    private BlurLayout mSampleLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initView();
    }

    private void init()
    {
        mContext = this;
        BlurLayout.setGlobalDefaultDuration(450);
        mSampleLayout = (BlurLayout)findViewById(R.id.blurLayout);
    }

    private void initView(){

        View hover = LayoutInflater.from(mContext).inflate(R.layout.blur_layout, null);

        hover.findViewById(R.id.heart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Tada)
                        .duration(550)
                        .playOn(v);
                Toast.makeText(mContext, "You like it, Right?", Toast.LENGTH_SHORT).show();
            }
        });
        hover.findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Swing)
                        .duration(550)
                        .playOn(v);
            }
        });
        mSampleLayout.setHoverView(hover);
        mSampleLayout.setBlurDuration(550);
        mSampleLayout.addChildAppearAnimator(hover, R.id.heart, Techniques.FlipInX, 550, 0);
        mSampleLayout.addChildAppearAnimator(hover, R.id.share, Techniques.FlipInX, 550, 250);
        mSampleLayout.addChildAppearAnimator(hover, R.id.more, Techniques.FlipInX, 550, 500);

        mSampleLayout.addChildDisappearAnimator(hover, R.id.heart, Techniques.FlipOutX, 550, 500);
        mSampleLayout.addChildDisappearAnimator(hover, R.id.share, Techniques.FlipOutX, 550, 250);
        mSampleLayout.addChildDisappearAnimator(hover, R.id.more, Techniques.FlipOutX, 550, 0);

        mSampleLayout.addChildAppearAnimator(hover, R.id.description, Techniques.FadeInUp);
        mSampleLayout.addChildDisappearAnimator(hover, R.id.description, Techniques.FadeOutDown);

    }


}
