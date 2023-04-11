package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void convert(View view){
        String binary="";
        int totalNotes = 0;

        ImageView arrow = findViewById(R.id.arrow);
        EditText decimalVal = findViewById(R.id.decimalinput);
        TextView output1 = findViewById(R.id.output1);
        TextView output2 = findViewById(R.id.output2);
        TextView output3 = findViewById(R.id.output3);
        TextView output4 = findViewById(R.id.output4);
        TextView output5 = findViewById(R.id.output5);



        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);

        if (decimalVal.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Please, Enter Something to Convert",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        float myNum = 0;

        try {
            myNum = Integer.parseInt(decimalVal.getText().toString());

        } catch(NumberFormatException nfe) {
            return;
        }
        decimalVal.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(true);
        arrow.animate().rotation(180).setDuration(500);

        if (Math.floor(myNum/100) != 0){
            binary = String.valueOf(Math.round(Math.floor(myNum/100)));
            output1.setText(binary);
            totalNotes+=Math.floor(myNum/100);
            myNum = myNum%100;
        }
        if (Math.floor(myNum/50) != 0){
            binary = String.valueOf(Math.round(Math.floor(myNum/50)));
            output2.setText(binary);
            totalNotes+=Math.floor(myNum/50);
            myNum = myNum%50;
        }
        if (Math.floor(myNum/10) != 0){
            binary = String.valueOf(Math.round(Math.floor(myNum/10)));
            output3.setText(binary);
            totalNotes+=Math.floor(myNum/10);
            myNum = myNum%10;
        }
        if (myNum != 0){
            binary = String.valueOf(Math.round(myNum));
            output4.setText(binary);
            totalNotes+=Math.floor(myNum);
        }
        else{
            binary ="0";
            output4.setText(binary);
        }
        binary = String.valueOf(totalNotes);
        output5.setText(binary);

    }
    public void clear(View view){
        ImageView arrow = findViewById(R.id.arrow);
        EditText decimalVal = findViewById(R.id.decimalinput);
        TextView output1 = findViewById(R.id.output1);
        TextView output2 = findViewById(R.id.output2);
        TextView output3 = findViewById(R.id.output3);
        TextView output4 = findViewById(R.id.output4);
        TextView output5 = findViewById(R.id.output5);

        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);

        arrow.animate().rotation(0).setDuration(500);
        output1.setText("0");
        output2.setText("0");
        output3.setText("0");
        output4.setText("0");
        output5.setText("0");
        decimalVal.setText("");

        decimalVal.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(false);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}