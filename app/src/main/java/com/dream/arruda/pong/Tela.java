package com.dream.arruda.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Arruda on 12/05/2015.
 */
public class Tela extends View{

    Paddle p;

    public Tela(Context context,int w,int h)
    {
        super(context);
        p = new Paddle(w,h);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_MOVE:
                p.Mover(event.getX());
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawRect(p.pos,new Paint());
        invalidate();
    }
}
