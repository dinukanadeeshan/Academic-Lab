package com.fawzan.de;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Fawzan
 * on 7/26/16
 * <fawzanm@gmail.com>
 */
public class Main extends JPanel {

    private static int WIDTH = 400;
    private static int HEIGHT = 600;

    private static ArrayList<Shape> listOfShapes;

    public static void main(String[] args) {
        // write your code here


        JFrame frame = new JFrame("Some Shapes");

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

        line.draw(g);
        square.draw(g);


    }
}
