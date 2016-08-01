package com.fawzan.de;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;

/**
 * Created by Fawzan
 * on 7/26/16
 * <fawzanm@gmail.com>
 */
public class Main extends JPanel {

    private static int WIDTH = 1500;
    private static int HEIGHT = 900;

    private static ArrayList<Shape> listOfShapes;

    public static void main(String[] args) {
        // write your code here


        JFrame frame = new JFrame("Nautilus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Main());
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setSize(WIDTH, HEIGHT);
        frame.pack();
        frame.setVisible(true);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Line line = new Line(Color.red, 0, 0, 400, 600);
        Square square = new Square(Color.green, 10, 10, 300, 300);
        Circle circle = new Circle(Color.blue, 50,50,20);

        Triangle triangle = new Triangle(Color.pink, 20, 30, 100, 300, 150, 400);


        line.draw(g);
        square.draw(g);
        circle.draw(g);
        triangle.draw(g);

    }
}


// new Arc2D.Double