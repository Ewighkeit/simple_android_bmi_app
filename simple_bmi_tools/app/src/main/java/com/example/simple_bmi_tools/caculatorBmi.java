package com.example.simple_bmi_tools;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.math.BigDecimal;

public class caculatorBmi {

    private EditText heiValue;
    private EditText weiValue;
    private TextView bmiValu;
    private TextView suggestBmi;
    private TextView suggestWei;
    private  TextView bmiJudge;

    public caculatorBmi(EditText heiValue,EditText weiValue,TextView bmiValu,TextView suggestBmi,TextView suggestWei,TextView bmiJudge){
        this.heiValue = heiValue;
        this.weiValue = weiValue;
        this.bmiValu = bmiValu;
        this.suggestBmi = suggestBmi;
        this.suggestWei = suggestWei;
        this.bmiJudge = bmiJudge;
    }

    public void caculaBmi(){
        final Double[] heiDou = {null};
        final Integer[] weiInt = {null};
        heiValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()){
                    try {
                        if (Double.parseDouble(editable.toString())<3 && Double.parseDouble(editable.toString())>0){
                            heiDou[0] = Double.parseDouble(editable.toString());
                            caculatoreddBmi(weiInt[0],heiDou[0]);
                        }else {
                            heiDou[0] = null;
                            bmiValu.setText("請正確輸入身高(公尺)");
                            bmiJudge.setText(null);
                        }
                    } catch (NumberFormatException e){
                        heiDou[0] = null;
                        bmiValu.setText(null);
                        bmiJudge.setText(null);
                    }
                }else {
                    heiDou[0] = null;
                    bmiValu.setText(null);
                    bmiJudge.setText(null);
                }
            }
        });
        weiValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()){
                    try {
                        if (Integer.parseInt(editable.toString())<800 && Integer.parseInt(editable.toString())>0 && Integer.parseInt(editable.toString())!=0){
                            weiInt[0] = Integer.parseInt(editable.toString());
                            caculatoreddBmi(weiInt[0],heiDou[0]);
                        }else {
                            weiInt[0] = null;
                            bmiValu.setText(null);
                            bmiJudge.setText(null);
                        }
                    }catch (NumberFormatException e){
                        weiInt[0] = null;
                        bmiValu.setText(null);
                        bmiJudge.setText(null);
                    }
                }else {
                    weiInt[0] = null;
                    bmiValu.setText(null);
                    bmiJudge.setText(null);
                }
            }
        });
    }


    private void caculatoreddBmi(Integer weii,Double heii){
        if (weii!=null && heii!=null && heii <3 && heii>0){
            BigDecimal bmiVal = BigDecimal.valueOf(weii/(heii*heii));
            bmiValu.setText(bmiVal.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
            if (bmiVal.doubleValue()>=27){
                bmiJudge.setText("肥胖");
                suggestBmi.setText("18.5至24");
                BigDecimal standardwei1 = BigDecimal.valueOf(18.5*heii*heii);
                BigDecimal standardwei2 = BigDecimal.valueOf(24*heii*heii);
                suggestWei.setText(standardwei1.setScale(1,BigDecimal.ROUND_HALF_UP).toString()+"公斤至"+standardwei2.setScale(1,BigDecimal.ROUND_HALF_UP).toString()+"公斤");
            }else {
                if (bmiVal.doubleValue()>=24){
                    bmiJudge.setText("過重");
                    suggestBmi.setText("18.5至24");
                    BigDecimal standardwei1 = BigDecimal.valueOf(18.5*heii*heii);
                    BigDecimal standardwei2 = BigDecimal.valueOf(24*heii*heii);
                    suggestWei.setText(standardwei1.setScale(1,BigDecimal.ROUND_HALF_UP).toString()+"公斤至"+standardwei2.setScale(1,BigDecimal.ROUND_HALF_UP).toString()+"公斤");
                }else {
                    if (bmiVal.doubleValue()>=18.5){
                        bmiJudge.setText("健康體重");
                        suggestBmi.setText("-");
                        suggestWei.setText("-");
                    }else {
                        bmiJudge.setText("過輕");
                        BigDecimal standardwei1 = BigDecimal.valueOf(18.5*heii*heii);
                        BigDecimal standardwei2 = BigDecimal.valueOf(24*heii*heii);
                        suggestWei.setText(standardwei1.setScale(1,BigDecimal.ROUND_HALF_UP).toString()+"公斤至"+standardwei2.setScale(1,BigDecimal.ROUND_HALF_UP).toString()+"公斤");
                        suggestBmi.setText("18.5至24");
                    }
                }
            }
        }else {
            bmiValu.setText("");
        }
    }

}
