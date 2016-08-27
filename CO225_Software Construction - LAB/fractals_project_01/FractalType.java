import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.*;
public abstract class FractalType extends JPanel{

	private BufferedImage canvasImage;
	private double startX;
	private double endX;
	private double startY;
	private double endY;
	protected int iterations;
	protected ComplexNumber c;


	public FractalType(int length, int width,double startX,double startY,double endX,double endY, int iterations){
		setSize(length,width);
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.iterations = iterations;

		designImage();
		
	}

	public FractalType(int length, int width,ComplexNumber c,int iterations){
		setSize(length,width);
		this.startX = -1;
		this.startY = -1;
		this.endX = 1;
		this.endY = 1;
		this.iterations = iterations;
		this.c = c;
		designImage();
	}
	
	private void designImage(){
		canvasImage =  new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		// setResizable(false);

		for (int y = 0; y < getHeight(); y++) {
    		double c1 = endY - ((endY - startY)*y)/getHeight(); 
            for (int x = 0; x < getWidth(); x++) {
            	double c2 = startX + ((endX - startX)*x)/getWidth();
		    	//System.out.println(c2+" "+c1);
		        canvasImage.setRGB(x,y,isDiverge(new ComplexNumber(c2,c1))?Color.red.getRGB():Color.black.getRGB());
		       // canvasImage.setRGB(x,y,x%5 < 2? Color.red.getRGB():Color.black.getRGB());
            }
        }
	}

	@Override
    protected void paintComponent(Graphics g) {


    	 g.drawImage(canvasImage, 0, 0, this);

    	

        System.out.println("Done...");

    }

	public abstract boolean isDiverge(ComplexNumber cn);
}