package edu.cnm.deepdive.lofistudio;

import android.graphics.Color;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this)
            .withFullScreen()
            .withTargetActivity(MainActivity.class)
            .withSplashTimeOut(3000)
            .withBackgroundColor(Color.parseColor("#30FF37"))
            .withHeaderText("CNM DDC")
            .withFooterText("JA COHORT 10")
            .withBeforeLogoText("Welcome To")
            .withAfterLogoText("NM Trailmaster")
            .withLogo(R.drawable.lofi_splash_screen_3);
        config.getHeaderTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getBeforeLogoTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextColor(Color.WHITE);
        View easySplashScreen = config.create();
        setContentView(easySplashScreen);

    }
}