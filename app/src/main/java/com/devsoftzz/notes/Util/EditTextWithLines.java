package com.devsoftzz.notes.Util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;

public class EditTextWithLines extends AppCompatEditText {

    Rect mRect;
    Paint mPaint;

    public EditTextWithLines(Context context, AttributeSet attrs) {
        super(context, attrs);

        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1);
        mPaint.setColor(Color.rgb(0,0,0));
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int height = ((View)this.getParent()).getHeight();
        int lineheight = getLineHeight();
        int lines = getLineCount();
        int numberOfLines = height / lineheight;

        Rect r = mRect;
        Paint p = mPaint;

        if(numberOfLines<lines){
            numberOfLines=lines;
        }

        int baseline = getLineBounds(0,r);

        for(int i=0;i<numberOfLines;i++){
            canvas.drawLine(r.left,baseline+1,r.right,baseline+1,p);
            baseline+=lineheight;
        }

        super.onDraw(canvas);
    }
}
