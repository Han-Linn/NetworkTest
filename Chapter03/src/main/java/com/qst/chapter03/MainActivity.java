package com.qst.chapter03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    EditText edt2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tribune);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String theme = edt1.getText().toString();
                String content = edt2.getText().toString();
                if (theme.equals("") || content.equals("")) {
                    Toast.makeText(getApplicationContext(), "主题或者内容不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
