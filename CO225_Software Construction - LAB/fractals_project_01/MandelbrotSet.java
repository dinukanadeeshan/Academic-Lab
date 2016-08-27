public class MandelbrotSet extends FractalType{
	public MandelbrotSet(int length, int width,double startX,double startY,double endX,double endY,int iterations){
		super(length, width, startX, startY, endX, endY,iterations);
	}

	@Override
	public boolean isDiverge(ComplexNumber cn){
		boolean isDiv = false;
		ComplexNumber zn = new ComplexNumber(0,0);
		
				//System.out.println(cn);
			
		for (int i=0; i<iterations ; i++) {
			ComplexNumber zn1 = zn.squre().add(cn);

			if(zn1.abs() > 2){
				isDiv = true;
				break;
			}	

			zn = zn1;
		}
		return isDiv;
	}

}