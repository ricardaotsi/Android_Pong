package com.dream.arruda.pong;

import java.util.Vector;

/**
 * Created by Arruda on 15/05/2015.
 */
public class Ball {
    Vector2D pos;
    Vector2D dir;
    int vel;
    int raio;

    public Ball(int w,int h)
    {
        pos = new Vector2D(w/2,h/2);
        dir = new Vector2D(0,1);
        raio = w/28;
        vel =10;
    }

    public void Mover()
    {
        pos.addMe(dir.multiply(vel));
    }
}
