package com.mask.loginnew;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class User extends Activity {
    EditText etTo, etSubject, etMessage;
    Button btSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        etTo = findViewById(R.id.et_to);
        etSubject = findViewById(R.id.et_subject);
        etMessage = findViewById(R.id.et_message);
        btSend = findViewById(R.id.bt_send);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = AnimationUtils.loadAnimation(User.this, R.anim.bounce);
                btSend.startAnimation(animation);
                Intent intent = new Intent(Intent.ACTION_VIEW
                        , Uri.parse("mailto:" + etTo.getText().toString()));
                //Intent intent1 = new Intent(Intent.ACTION_VIEW
                //      , Uri.parse("subject:" + etSubject.getText().toString()));
                //startActivity(intent1);
                //Intent intent2 = new Intent(Intent.ACTION_VIEW
                //     , Uri.parse("message:" + etMessage.getText().toString()));
                //startActivity(intent2);
                intent.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, etMessage.getText().toString());
                startActivity(intent);


            }
        });
    }
}

