/**
	Created by K. A. D. Nadeeshan (E/13/234)
	Email : dinuka.nadeeshan1993@gmail.com

	CO225 - Software Construction - Mid term Project - Fractals

	
*/


public class JuliaSet extends FractalType{
	
	public JuliaSet(int length, int width, ComplexNumber c, int iterations){
		super(length, width,c,iterations);
	}

	@Override
	public synchronized int isDiverge(ComplexNumber cn){
		boolean isDiv = false;
		ComplexNumber zn = cn;
		
				
		int i;
		for (i=0; i<iterations ; i++) {
			ComplexNumber zn1 = zn.squre().add(c);

			if(zn1.abs() > 2){
				isDiv = true;
				return i;
			}	

			zn = zn1;
		}
		return i;
	}
}