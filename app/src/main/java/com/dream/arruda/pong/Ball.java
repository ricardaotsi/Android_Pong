package com.dream.arruda.pong;

import android.graphics.Paint;

import java.util.Vector;

/**
 * Created by Arruda on 15/05/2015.
 */
public class Ball {
    Vector2D pos;
    Vector2D dir;
    int vel;
    int raio;
    int width;
    int height;
    Paint p = new Paint();

    public Ball(int w,int h)
    {
        width=w;
        height=h;
        pos = new Vector2D(w/2,h/2);
        dir = new Vector2D(0.5,1);
        raio = w/28;
        vel =10;
        p.setARGB(255,255,0,0);
    }

    public void Mover()
    {
        if(pos.getY()+raio>=height || pos.getY()-raio<=0)
            dir.set(dir.getX(), -dir.getY());
        if(pos.getX()+raio>=width || pos.getX()-raio<=0)
            dir.set(-dir.getX(),dir.getY());
        pos.addMe(dir.multiply(vel));
    }
}
