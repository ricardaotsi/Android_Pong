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

import android.graphics.Rect;

/**
 * Created by Arruda on 12/05/2015.
 */
public class Paddle {

    Rect pos = new Rect();
    private int wi;

    public Paddle(int w, int h)
    {
        //position set to a x,y point and making an offset to set the paddle
        pos.set(w/2 - w/10 ,h/4*3-h/90,w/2 + w/10,h/4*3+h/90);
        wi=w;
    }

    public void Mover(float x)
    {
        //Set paddle position with the touch
        pos.set(Math.round(x) - wi/10,pos.top,Math.round(x) + wi/10,pos.bottom);
    }
}
