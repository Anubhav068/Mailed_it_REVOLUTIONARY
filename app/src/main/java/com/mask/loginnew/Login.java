package com.mask.loginnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

    EditText et_username, et_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login();
    }

    void Login(){
        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);
        btn_login = (Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_username.getText().toString().equals("user") && et_password.getText().toString().equals("password")){
                    Toast.makeText(Login.this, "Username and Password is correct", Toast.LENGTH_SHORT).show();
                    Animation animation = AnimationUtils.loadAnimation(Login.this, R.anim.bounce);
                    btn_login.startAnimation(animation);
                    Intent intent = new Intent(Login.this,User.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
