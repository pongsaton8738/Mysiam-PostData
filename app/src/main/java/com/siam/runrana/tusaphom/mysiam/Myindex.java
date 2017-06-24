package com.siam.runrana.tusaphom.mysiam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class Myindex extends AppCompatActivity {

    //Explicit
    private EditText userEditText , passwordEditText;
    private TextView textView;
    private Button button;
    private String userString,passworsString;
    private Myalert MyAlert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myindex);

        //Initial View
        initailView();

        //textView controller
        textViewController();

        //Button Controller
        buttonController();


    }// this method

    private void buttonController() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get Velue from Edit Text
                userString=userEditText.getText().toString().trim();
                passworsString = passwordEditText.getText().toString();

                //Check Space
                if (userString.length() == 0 || passworsString.length() == 0) {
                    //Have space
                    MyAlert.myDialog(getResources().getString(R.string.titleNameSpace),
                            getResources().getString(R.string.MessageNullSpace));
                } else {
                    //No space
                    checkUserAndPass();
                }


            }

        });
    }

    private void checkUserAndPass() {

        try {

            String urlPHP = "http://androidthai.in.th/siam/getAllDataBoat.php";
            GetAllData getAllData = new GetAllData(Myindex.this);
            getAllData.execute(urlPHP);
            String strJSON = getAllData.get();
            Log.d("SiamV1", "JSON ==>" + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            boolean b = true;

            String[]strings = new String[]{"id","Name",
                    "User","Password"};
            String[] loginStrings1 = new String[strings.length];

            for (int i=0; i<jsonArray.length(); i+=1){

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                if (userString.equals(jsonObject.getString("User"))) {



                    b =false;

                    for (int i1=0; i1<strings.length; i1++){
                        loginStrings1[i1] = jsonObject.getString(strings[i1]);
                        Log.d("SiamV1", "LoginString1[" + i1 + "] ==> " + loginStrings1[i1]);
                    }
                }

            } // for

            if (b) {
                MyAlert.myDialog(getResources().getString(R.string.titleUserFalse),
                        getResources().getString(R.string.MessageUserFalse));
            }


        } catch (Exception e) {
            e.printStackTrace();
        };

    }

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

        MyAlert= new Myalert(Myindex.this);

        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtNewregister);
        button = (Button) findViewById(R.id.btnLogin);

    }
}// this main class
