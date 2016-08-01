package com.fawzan.de;

import java.awt.*;

/**
 * Created by Fawzan
 * on 7/26/16
 * <fawzanm@gmail.com>
 */
public class Shape {

    protected Color color;


    //default color of the shape is balck
    public Shape() {
        this.color = Color.black;
    }

    //Specify the color
    public Shape(Color color) {
        this.color = color;
    }


    //method draw
    public void draw(Graphics g) {
    }
}
