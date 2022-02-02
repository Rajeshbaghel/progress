package com.example.keyboardshuffle;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyKeyboard extends LinearLayout implements View.OnClickListener {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, buttondelete, button0, buttonEnter;


    SparseArray<String> keyValues = new SparseArray<>();


    InputConnection inputConnection;

    public MyKeyboard(Context context) {
        this(context, null, 0);
    }

    public MyKeyboard(Context context, @Nullable AttributeSet attrs) {

        this(context, attrs, 0);
    }

    public MyKeyboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.custom_layoutkeyboard, this, true);
        button1 = findViewById(R.id.btn_textView1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.btn_textView2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.btn_textView3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.btn_textView4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.btn_textView5);
        button5.setOnClickListener(this);
        button6 = findViewById(R.id.btn_textView6);
        button6.setOnClickListener(this);
        button7 = findViewById(R.id.btn_textView7);
        button7.setOnClickListener(this);
        button8 = findViewById(R.id.btn_textView8);
        button8.setOnClickListener(this);
        button9 = findViewById(R.id.btn_textView9);
        button9.setOnClickListener(this);
        button0 = findViewById(R.id.btn_textView0);
        button0.setOnClickListener(this);
        buttondelete = findViewById(R.id.btn_textViewdelete);
        buttondelete.setOnClickListener(this);
        buttonEnter = findViewById(R.id.btn_textViewEnter);
        buttonEnter.setOnClickListener(this);

        keyValues.put(R.id.btn_textViewEnter, "\n");


        List<Integer> objects = new ArrayList<Integer>();
        objects.add(0);
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);
        objects.add(6);
        objects.add(7);
        objects.add(8);
        objects.add(9);

//        keyValues.put(R.id.btn_textView2, "2");
//        keyValues.put(R.id.btn_textView3, "3");
//        keyValues.put(R.id.btn_textView4, "4");
//        keyValues.put(R.id.btn_textView5, "5");
//        keyValues.put(R.id.btn_textView6, "6");
//        keyValues.put(R.id.btn_textView7, "7");
//        keyValues.put(R.id.btn_textView8, "8");
//        keyValues.put(R.id.btn_textView9, "9");
//        keyValues.put(R.id.btn_textView0, "0");


        // Shuffle the collection
        Collections.shuffle(objects);

        List<Button> buttons = new ArrayList<Button>();
        buttons.add((Button) findViewById(R.id.btn_textView0));
        buttons.add((Button) findViewById(R.id.btn_textView1));
        buttons.add((Button) findViewById(R.id.btn_textView2));
        buttons.add((Button) findViewById(R.id.btn_textView3));
        buttons.add((Button) findViewById(R.id.btn_textView4));
        buttons.add((Button) findViewById(R.id.btn_textView5));
        buttons.add((Button) findViewById(R.id.btn_textView6));
        buttons.add((Button) findViewById(R.id.btn_textView7));
        buttons.add((Button) findViewById(R.id.btn_textView8));
        buttons.add((Button) findViewById(R.id.btn_textView9));


        for (int i = 0; i < objects.size(); i++) {
            buttons.get(i).setText(objects.get(i).toString());
            keyValues.put(buttons.get(i).getId(),objects.get(i).toString());


        }



    }


    @Override
    public void onClick(View view) {

        if (inputConnection == null)
            return;
        if (view.getId() == R.id.btn_textViewdelete) {

            CharSequence selectedText = inputConnection.getSelectedText(0);

            if (TextUtils.isEmpty(selectedText)) {
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                inputConnection.commitText("", 1);
            }
        } else {
            String value = keyValues.get(view.getId());

            inputConnection.commitText(value, 1);
        }

    }

    public void setInputConnection(InputConnection ic) {
        inputConnection = ic;


    }

}
