package com.siam.runrana.tusaphom.mysiam;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class newregister extends AppCompatActivity {


    //Explicit
    private ImageView imageView;
    private EditText nameEditText, userEditText, passwordEditText;
    private Button button;
    private String nameEdiString, userEditString, passwordEditSing;


private void uploadValueToServer(){
    try {

        PostDataToServer postDataToServer = new PostDataToServer(newregister.this);
        postDataToServer.execute(nameEdiString,userEditString,passwordEditSing,"http://androidthai.in.th/siam/addDataMaster.php");

        if (Boolean.parseBoolean(postDataToServer.get())){
            finish();
        }else {
            Myalert myalert = new Myalert(newregister.this);
            myalert.myDialog("Cannot Upload", "Please Try Again");
        }

    }catch (Exception e){
        Log.d("SiamV1","0 upload ==>" + e.toString());
    }
}




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newregister);

        //Initial View
        initialView();
        //back controller
        backController();

        //newRegister
        newRegister();

    }//method

    private void newRegister() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get value
                nameEdiString = nameEditText.getText().toString().trim();
                userEditString = userEditText.getText().toString().trim();
                passwordEditSing = passwordEditText.getText().toString().trim();



                //check space ka wang
                if (nameEdiString.equals("") || userEditString.equals("") || passwordEditSing.equals("")) {

                    Myalert myalert = new Myalert(newregister.this);
                    myalert.myDialog("Have space","Please fill all Blank");
                }

                else {

                }

            }
        });
    }


    private void backController() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //event
                finish();
            }
        });
    }


    private void initialView() {
        imageView = (ImageView) findViewById(R.id.btnBack);
        nameEditText = (EditText) findViewById(R.id.edname);
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        button = (Button) findViewById(R.id.btnnewregister);
    }
}//main class
