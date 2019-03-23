package com.agarcia.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.agarcia.labo3.utilities.AppConstants;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mUsername, mPassword, mEmail;
    private RadioButton mMale, mFemale;
    private String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BindComponents();

        mButton.setOnClickListener(v->{
            setInfo();
            Intent mIntent = new Intent(MainActivity.this, ShareActivity.class);
            mIntent.putExtra(AppConstants.TEXT_KEY, this.info);
            startActivity(mIntent);
        });
    }

    private void BindComponents()
    {
        this.mButton = findViewById(R.id.send);

        this.mUsername = findViewById(R.id.username);
        this.mPassword = findViewById(R.id.password);
        this.mEmail = findViewById(R.id.email);

        this.mMale = findViewById(R.id.radio_male);
        this.mFemale = findViewById(R.id.radio_female);
    }

    private void setInfo()
    {
        this.info = "";

        this.info += this.mUsername.getText() + ",";
        this.info += this.mPassword.getText() + ",";
        this.info += this.mEmail.getText() + ",";

        if (this.mMale.isChecked()==true)
        {
            this.info += this.mMale.getText().toString();
        }
        else if (this.mFemale.isChecked()==true)
        {
            this.info += this.mFemale.getText().toString();
        }
    }
}
