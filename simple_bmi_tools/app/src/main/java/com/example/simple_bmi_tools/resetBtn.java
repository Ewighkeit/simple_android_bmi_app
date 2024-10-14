package com.example.simple_bmi_tools;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class resetBtn {
    private Button resBtn;
    private EditText heiValue;
    private EditText weiValue;
    private TextView bmiValu;
    private TextView suggestBmi;
    private TextView suggestWei;
    private  TextView bmiJudge;
    private EditText wasitLine;
    private Spinner gender;
    private  TextView wasres;
    private  TextView suggwasi;

    public resetBtn(Button resBtn,EditText heiValue,EditText weiValue, TextView bmiValu, TextView suggestBmi, TextView suggestWei, TextView bmiJudge,EditText wasitLine, Spinner gender,TextView wasres, TextView suggwasi){
        this.resBtn = resBtn;
        this.heiValue = heiValue;
        this.weiValue = weiValue;
        this.bmiValu =bmiValu;
        this.suggestBmi = suggestBmi;
        this.suggestWei = suggestWei;
        this.bmiJudge = bmiJudge;
        this.wasitLine = wasitLine;
        this.gender = gender;
        this.wasres = wasres;
        this.suggwasi = suggwasi;
    }

    public void restBtnAll(){
        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heiValue.setText(null);
                weiValue.setText(null);
                bmiValu.setText(null);
                suggestBmi.setText(null);
                suggestWei.setText(null);
                bmiJudge.setText(null);
                wasitLine.setText(null);
                wasres.setText(null);
                suggwasi.setText(null);
                gender.setSelection(0);
            }
        });
    }

}
