package com.appstone.intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText etEmailAddress;
    private EditText etPassword;

    private TextView mTvEmailAddress;
    private TextView mTvPassword;

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etEmailAddress = findViewById(R.id.et_email_address);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        mTvEmailAddress = findViewById(R.id.tv_email_address);
        mTvPassword = findViewById(R.id.tv_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress = etEmailAddress.getText().toString();
                String password = etPassword.getText().toString();


                if(!emailAddress.isEmpty()){
                    Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                    homeIntent.putExtra("EMAIL",emailAddress);
//                    startActivity(homeIntent);
                    startActivityForResult(homeIntent, 1);
                }else{

                    Toast.makeText(MainActivity.this, "Email Address is empty",
                            Toast.LENGTH_LONG).show();
                }
//                mTvEmailAddress.setText(emailAddress);
//                mTvPassword.setText(String.valueOf(111.00));

            }
        });


//        EditText etEmailAddress;

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                Bundle returnData = data.getExtras();
                String updatedEmail = returnData.getString("UPDATEDEMAIL");
                etEmailAddress.setText(updatedEmail);
            }else{
                Toast.makeText(MainActivity.this, "User cancelled Operation",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
