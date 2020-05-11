package com.example.whereruiot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

   //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button begin = (Button) findViewById(R.id.btn_login);
        final EditText name = (EditText) findViewById(R.id.et_email);
        final DatabaseHandler databaseHandler=new DatabaseHandler(this);

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Add to database and return to login screen
                String user = "Sofeem";
                User u = databaseHandler.findOne(1);
                Log.d("user", u.getName());

              if (user.equals(u.getName())){
                   Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();
                   //startActivity(new Intent(LoginActivity.this, LoginActivity.class));
                   Intent intent = new Intent(LoginActivity.this, LocationActivity.class);
                   intent.putExtra("message", user);
                   startActivity(intent);


               } else {

                   Toast.makeText(getApplicationContext(),"Please Register first",Toast.LENGTH_SHORT).show();
               }

                //Intent intent = new Intent(LoginActivity.this, LocationActivity.class);
                //intent.putExtra("message", );
                //startActivity(intent);
            }
        });

    }

    public void JumptoRegister(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }



}
