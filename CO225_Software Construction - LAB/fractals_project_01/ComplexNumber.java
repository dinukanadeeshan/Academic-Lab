/**
	Created by K. A. D. Nadeeshan (E/13/234)
	Email : dinuka.nadeeshan1993@gmail.com

	CO225 - Software Construction - Mid term Project - Fractals

	
*/
/** Create class for Complex Number to Calculate complex numbers*/
public class ComplexNumber{
	private double x;
	private double y;

	public ComplexNumber(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double getX(){ return x; }
	
	public double getY(){ return y; }

	public void setX(double x){ this.x = x; }

	public void setY(double y){ this.y = y; }

	public double abs(){ 
		return Math.sqrt(x*x + y*y); 
	}

	public ComplexNumber squre(){ 
		return new ComplexNumber(x*x - y*y, 2 * x * y); 
	}

	public ComplexNumber add(ComplexNumber c){
		return new ComplexNumber(c.x+x, c.y+y);
	}

	public String toString(){
		return x+" "+y+"i";
	}
}