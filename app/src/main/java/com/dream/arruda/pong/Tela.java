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
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Arruda on 12/05/2015.
 */
public class Tela extends View implements Runnable{

    private Paddle p;
    private Brick b;
    private Ball a;
    //paddle position on touch event
    private float posP;
    private int width;
    private int height;
    private Thread game;
    private boolean isrunning;
    private Paint paint;
    //Following variables are for dynamic velocity between devices
    private long currentTime, lastFrameTime;
    private float elapsed;

    public Tela(Context context,int w,int h)
    {
        //Initialize variables
        super(context);
        p = new Paddle(w,h);
        b = new Brick(w,h);
        a = new Ball(w,h);
        posP = w/2;
        width = w;
        height = h;
        game = new Thread(this);
        isrunning = true;
        paint = new Paint();
        currentTime = System.currentTimeMillis();
        lastFrameTime = System.currentTimeMillis();
        elapsed=0;
    }

    @Override
    public void run(){
        while(isrunning) {
            currentTime = System.currentTimeMillis();
            a.Mover(elapsed);
            p.Mover(posP);
            //check collison between ball and paddle, if collide change ball direction
            if (a.curpos.intersect(p.pos))
                a.ChangeDirection();
                //if ball position is bellow paddle, reset position to screen center
            else if (a.curpos.bottom > p.pos.top)
                a.pos.set(width / 2, height / 2);
            //check collision between ball and bricks, if brick is hit set to true so it is not drawn anymore
            for (int i = 0; i <= b.pos.length - 1; i++) {
                for (int j = 0; j <= b.pos[i].length - 1; j++) {
                    if (!b.colidiu[i][j]) {
                        if (a.curpos.intersect(b.pos[i][j])) {
                            b.colidiu[i][j] = true;
                            a.ChangeDirection();
                        }
                    }
                }
            }
            elapsed = (System.currentTimeMillis() - lastFrameTime) * .001f;//convert ms to seconds
            lastFrameTime = currentTime;
        }
    }

    public void resume(){
        isrunning = true;
        game = new Thread(this);
        game.start();
    }

    public void stopThread(){
        isrunning = false;
        game.interrupt();
        game = null;
    }

    //single touch event
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_MOVE:
                posP = event.getX();
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        for (int i=0; i<= b.pos.length-1;i++)
        {
            for (int j = 0; j <= b.pos[i].length - 1; j++)
            {
                if(!b.colidiu[i][j])
                {
                    canvas.drawRect(b.pos[i][j], b.p);
                }
            }
        }
        canvas.drawCircle((int) a.pos.getX(), (int) a.pos.getY(), a.raio, a.p);
        canvas.drawRect(p.pos, paint);
        invalidate();
    }
}
