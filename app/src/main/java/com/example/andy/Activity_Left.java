package com.example.andy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.networktest.R;

public class Activity_Left extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button10, button11;
    private ImageView imageView1, imageView2, imageView3, imageView4,
            imageView5, imageView6;
    private StringBuilder password;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__left);
        init();
        setOnclick();
        setImage();
    }

    private void set() {
        if (password.toString().length() != 0) {

        }
    }

    private void init() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        textView = findViewById(R.id.textView);
        password = new StringBuilder();
    }

    private void setImage() {
        switch (password.toString().length()) {
            case 0:
                imageView1.setImageResource(R.drawable.grey);
                imageView2.setImageResource(R.drawable.grey);
                imageView3.setImageResource(R.drawable.grey);
                imageView4.setImageResource(R.drawable.grey);
                imageView5.setImageResource(R.drawable.grey);
                imageView6.setImageResource(R.drawable.grey);
                break;
            case 1:
                imageView1.setImageResource(R.drawable.black);
                imageView2.setImageResource(R.drawable.grey);
                imageView3.setImageResource(R.drawable.grey);
                imageView4.setImageResource(R.drawable.grey);
                imageView5.setImageResource(R.drawable.grey);
                imageView6.setImageResource(R.drawable.grey);
                break;
            case 2:
                imageView1.setImageResource(R.drawable.black);
                imageView2.setImageResource(R.drawable.black);
                imageView3.setImageResource(R.drawable.grey);
                imageView4.setImageResource(R.drawable.grey);
                imageView5.setImageResource(R.drawable.grey);
                imageView6.setImageResource(R.drawable.grey);
                break;
            case 3:
                imageView1.setImageResource(R.drawable.black);
                imageView2.setImageResource(R.drawable.black);
                imageView3.setImageResource(R.drawable.black);
                imageView4.setImageResource(R.drawable.grey);
                imageView5.setImageResource(R.drawable.grey);
                imageView6.setImageResource(R.drawable.grey);
                break;
            case 4:
                imageView1.setImageResource(R.drawable.black);
                imageView2.setImageResource(R.drawable.black);
                imageView3.setImageResource(R.drawable.black);
                imageView4.setImageResource(R.drawable.black);
                imageView5.setImageResource(R.drawable.grey);
                imageView6.setImageResource(R.drawable.grey);
                break;
            case 5:
                imageView1.setImageResource(R.drawable.black);
                imageView2.setImageResource(R.drawable.black);
                imageView3.setImageResource(R.drawable.black);
                imageView4.setImageResource(R.drawable.black);
                imageView5.setImageResource(R.drawable.black);
                imageView6.setImageResource(R.drawable.grey);
                break;
            case 6:
                imageView1.setImageResource(R.drawable.black);
                imageView2.setImageResource(R.drawable.black);
                imageView3.setImageResource(R.drawable.black);
                imageView4.setImageResource(R.drawable.black);
                imageView5.setImageResource(R.drawable.black);
                imageView6.setImageResource(R.drawable.black);
                break;
            default:
                break;
        }
    }

    private void setOnclick() {
        button1.setOnClickListener(Activity_Left.this);
        button2.setOnClickListener(Activity_Left.this);
        button3.setOnClickListener(Activity_Left.this);
        button4.setOnClickListener(Activity_Left.this);
        button5.setOnClickListener(Activity_Left.this);
        button6.setOnClickListener(Activity_Left.this);
        button7.setOnClickListener(Activity_Left.this);
        button8.setOnClickListener(Activity_Left.this);
        button9.setOnClickListener(Activity_Left.this);
        button10.setOnClickListener(Activity_Left.this);
        button11.setOnClickListener(Activity_Left.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                if (password.toString().length() > -1 && password.toString().length() < 6) {
                    password.append("1");
                    setImage();
                }
                break;
            case R.id.button2:
                if (password.toString().length() > -1 && password.toString().length() < 6) {
                    password.append("2");
                    setImage();
                }
                break;
            case R.id.button3:
                if (password.toString().length() > -1 && password.toString().length() < 6) {
                    password.append("3");
                    setImage();
                }
                break;
            case R.id.button4:
                if (password.toString().length() > -1 && password.toString().length() < 6) {
                    password.append("4");
                    setImage();
                }
                break;
            case R.id.button5:
                if (password.toString().length() > -1 && password.toString().length() < 6) {
                    password.append("5");
                    setImage();
                }
                break;
            case R.id.button6:
                if (password.toString().length() > -1 && password.toString().length() < 6) {
                    password.append("6");
                    setImage();
                }
                break;
            case R.id.button7:
                if (password.toString().length() > -1 && password.toString().length() < 6) {
                    password.append("7");
                    setImage();
                }
                break;
            case R.id.button8:
                if (password.toString().length() > -1 && password.toString().length() < 6) {
                    password.append("8");
                    setImage();
                }
                break;
            case R.id.button9:
                if (password.toString().length() > -1 && password.toString().length() < 6) {
                    password.append("9");
                    setImage();
                }
                break;
            case R.id.button10:
                if (password.toString().length() > 0) {
                    password.deleteCharAt(password.length() - 1);
                    setImage();
                }
                break;
            case R.id.button11:
//                if (password.toString().length() == 6) {
//                    textView.setText(password.toString());
//                    setImage();
//                }
                textView.setText(password.toString());
                break;
            default:
                break;
        }
    }
}
