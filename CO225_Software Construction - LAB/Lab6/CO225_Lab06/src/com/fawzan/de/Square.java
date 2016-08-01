package com.fawzan.de;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by Fawzan
 * on 7/26/16
 * <fawzanm@gmail.com>
 */
public class Square extends Shape {

    private int x, y;
    private int width, height;

    public Square(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Square(Color color, int x, int y, int width, int height) {
        super(color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {

//        super.draw(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.color);

        g2.draw(new Line2D.Double(x, y, x + width, y));
        g2.draw(new Line2D.Double(width + x, y, x + width, y + height));
        g2.draw(new Line2D.Double(x, y + height, x + width, y + height));
        g2.draw(new Line2D.Double(x, y, x, y + height));

    }
}
