package com.example.whereruiot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btn = (Button) findViewById(R.id.btn_register);
        final DatabaseHandler databaseHandler=new DatabaseHandler(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.et_name);
                EditText person1 = findViewById(R.id.et_email);
                EditText person2 = findViewById(R.id.et_password);
                //Add to database and return to login screen
                databaseHandler.save(new User(1,"Sofeem","aditiya", "Sereni"));

                /*Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                RegisterActivity.this.finish();*/
                JumptoRegister();
            }
        });


    }


    public void JumptoRegister() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
