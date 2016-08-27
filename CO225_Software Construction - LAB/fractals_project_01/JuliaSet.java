public class JuliaSet extends FractalType{
	
	public JuliaSet(int length, int width, ComplexNumber c, int iterations){
		super(length, width,c,iterations);
	}

	@Override
	public boolean isDiverge(ComplexNumber cn){
		boolean isDiv = false;
		ComplexNumber zn = cn;
		
				
			
		for (int i=0; i<iterations ; i++) {
			ComplexNumber zn1 = zn.squre().add(c);

			if(zn1.abs() > 2){
				isDiv = true;
				break;
			}	

			zn = zn1;
		}
		return isDiv;
	}
}