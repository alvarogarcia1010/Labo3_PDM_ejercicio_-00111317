package com.agarcia.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.agarcia.labo3.utilities.AppConstants;

public class ShareActivity extends AppCompatActivity {

    private Button mBtnShare;
    private EditText mUsername, mPassword, mEmail, mGender;

    private String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        BindComponents();

        Intent mIntent = getIntent();
        if (mIntent!=null) {
            this.info = mIntent.getStringExtra(AppConstants.TEXT_KEY);
            String [] information = this.info.split(",");

            this.mUsername.setText(information[0]);
            this.mPassword.setText(information[1]);
            this.mEmail.setText(information[2]);
            this.mGender.setText(information[3]);
        }

        mBtnShare.setOnClickListener(v->{
            setInfo();
            Intent mIntentShare = new Intent();
            mIntentShare.setAction(Intent.ACTION_SEND);
            mIntentShare.setType("text/plain");
            mIntentShare.putExtra(Intent.EXTRA_TEXT, this.info);
            startActivity(mIntentShare);
        });
    }

    private void BindComponents()
    {
        this.mBtnShare = findViewById(R.id.share);

        this.mUsername = findViewById(R.id.username);
        this.mPassword = findViewById(R.id.password);
        this.mEmail = findViewById(R.id.email);
        this.mGender = findViewById(R.id.gender);
    }

    private void setInfo()
    {
        this.info = "";

        this.info += "Usuario: " + this.mUsername.getText() + ", ";
        this.info += "Contraseña: " + this.mPassword.getText() + ", ";
        this.info += "Correo electronico: "+ this.mEmail.getText() + ", ";
        this.info += "Genero: "+ this.mGender.getText();
    }
}
