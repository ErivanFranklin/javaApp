package com.example.erivan.marvelapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erivan.marvelapp.DataBase.DatabaseHelper;
import com.example.erivan.marvelapp.R;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    TextView signup = null;
    Button mButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButton = (Button) findViewById(R.id.btnLogin);

        signup = (TextView) findViewById(R.id.signup);

        Intent launchUserDisplay = new Intent(MainActivity.this, Characters.class);
        startActivity(launchUserDisplay);

        mButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if(v.getId() == R.id.btnLogin){
                    EditText email = (EditText) findViewById(R.id.email);
                    String emailStr = email.getText().toString();

                    EditText password = (EditText) findViewById(R.id.password);
                    String passwordStr = password.getText().toString();

                    String user_password  = helper.searchUser(emailStr);

                    if(passwordStr.equals(user_password)){
                        Intent launchUserDisplay = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(launchUserDisplay);

                    }else{
                        Toast t = Toast.makeText(MainActivity.this, "Incorrect user", Toast.LENGTH_SHORT);
                        t.show();

                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchSignUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(launchSignUp);
            }
        });

    }


}
