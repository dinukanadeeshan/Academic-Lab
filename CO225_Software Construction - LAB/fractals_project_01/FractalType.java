/**
	Created by K. A. D. Nadeeshan (E/13/234)
	Email : dinuka.nadeeshan1993@gmail.com

	CO225 - Software Construction - Mid term Project - Fractals

	
*/

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.*;
import java.awt.event.*;
public abstract class FractalType extends JPanel implements MouseListener{

	private volatile BufferedImage canvasImage;
	private  double startX;
	private  double endX;
	private  double startY;
	private  double endY;
	protected  int iterations;
	protected volatile ComplexNumber c;

	private double zoom = 800;

	private int x1;
	private int x2;

	private int y1;
	private int y2;


	@Override
	public void mouseClicked(MouseEvent e){
		

	}
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){}
	@Override
	public void mousePressed(MouseEvent e){
		if(e.getButton() == MouseEvent.BUTTON1){
			// startX += e.getX()/ zoom;
			// endY -= e.getY()/ zoom;
			//zoom *= 2;
			x1 = e.getX();
			y1 = e.getY();

		}
	}
	@Override
	public void mouseReleased(MouseEvent e){
		if(e.getButton() == MouseEvent.BUTTON1){
			x2 = e.getX();
			y2 = e.getY();

			startX += x1/zoom;
			endY -= y1/zoom;

			startY += (getHeight() - y2)/zoom;
			endX -= (getWidth() - x2)/zoom;

			//zoom *= 2;
			designImage();
		}


	}
	/**
		Constructor for MandelbrotSet Fractal
	*/
	public FractalType(int length, int width,double startX,double startY,double endX,double endY, int iterations){
		setSize(length,width);
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.iterations = iterations;
		canvasImage =  new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		designImage();
		
	}

	/**
		Constructor for JuliaSet Fractal
	*/
	public FractalType(int length, int width,ComplexNumber c,int iterations){
		setSize(length,width);
		this.startX = -1;
		this.startY = -1;
		this.endX = 1;
		this.endY = 1;
		this.iterations = iterations;
		this.c = c;
		canvasImage =  new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		designImage();
	}

	/**
		Method that mark the points and decide the color of pixel in canvas
	*/
	private void designImage(){
		
		// setResizable(false);

		addMouseListener(this);

		for (int y = 0; y < getHeight(); y+=100) {
			
			final int _Y = y;
		    new Thread(){
	            @Override
	        	public void run(){
	        		int i = _Y != 0 ? _Y - 20 : _Y;
	        		int limit = _Y + 100 > getHeight() ? getHeight(): _Y + 100;
					for(; i < limit; i++){   
						double c1 = endY - ((endY - startY)*i)/zoom; 
					    for (int x = 0; x < getWidth(); x++) {
			            	double c2 = startX + ((endX - startX)*x)/zoom;
			            	int res = isDiverge(new ComplexNumber(c2,c1));
			            	Color c=null;
			      //       	switch(res){
			      //       		case 0:
			      //       			c = Color.blue;
			      //       			break;
		       //      			case 1:
									// c = Color.white;
			      //       			break;
		       //      			case 2:
									// c = Color.orange;
			      //       			break;
		       //      			case 3:
									// c = Color.red;
			      //       			break;
			      //       	}


			     //        	if(0<res && res < 100){
			     //        		c = Color.yellow;
			     //        		System.out.println(c.getRGB());
			     //        	} else if(99<res && res < 201){
								// c = Color.blue;
			     //        	} else if(200<res && res < 301){
								// c = Color.orange;
			     //        	} else if(300<res && res < 401){
								// c = Color.pink;
			     //        	} else if(400<res && res < 501){
								// c = Color.cyan;
			     //        	} else if(500<res && res < 601){
								// c = Color.lightGray;
			     //        	} else if(600<res && res < 701){
								// c = Color.magenta;
			     //        	} else if(700<res && res < 801){
								// c = Color.black;								
			     //        	} else if(800<res && res < 901){
								// c = Color.gray;
			     //        	} else if(900<res && res < 1000){
								// c = Color.darkGray;
			     //        	} else {
								// c = Color.red;
			     //        	}
					  	    canvasImage.setRGB(x,i,res<<3);
			           	    repaint();
			            } 
			        }           		
     		
		    	}
	        }.start();


		  

		}


			

	}

	/** 
		Override the paintComponent method in JPanel to add the BufferedImage canvas to display
	*/
	@Override
    protected void paintComponent(Graphics g) {


    	 g.drawImage(canvasImage, 0, 0, this);

    	

        // System.out.println("Done...");

    }

    /**
		Make abstract method to check the divergence or convergence of relevant Complex number

		Implementation vary with the type of fractal.
    */
	public abstract  int isDiverge(ComplexNumber cn);
}