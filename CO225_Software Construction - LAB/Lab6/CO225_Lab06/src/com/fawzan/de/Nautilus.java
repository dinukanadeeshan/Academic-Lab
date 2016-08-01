package com.fawzan.de;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.QuadCurve2D;

/**
 * Created by Fawzan
 * on 7/26/16
 * <fawzanm@gmail.com>
 */
public class Nautilus extends JPanel {

    private static int WIDTH = 1500;
    private static int HEIGHT = 900;
    private final static int SCALE = 2;

    public Nautilus(int w, int h) {
        setSize(w, h);
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Nautilus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Nautilus(WIDTH, HEIGHT));

        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.pack();
        frame.setVisible(true);


    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        int[] fibList = Fibonacci.getFibList(15);


        int tempY, tempX;
        int xPos = 400, yPos = 300;
        int preX = xPos, preY = yPos;
        tempY = yPos + 1 * SCALE;
        new Line(xPos, xPos, yPos, tempY).draw(g);
        new Line(xPos + SCALE, xPos + SCALE, yPos, yPos + SCALE).draw(g);
        yPos = tempY;
        int xForS = xPos, yForS = yPos;

        for (int i = 0; i < 15; i++) {
            int rem = i % 4;

            if (rem == 0) {
                tempX = xPos + (SCALE * fibList[i]);
                new Line(xPos, xPos + SCALE * fibList[i], yPos - SCALE * (i == 0 ? 1 : fibList[i - 1]), yPos - SCALE * (i == 0 ? 1 : fibList[i - 1])).draw(g);
                new Line(xPos, tempX, yPos, yPos).draw(g);
                xPos = tempX;

//                new Line(Color.red, preX, preY, xPos - (SCALE * (i == 0 ? 1 : fibList[i - 1])), yPos).draw(g);
                g.setColor(Color.red);
                ((Graphics2D) g).setStroke(new BasicStroke(2));
                g2d.draw(new QuadCurve2D.Double(preX, preY, preX, yPos, xPos - (SCALE * (i == 0 ? 1 : fibList[i - 1])), yPos));
                ((Graphics2D) g).setStroke(new BasicStroke(1));
                preX = xPos - (SCALE * (i == 0 ? 1 : fibList[i - 1]));
                preY = yPos;


            } else if (rem == 1) {
                tempY = yPos - (SCALE * fibList[i]);
                new Line(xPos - SCALE * (i == 0 ? 1 : fibList[i - 1]), xPos - SCALE * (i == 0 ? 1 : fibList[i - 1]), yPos, yPos - SCALE * fibList[i]).draw(g);
                new Line(xPos, xPos, yPos, tempY).draw(g);
                yPos = tempY;


//                new Line(Color.red, preX, preY, xPos, yPos + (SCALE * (i == 0 ? 1 : fibList[i - 1]))).draw(g);
                g.setColor(Color.red);
                ((Graphics2D) g).setStroke(new BasicStroke(2));
                g2d.draw(new QuadCurve2D.Double(preX, preY, xPos, preY, xPos, yPos + (SCALE * (i == 0 ? 1 : fibList[i - 1]))));
                ((Graphics2D) g).setStroke(new BasicStroke(1));

                preX = xPos;
                preY = yPos + (SCALE * (i == 0 ? 1 : fibList[i - 1]));

            } else if (rem == 2) {
                tempX = xPos - (SCALE * fibList[i]);
                new Line(xPos, xPos - SCALE * fibList[i], yPos + SCALE * (i == 0 ? 1 : fibList[i - 1]), yPos + SCALE * (i == 0 ? 1 : fibList[i - 1])).draw(g);
                new Line(xPos, tempX, yPos, yPos).draw(g);
                xPos = tempX;

//                new Line(Color.red, preX, preY, xPos + (SCALE * (i == 0 ? 1 : fibList[i - 1])), yPos).draw(g);
                g.setColor(Color.red);
                ((Graphics2D) g).setStroke(new BasicStroke(2));
                g2d.draw(new QuadCurve2D.Double(preX, preY, preX, yPos, xPos + (SCALE * (i == 0 ? 1 : fibList[i - 1])), yPos));
                ((Graphics2D) g).setStroke(new BasicStroke(1));

                preX = xPos + (SCALE * (i == 0 ? 1 : fibList[i - 1]));
                preY = yPos;

            } else if (rem == 3) {
                tempY = yPos + (SCALE * fibList[i]);
                new Line(xPos + SCALE * (i == 0 ? 1 : fibList[i - 1]), xPos + SCALE * (i == 0 ? 1 : fibList[i - 1]), yPos, yPos + SCALE * fibList[i]).draw(g);
                new Line(xPos, xPos, yPos, tempY).draw(g);
                yPos = tempY;


//                new Line(Color.red, preX, preY, xPos, yPos - (SCALE * (i == 0 ? 1 : fibList[i - 1]))).draw(g);
                g.setColor(Color.red);
                ((Graphics2D) g).setStroke(new BasicStroke(2));
                g2d.draw(new QuadCurve2D.Double(preX, preY, xPos, preY, xPos, yPos - (SCALE * (i == 0 ? 1 : fibList[i - 1]))));
                ((Graphics2D) g).setStroke(new BasicStroke(1));

                preX = xPos;
                preY = yPos - (SCALE * (i == 0 ? 1 : fibList[i - 1]));

            }
        }

    }

    


}
