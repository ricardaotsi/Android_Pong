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
