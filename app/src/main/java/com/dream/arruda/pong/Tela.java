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
    Brick b;

    public Tela(Context context,int w,int h)
    {
        super(context);
        p = new Paddle(w,h);
        b = new Brick(w,h);
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
        canvas.drawRect(p.pos, new Paint());
        for (int i=0; i<= b.pos.length-1;i++)
        {
            for (int j = 0; j <= b.pos[i].length - 1; j++)
            {
                canvas.drawRect(b.pos[i][j], b.p);
            }
        }
        invalidate();
    }
}
