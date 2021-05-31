package dev.nhaiden.labor08_lottapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random rd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView_output);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    public void showTips(View view) {
        TextView textView = (TextView) findViewById(R.id.textView_output);
        textView.setMovementMethod(new ScrollingMovementMethod());
        int tipCount = getTipCount();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < tipCount; i++) {
            builder.append("Tip " + (i + 1) + "\n");
            List<String> tips = generateTips();
            for (String tip : tips) {
                builder.append(tip + " ");
            }
            builder.append("\n\n");
        }
        textView.setText(builder.toString());
    }


    private List<String> generateTips() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
        List<String> generatedTips = new ArrayList<>();
        switch (group.getCheckedRadioButtonId()) {
            case R.id.rb_45: {
                for (int i = 0; i < 6; i++) {
                    int generatedNum = rd.nextInt(45 - 1 + 1);
                    generatedTips.add(Integer.toString(generatedNum));
                }
            }
            break;

            case R.id.rb_49: {
                for (int i = 0; i < 6; i++) {
                    int generatedNum = rd.nextInt(49 - 1 + 1);
                    generatedTips.add(Integer.toString(generatedNum));
                }
            }
            break;
        }
        return generatedTips;
    }

    private int getTipCount() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        return Integer.parseInt(spinner.getSelectedItem().toString());
    }
}