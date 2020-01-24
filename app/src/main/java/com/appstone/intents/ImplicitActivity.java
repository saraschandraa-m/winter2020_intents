package com.appstone.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitActivity extends AppCompatActivity {

    private EditText mEtPhone;
    private Button mBtnDial,mBtnUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        mEtPhone = findViewById(R.id.et_phone);
        mBtnDial = findViewById(R.id.btn_dial);
        mBtnUrl = findViewById(R.id.btn_url);

        mBtnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = mEtPhone.getText().toString().trim();

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:".concat(number)));
                startActivity(callIntent);
            }
        });


        mBtnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.google.com";

                Intent urlIntent = new Intent(Intent.ACTION_VIEW);
                urlIntent.setData(Uri.parse(url));
                startActivity(urlIntent);
            }
        });

        findViewById(R.id.btn_mail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                sendMail();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Android");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"manabendu@mb.com","saras@gmail.com"});
                intent.putExtra(Intent.EXTRA_TEXT,"Hello from class");
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Open mail"));
            }
        });
    }

}
