package com.appstone.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView tvEmailAddress = findViewById(R.id.tv_user_email);

        Bundle data = getIntent().getExtras();

        String email = data.getString("EMAIL");

        tvEmailAddress.setText(email);

        final EditText etUpdateEmail = findViewById(R.id.et_update_email_address);
        Button btnUpdate = findViewById(R.id.btn_update);
        Button btnCancel = findViewById(R.id.btn_cancel);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedEmail = etUpdateEmail.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("UPDATEDEMAIL", updatedEmail);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancelIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, cancelIntent);
                finish();
            }
        });
    }
}
