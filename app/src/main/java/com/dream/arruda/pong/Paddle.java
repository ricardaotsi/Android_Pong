package com.dream.arruda.pong;

import android.graphics.Rect;

/**
 * Created by Arruda on 12/05/2015.
 */
public class Paddle {

    Rect pos = new Rect();
    int he;

    public Paddle(int w, int h)
    {
        //graphic set by width and height of actual screen for dynamic graphic
        pos.set(w/2 - (h/10)/2 ,(h/4)*3-(w/20)/2,w/2 + (h/10)/2,(h/4)*3+(w/20)/2);
        he=h;
    }

    public void Mover(float x)
    {
        //seta o paddle de acordo com o touch
        pos.set(Math.round(x)- (he/10)/2,pos.top,Math.round(x) + (he/10)/2,pos.bottom);
    }
}
