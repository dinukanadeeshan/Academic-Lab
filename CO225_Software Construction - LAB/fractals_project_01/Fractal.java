/**
	Created by K. A. D. Nadeeshan (E/13/234)
	Email : dinuka.nadeeshan1993@gmail.com

	CO225 - Software Construction - Mid term Project - Fractals

	
*/

import javax.swing.*;
public class Fractal extends JFrame{

	public Fractal(double startX, double startY, double endX, double endY, int iter){
		MandelbrotSet ms = new MandelbrotSet(800,800,startX,startY,endX,endY,iter);
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(ms);
		setVisible(true);
	}

	public Fractal(ComplexNumber c, int iter){
		JuliaSet js = new JuliaSet(800,800,c,iter);
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(js);
		setVisible(true);
	}

	public static void main(String[] args) {
		if(args[0].equals("Mandelbrot")){
			new Thread(){
				public void run(){
					new Fractal(Double.parseDouble(args[1]),Double.parseDouble(args[3]),Double.parseDouble(args[2])
					,Double.parseDouble(args[4]),Integer.parseInt(args[5]));
				}
			}.start();

		} else if (args[0].equals("Julia")) {
			new Thread(){
				public void run(){
					new Fractal(new ComplexNumber(Double.parseDouble(args[1]),Double.parseDouble(args[2])),Integer.parseInt(args[3]));
				}
			}.start();
		} else {
			System.out.println("Invalid Input");
			System.exit(1);
		}
	}
}