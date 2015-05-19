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
            {   // rect(w/28, h/40, w/28*4, h/40*2) primeira posição
                pos[i][j] = new Rect((w/28)*(4*j+1),(h/40)*(2*i+1),(w/28*4)*(j+1),(h/40*2)*(i+1));
                colidiu[i][j] = false;
            }
        }
    }
}
