/**
	 Created by K. A. D. Nadeeshan (E/13/234)
	 Email : dinuka.nadeeshan1993@gmail.com
	
	 CO225 - Software Construction - Mid term Project - Fractals
*/

public class MandelbrotSet extends FractalType{
	public MandelbrotSet(int length, int width,double startX,double startY,double endX,double endY,int iterations){
		super(length, width, startX, startY, endX, endY,iterations);
	}

	@Override
	public synchronized  int isDiverge(ComplexNumber cn){
		boolean isDiv = false;
		ComplexNumber zn = new ComplexNumber(0,0);
		int i;
		for ( i=0; i<iterations ; i++) {
			ComplexNumber zn1 = zn.squre().add(cn);

			if(zn1.abs() > 2){
				isDiv = true;
				return i;
			}	

			zn = zn1;
		}
		return i;
	}

}