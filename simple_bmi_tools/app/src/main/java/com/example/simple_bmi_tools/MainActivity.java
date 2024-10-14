package com.example.simple_bmi_tools;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText wasitLine = findViewById(R.id.waistline);
        EditText bodyHei = findViewById(R.id.body_hei);
        EditText bodyWei = findViewById(R.id.body_wei);
        Spinner gender = findViewById(R.id.spinner);
        TextView wasres = findViewById(R.id.judge_waistline);
        TextView bmiValu = findViewById(R.id.bmi_res);
        TextView suggestBmi =findViewById(R.id.bni_suggeres);
        TextView suggestWei =findViewById(R.id.sugge_wei);
        TextView judgeBmi = findViewById(R.id.bmi_judg);
        TextView suggestWasit = findViewById(R.id.sugge_waistline);
        Button ressBtn = findViewById(R.id.resetbtn);

        caculateWaistLine waiCaculator = new caculateWaistLine(wasitLine,gender,wasres,suggestWasit);
        waiCaculator.caculateWasitLine();

        caculatorBmi bmiCacu = new caculatorBmi(bodyHei,bodyWei,bmiValu,suggestBmi,suggestWei,judgeBmi);
        bmiCacu.caculaBmi();

        resetBtn resSult = new resetBtn(ressBtn,bodyHei,bodyWei,bmiValu,suggestBmi,suggestWei,judgeBmi,wasitLine,gender,wasres,suggestWasit);
        resSult.restBtnAll();

    }




}



