package com.siam.runrana.tusaphom.mysiam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Myindex extends AppCompatActivity {

    //Explicit
    private EditText userEditText , passwordEditText;
    private TextView textView;
    private Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myindex);

        //Initial View
        initailView();
        //textView controller
        textViewController();
    }// this method

    private void textViewController() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Inigent to  newregister
                Intent intent = new Intent(Myindex.this,newregister.class);
                startActivity(intent);

            }
        });
    }

    private void initailView() {

        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtNewregister);
        button = (Button) findViewById(R.id.btnLogin);

    }
}// this main class
