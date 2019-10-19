package com.example.flowers;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flowers.common.Common;
import com.wang.avi.AVLoadingIndicatorView;

public class FirstScreen extends AppCompatActivity {
    AVLoadingIndicatorView vba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        vba = (AVLoadingIndicatorView) findViewById(R.id.vba);
        startAnim();
        View parentLayout = findViewById(android.R.id.content);

        if (Common.isConnectedToInternet(FirstScreen.this)) {
            int seconwaiting = 2;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(FirstScreen.this, loginActivity.class));
                    finish();
                }
            }, seconwaiting * 2000);

        } else {
            Toast.makeText(this, "no internet connection", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    void startAnim() {
        vba.show();

    }

    void stopAnim() {
        vba.hide();
        // or avi.smoothToHide();
    }

}
