import javax.swing.*;
public class Fractal extends JFrame{

	public Fractal(double startX, double startY, double endX, double endY, int iter){
		
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MandelbrotSet(800,800,startX,startY,endX,endY,iter));
		setVisible(true);
	}

	public Fractal(ComplexNumber c, int iter){

		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new JuliaSet(800,800,c,iter));
		setVisible(true);
	}

	public static void main(String[] args) {
		if(args[0].equals("Mandelbrot")){
			new Fractal(Double.parseDouble(args[1]),Double.parseDouble(args[3]),Double.parseDouble(args[2])
					,Double.parseDouble(args[4]),Integer.parseInt(args[5]));


		} else if (args[0].equals("Julia")) {
			new Fractal(new ComplexNumber(Double.parseDouble(args[1]),Double.parseDouble(args[2])),Integer.parseInt(args[3]));
		} else {
			System.out.println("Invalid Input");
			System.exit(1);
		}
	}
}