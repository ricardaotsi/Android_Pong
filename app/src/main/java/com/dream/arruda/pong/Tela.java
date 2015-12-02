/*
Copyright 2015 Ricardo Arruda Sowek

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
    long currentTime, lastFrameTime;
    float elapsed;

    public Tela(Context context,int w,int h)
    {
        super(context);
        p = new Paddle(w,h);
        b = new Brick(w,h);
        a = new Ball(w,h);
        currentTime = System.currentTimeMillis();
        lastFrameTime = System.currentTimeMillis();
        elapsed=0;
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
        currentTime = System.currentTimeMillis();
        a.Mover(p.pos.top, elapsed);
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
                    }
                }
            }
        }
        canvas.drawCircle((int)a.pos.getX(),(int)a.pos.getY(),a.raio,a.p);
        elapsed = (System.currentTimeMillis() - lastFrameTime) * .001f;//convert ms to seconds
        lastFrameTime = currentTime;
        invalidate();
    }
}
