package com.example.poyyamozhi.percent_login;

import android.os.Bundle;
import android.support.percent.PercentLayoutHelper;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout loginLinear, signUpLinear;
    private Button loginBtn, signUpBtn;
    TextView loginTv, signUpTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginLinear = findViewById(R.id.loginLinear);
        signUpLinear = findViewById(R.id.signUpLinear);
        loginBtn = findViewById(R.id.login);
        signUpBtn = findViewById(R.id.signUp);
        loginTv = findViewById(R.id.loginTv);
        signUpTv = findViewById(R.id.signupTv);
        loginLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("tag", "onClick: ");
                logInForm();
            }
        });
        signUpLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("tag", "onClick: ");
                signupForm();
            }
        });

    }


    private void signupForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) loginLinear.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.15f;
        loginLinear.requestLayout();

        PercentRelativeLayout.LayoutParams paramsSignUp = (PercentRelativeLayout.LayoutParams) signUpLinear.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignUp = paramsSignUp.getPercentLayoutInfo();
        infoSignUp.widthPercent = 0.85f;
        signUpLinear.requestLayout();

        signUpTv.setVisibility(View.GONE);
        loginTv.setVisibility(View.VISIBLE);

        Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_right_to_left);
        signUpLinear.startAnimation(translate);

        /*Animation clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_right_to_left);
        signUpBtn.startAnimation(clockwise);*/

    }

    private void logInForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) loginLinear.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.85f;
        loginLinear.requestLayout();

        PercentRelativeLayout.LayoutParams paramsSignUp = (PercentRelativeLayout.LayoutParams) signUpLinear.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignUp = paramsSignUp.getPercentLayoutInfo();
        infoSignUp.widthPercent = 0.15f;
        signUpLinear.requestLayout();

        signUpTv.setVisibility(View.VISIBLE);
        loginTv.setVisibility(View.GONE);

        Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_left_to_right);
        loginLinear.startAnimation(translate);

       /* Animation clockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_left_to_right);
        loginBtn.startAnimation(clockwise);*/

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginTv:
                //Log.e("tag", "onClick: ");
                logInForm();
                break;
            case R.id.signupTv:
                //Log.e("tag", "onClick: ");
                signupForm();
                break;
        }

    }
}
