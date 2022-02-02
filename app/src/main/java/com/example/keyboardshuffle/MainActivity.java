package com.example.keyboardshuffle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

 TextView textView;
 Button button;

 EditText editText;
    MyKeyboard keyboard;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       textView = findViewById(R.id.outputtextview);
        editText =findViewById(R.id.editext);
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editText.setTextIsSelectable(true);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closekeyboard();
            }
        });


         keyboard = (MyKeyboard) findViewById(R.id.keyboard);




        InputConnection ic = editText.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);


        button= findViewById(R.id.btn_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());

            }
        });







    }

    private void closekeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

//
//    public void testbutton(View view) {
//        ((Button) view).getText();
//    }
}