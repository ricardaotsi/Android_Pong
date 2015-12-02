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
    private int he;

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
