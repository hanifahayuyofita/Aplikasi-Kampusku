package com.example.aplikasikampusku;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoginSplashScreen extends AppCompatActivity {
    public  static int SPLASH_TIMER = 3000 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_splash_screen);
        new Handler() .postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoginSplashScreen.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMER);
    }
}