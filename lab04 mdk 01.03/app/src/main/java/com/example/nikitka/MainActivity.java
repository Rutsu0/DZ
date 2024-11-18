package com.example.nikitka;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText et_v1, et_l1, et_v2, et_l2;
    private Button btn_1, btn_2, btn_3;
    private TextView tv_1, tv_2;
    tBus bus1, bus2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_v1 = findViewById(R.id.et_v1);
        et_l1 = findViewById(R.id.et_l1);
        et_v2 = findViewById(R.id.et_v2);
        et_l2 = findViewById(R.id.et_l2);
        btn_1 = findViewById(R.id.but_v1);
        btn_2 = findViewById(R.id.but_v2);
        btn_3 = findViewById(R.id.but_v3);
        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int capacity = Integer.parseInt(et_v1.getText().toString());
                int countPass = Integer.parseInt(et_l1.getText().toString());
                bus1 = new tBus(capacity, countPass);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int capacity = Integer.parseInt(et_v2.getText().toString());
                int countPass = Integer.parseInt(et_l2.getText().toString());
                bus2 = new tBus(capacity, countPass);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cap1 = String.valueOf(bus1.capacity);
                String count1 = String.valueOf(bus1.countPass);
                tv_1.setText("Вместимость: " + cap1 + " Людей: " + count1);
                String cap2 = String.valueOf(bus2.capacity);
                String count2 = String.valueOf(bus2.countPass);
                tv_2.setText("Вместимость: " + cap2 + " Людей: " + count2);
            }

        });
    }
}

class tBus {
    public int capacity, countPass;

    tBus(int capacity, int countPass) {
        this.capacity = capacity;
        this.countPass = countPass;
    }

}