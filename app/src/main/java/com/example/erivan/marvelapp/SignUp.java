package com.example.erivan.marvelapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    Button mButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mButton = (Button) findViewById(R.id.btnSignUp);

        mButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (v.getId() == R.id.btnSignUp){

                    EditText name = (EditText) findViewById(R.id.name);
                    EditText email = (EditText) findViewById(R.id.email);
                    EditText TFpass1 = (EditText) findViewById(R.id.TFpass1);
                    EditText TFpass2 = (EditText) findViewById(R.id.TFpass2);

                    String nameStr = name.getText().toString();
                    String emailStr = email.getText().toString();
                    String TFpass1Str = TFpass1.getText().toString();
                    String TFpass2Str = TFpass2.getText().toString();

                    if (!TFpass1Str.equals(TFpass2Str)){
                        Toast pass = Toast.makeText(SignUp.this, "Password don't match", Toast.LENGTH_SHORT);
                        pass.show();
                    }else{

                        Contact c = new Contact();
                        c.setName(nameStr);
                        c.setEmail(emailStr);
                        c.setPassword(TFpass1Str);
                        helper.insertContact(c);

                        Intent launchMaiActivity = new Intent(SignUp.this, MainActivity.class);
                        startActivity(launchMaiActivity);
                    }
                }
            }
        });
    }
}

