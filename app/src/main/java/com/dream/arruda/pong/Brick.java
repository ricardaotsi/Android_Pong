package com.dream.arruda.pong;

import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Arruda on 14/05/2015.
 */
public class Brick {
    Rect[][] pos = new Rect[8][7];
    boolean[][] colidiu = new boolean[8][7];
    Paint p = new Paint();

    public Brick(int w, int h)
    {
        p.setARGB(255,255,165,0);
        for (int i=0; i<= pos.length-1;i++)
        {
            for (int j=0; j<=pos[i].length-1;j++)
            {
                pos[i][j] = new Rect(w/7*j + w/40, h/30*i + h/70, w/7*(j+1) - w/40, h/30*(i+1));
                colidiu[i][j] = false;
            }
        }
    }
}
