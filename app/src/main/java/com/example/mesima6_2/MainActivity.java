package com.example.mesima6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.Random;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();

    TextView[] text = new TextView[6];
    EditText[] editText = new EditText[3];
    Button[] sendBtn = new Button[3];
    ImageView[] imageView = new ImageView[3];

    int num1, num2, sum, input, col, curr = 2, succ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text[0] = findViewById(R.id.txt1);
        text[1] = findViewById(R.id.txt2);
        text[2] = findViewById(R.id.txt3);
        text[3] = findViewById(R.id.txt4);
        text[4] = findViewById(R.id.txt5);
        text[5] = findViewById(R.id.txt6);

        editText[0] = findViewById(R.id.et1);
        editText[1] = findViewById(R.id.et2);
        editText[2] = findViewById(R.id.et3);

        sendBtn[0] = findViewById(R.id.sendBtn1);
        sendBtn[1] = findViewById(R.id.sendBtn2);
        sendBtn[2] = findViewById(R.id.sendBtn3);

        imageView[0] = findViewById(R.id.iv1);
        imageView[1] = findViewById(R.id.iv2);
        imageView[2] = findViewById(R.id.iv3);


        num1 = rand.nextInt(90) + 10;
        num2 = rand.nextInt(90) + 10;
        sum = num1 + num2;
        text[0].setText("" + num1);
        text[1].setText("" + num2);
    }

    public void checker(View view) {
        if (col < 3) {
            input = Integer.parseInt(editText[col].getText().toString());
            if (sum == input) {
                imageView[col].setImageResource(R.drawable.cheakmark);
                succ++;
            } else
                imageView[col].setImageResource(R.drawable.notcheakmark);

            if (col < 2) {
                num1 = sum;
                num2 = rand.nextInt(90) + 10;
                sum = num1 + num2;
                text[curr].setText("" + num1);
                curr++;
                text[curr].setText("" + num2);
                curr++;
            }
            else {
                Toast.makeText(this, ((int)(succ / 3.0 * 100)) + "% ," + succ + "/3", Toast.LENGTH_LONG).show();
            }

            col++;
        }
    }
    public void restart(View view) {
        for(int i = 0; i < text.length; i++) {
            text[i].setText("");
        }
        for(int i = 0; i < imageView.length; i++) {
            imageView[i].setImageResource(0);
            editText[i].setText("");
        }

        col = 0;
        succ = 0;
        num1 = rand.nextInt(90) + 10;
        num2 = rand.nextInt(90) + 10;
        sum = num1 + num2;
        text[0].setText("" + num1);
        text[1].setText("" + num2);
        curr = 2;
    }
}