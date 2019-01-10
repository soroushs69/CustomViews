
//////////////NOT COMPLETE///////////////////

package com.taratech.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ValueBar extends View {

    private int maxValue=100;
    private int value=50;
    private int fillColor;

    public ValueBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta=context.getTheme()
                .obtainStyledAttributes(attrs,R.styleable.valueBar,0,0);

        fillColor=ta.getColor(R.styleable.valueBar_fillColor,Color.RED);

        ta.recycle();
    }

    public int getMaxValueValue(){
        return this.maxValue;
    }
    public int getValue(){
        return this.value;
    }

    public void setMaxValue(int newMaxValue){
        if(maxValue>0)
            this.maxValue=newMaxValue;
        else
            this.maxValue=100;
        invalidate();
        requestLayout();
    }

    public void setValue(int newValue){
        if(newValue<0)
            this.value=0;
        else if(newValue>maxValue)
            this.value=maxValue;
        else
            this.value=newValue;
        invalidate();
    }
}
