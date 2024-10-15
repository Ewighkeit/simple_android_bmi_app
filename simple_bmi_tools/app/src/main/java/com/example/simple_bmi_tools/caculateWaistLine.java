package com.example.simple_bmi_tools;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class caculateWaistLine {

    private EditText wasitLine;
    private Spinner gender;
    private  TextView wasres;
    private  TextView suggwasi;

    public caculateWaistLine(EditText wasitLine, Spinner gender, TextView wasres,TextView suggwasi) {
        this.wasitLine = wasitLine;
        this.gender = gender;
        this.wasres = wasres;
        this.suggwasi = suggwasi;
    }

    public void caculateWasitLine() {

        TextWatcher waistWatcher = null;
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (waistWatcher!=null){
                    wasitLine.removeTextChangedListener(waistWatcher);
                }
                if (gender.getSelectedItem().toString().equals("男性")){
                    wasitLine.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            if (editable.length()<4 && !editable.toString().isEmpty()){
                                try {
                                    if (Integer.parseInt(editable.toString())>90){
                                        wasres.setText("腰圍超標");
                                        wasres.setTextColor(-0x10000);
                                        suggwasi.setText("小於90公分");
                                    }else {
                                        wasres.setText("腰圍正常");
                                        wasres.setTextColor(-0xbbbbbc);
                                        suggwasi.setText("-");
                                    }
                                } catch (NumberFormatException e){
                                    wasres.setText(null);
                                }
                            }
                        }
                    });
                }else {
                    wasitLine.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            if (editable.length()<4 && !editable.toString().isEmpty()){
                                try {
                                    if (Integer.parseInt(editable.toString())>80){
                                        wasres.setText("腰圍超標");
                                        wasres.setTextColor(-0x10000);
                                        suggwasi.setText("小於80公分");
                                    }else {
                                        wasres.setText("腰圍正常");
                                        wasres.setTextColor(-0xbbbbbc);
                                        suggwasi.setText("-");
                                    }
                                } catch (NumberFormatException e){
                                    wasres.setText(null);
                                }
                            }
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
