package com.dream.arruda.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Arruda on 12/05/2015.
 */
public class Tela extends View{

    Paddle p;
    Brick b;
    Ball a;

    public Tela(Context context,int w,int h)
    {
        super(context);
        p = new Paddle(w,h);
        b = new Brick(w,h);
        a = new Ball(w,h);
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
        a.Mover(p.pos.top);
        canvas.drawRect(p.pos, new Paint());
        if(new Rect((int)a.pos.getX()-a.raio,(int)a.pos.getY()-a.raio,(int)a.pos.getX()+a.raio,(int)a.pos.getY()+a.raio).intersect(p.pos))
            a.ChangeDirection();
        for (int i=0; i<= b.pos.length-1;i++)
        {
            for (int j = 0; j <= b.pos[i].length - 1; j++)
            {
                if(!b.colidiu[i][j])
                {
                    canvas.drawRect(b.pos[i][j], b.p);
                    if(new Rect((int)a.pos.getX()-a.raio,(int)a.pos.getY()-a.raio,(int)a.pos.getX()+a.raio,(int)a.pos.getY()+a.raio).intersect(b.pos[i][j]))
                    {
                        b.colidiu[i][j] = true;
                        a.ChangeDirection();
                        a.vel+=0.2;
                    }
                }
            }
        }
        canvas.drawCircle((int)a.pos.getX(),(int)a.pos.getY(),a.raio,a.p);
        invalidate();
    }
}
