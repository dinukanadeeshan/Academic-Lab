package com.fawzan.de;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by Fawzan
 * on 7/26/16
 * <fawzanm@gmail.com>
 */
public class Line extends Shape {

    private int x1, y1, x2, y2;

    public Line(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Line(Color color, int x1, int y1, int x2, int y2) {
        super(color);

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.color);
        g2.draw(new Line2D.Double(x1, y1, x2, y2));

    }
}
