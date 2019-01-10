package com.taratech.customviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ValueSelector extends LinearLayout implements View.OnClickListener{

    View rootView;
    TextView valueText;
    View buttonPlus, buttonMinus;
    int minValue=0;
    int maxValue=999;

    public ValueSelector(Context context) {
        super(context);
        init(context);
    }

    public ValueSelector(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    private void init(Context context) {
        rootView=inflate(context,R.layout.value_selector,this);
        valueText=rootView.findViewById(R.id.value_text);
        buttonMinus=rootView.findViewById(R.id.btn_minus);
        buttonPlus=rootView.findViewById(R.id.btn_plus);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);

    }

    public int getValue(){
        return Integer.valueOf(valueText.getText().toString());
    }

    public void setValue(int newValue){
        if(newValue<=maxValue && newValue>=minValue)
            valueText.setText(String.valueOf(newValue));
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==buttonMinus.getId()){
            decrementValue();
        }
        else if (view.getId()==buttonPlus.getId()){
            incrementValue();
        }

    }

    private void decrementValue() {
        setValue(getValue()-1);
    }

    private void incrementValue() {
        setValue(getValue()+1);
    }
}
