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

import java.util.Vector;

/**
 * Created by Arruda on 15/05/2015.
 */
public class Ball {
    Vector2D pos;
    Vector2D dir;
    double vel;
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
        raio = w/35;
        vel = width;
        p.setARGB(255,255,0,0);
    }
    //Move the ball in game loop
    public void Mover(int y, float fps)
    {
        //if ball position is bellow paddle, reset position to screen center
        if(pos.getY()>=y)
        {
            pos.set(width/2,height/2);
        }
        // if ball hit top wall, change direction
        else if(pos.getY()-raio<=0)
            dir.set(dir.getX(), -dir.getY());
        //if ball hit side walls, change direction
        if(pos.getX()+raio>=width || pos.getX()-raio<=0)
            dir.set(-dir.getX(),dir.getY());
        //update position with direction and velocity
        pos.addMe(dir.multiply(vel*fps));

    }
    //change ball direction in collision
    public void ChangeDirection()
    {
            dir.set(dir.getX(),-dir.getY());
    }
}
