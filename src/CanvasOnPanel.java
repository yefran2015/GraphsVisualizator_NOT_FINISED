import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class CanvasOnPanel extends JPanel{
	public static final int CUSTOM_FUNCTION =0;
	public static final int LINEAR =1;
	public static final int SQUARE =2;
	public static final int CUBE =3;
	public static final int SQUARE_ROOT =4;
	public static final int RECIPROCAL=5;
	public static final int ABSOLUTE_VALUE =6;
	public static final int EXPONENTIAL =7;
	public static final int NATURAL_LOGARITHM =8;
	public static double x_max=100.0;//initial value
	public static double y_max=100.0;//initial value
	public static final double xUnit=0.1;
	public static final double yUnit=0.1;
	public static double brushSize=.04;
	public static final double stretchGraphHorizontlyBy =10;
	public static final double stretchGraphVerticallyBy =50;
	private int x_mid;
	private int y_mid;
	private Graphics2D g2;
	public Graphics2D getG2(){
		return g2;
	}
//	public int getWidth(){
//		return getWidth();
//	}
//	public int getHeight(){
//		return getHeight();
//	}
	protected void paintComponent(Graphics g){
		super.paintComponents(g);
		this.g2 = (Graphics2D) g;
		
		
		setName("Canvas");
		this.setBorder(new TitledBorder("Functions Canvas"));
		
		FontMetrics fm = g.getFontMetrics();
		int stringWidth = fm.stringWidth("0 . 0");
		int stringAscent = fm.getAscent();
		x_max=getWidth();
		y_max=getHeight();
		
		
		int x_centr  = getWidth()/2;
		int y_centr =  getHeight() / 2;
		
		int x_zero_cent = getWidth()/2;
		int y_zero_cent = getHeight() / 2;
		x_mid = getWidth()/2;
		y_mid = getHeight()/2;
		
		int xNum = 100;// this is main scale marks every ten units
		int yNum = 100;//this is main scale marks every ten units
		int xNumSmall =10;//this is smallest scale lines every one unit
		int yNumSmall =10;//this is smallest scale linesevery one unit
		
		
		double xBrushCntr =x_centr-brushSize/2;
		double yBrushCntr = y_centr-brushSize/2;
		
		
		int arrowHeadSize = 10;
		String xLbl = "X";
		String yLbl = "Y";
		String xLbl2 = "Additional Information About X-Axel";
		String yLbl2 = "Additional Information About Y-Axel";
		
	//	g.drawString(getWidth()+" "+getHeight(), x, y);
		
		/**
		 * THis is middle lines of x and y on the 
		 * center of screen coordinates of (0,0)
		 * plus arrows and infinities or presented as input
		 * like x -1..1  y = -1 ..1
		 */
		
	    g2.setStroke(new BasicStroke(2));
	  //  g2.setColor(Color.GREEN);
	    g2.drawLine(0, y_mid, getWidth(), y_mid);
	    g2.drawLine(x_mid, arrowHeadSize, x_mid, getHeight());
	    
	    //arrows this one is for x-axles:
	    g2.drawLine(getWidth(), y_mid, getWidth()-arrowHeadSize, y_mid-arrowHeadSize);
	    g2.drawLine(getWidth(), y_mid, getWidth()-arrowHeadSize, y_mid+arrowHeadSize);
	    
	   
	    
	    
	  //arrows this one is for y-axles:
	    g2.drawLine(x_mid, 0, x_mid-arrowHeadSize, arrowHeadSize);
	    g2.drawLine(x_mid, 0, x_mid+arrowHeadSize, arrowHeadSize);
	    
	    Font f = new Font ("Serif", Font.PLAIN, 18);
	    g2.setFont(f);
	    
	    //Labels for y-axle
	    g2.setColor(Color.RED);
	    g2.drawString(yLbl, x_mid+arrowHeadSize, arrowHeadSize+5);
	    g2.setColor(Color.BLUE);
	    g2.drawString(yLbl2, x_mid+arrowHeadSize, arrowHeadSize+20);
	    
	    
	    //Labels for x-axle
	    g2.setColor(Color.RED);
	    g2.drawString(xLbl, getWidth()-arrowHeadSize-5, y_mid-arrowHeadSize);
	    g2.setColor(Color.BLUE);
	//    System.out.println(xLbl2.length()+"   "+getWidth());
	    g2.drawString(xLbl2, getWidth()-xLbl2.length()*8, y_mid+30);
	    g2.setColor(Color.BLACK);
	    
	    /** this code for putting 0 . 0 at the center of coordinate pane
	    //label for zeros at center
	//    stringWidth = fm.stringWidth("0 . 0");
	    x_zero_cent = getWidth()/2 - stringWidth /2 ;
	    f = new Font ("Serif", Font.BOLD, 18);
	    g2.setFont(f);
		g2.drawString("0 . 0", x_zero_cent-5, y_mid);
		*/
	    
	    
		/**
		 * Now here loops to show rules on axles 
		 * 
		 */
		int counter=0;
		for(int i=x_mid,k=x_mid;i>0;i-=xNum,k+=xNum){
			f = new Font ("Serif", Font.BOLD, 17);
		    g2.setFont(f);
			g2.drawLine(i, y_mid-5, i, y_mid+5);
			if(counter>0)
				g2.drawString("-"+(counter)+"", i-10, y_mid-10);
			g2.drawLine(k, y_mid-5, k, y_mid+5);
			if(counter>0)
				g2.drawString((counter)+"", k-10, y_mid-10);
			counter+=10;
		}
		counter=0;
		for(int i=y_mid,k=y_mid;i>0;i-=yNum,k+=yNum){
			f = new Font ("Serif", Font.BOLD, 17);
		    g2.setFont(f);
			g2.drawLine(x_mid-5,i, x_mid+5,  i);
			if(counter>0)
				g2.drawString((counter)+"", x_mid+10,  i+4);
			if(counter>0)
				g2.drawString("-"+(counter)+"", x_mid+10,  y_mid+counter*10+4);
			g2.drawLine( x_mid-5,k, x_mid+5, k);
			counter+=10;
		}
		counter =0;
		for(int i=x_mid,k=x_mid;i>0;i-=xNumSmall,k+=xNumSmall){
			f = new Font ("Serif", Font.PLAIN, 17);
		    g2.setFont(f);
			g2.drawLine(i, y_mid-2, i, y_mid+2);
			g2.drawLine(k, y_mid-2, k, y_mid+2);
			counter-=10;
		}
		for(int i=y_mid,k=y_mid;i>0;i-=yNumSmall,k+=yNumSmall){
			f = new Font ("Serif", Font.PLAIN, 1);
		    g2.setFont(f);
			g2.drawLine(x_mid-2,i, x_mid+2,  i);
			g2.drawLine( x_mid-2,k, x_mid+2, k);
		}
		
		g.setColor(Color.MAGENTA);
//		g.drawOval(xBrushCntr , yBrushCntr, brushSize, brushSize);
//		g.drawOval(xBrushCntr-xNum , yBrushCntr-yNum, brushSize, brushSize);
//		//drawFunction("");
		
//		Ellipse2D.Double shape;
//		for(double i=0.0;i<1000.0;i+=0.1){
//			shape = new Ellipse2D.Double(xBrushCntr+i*10, (yBrushCntr-(int)Math.pow(i, 3)),(double)(brushSize/.7),(double)(brushSize/.7));
//			g2.draw(shape);
//		}
//		for(double i=0.0;i>-1000.0;i-=0.1){
//			shape = new Ellipse2D.Double(xBrushCntr+i*10, (yBrushCntr-(int)Math.pow(i, 3)),(double)(brushSize/.7),(double)(brushSize/.7));
//			g2.draw(shape);
//		}
//		for(int i=0;i<1000;i+=1){
//			g.drawOval(xBrushCntr+i*10,(yBrushCntr-(int)Math.pow(i, 5)),brushSize,brushSize);
//		}
//		for(int i=0;i>-1000;i--){
//			g.drawOval(xBrushCntr+i*10,(yBrushCntr-(int)Math.pow(i, 5)),brushSize,brushSize);
//		}
		
		
		
		
		
		
		
		drawFunction(LINEAR,g2,getWidth(),getHeight(), x_mid, y_mid, brushSize, Color.BLUE);
		drawFunction(SQUARE,g2,getWidth(),getHeight(), x_mid, y_mid, brushSize, Color.RED);
		drawFunction(CUBE,g2,getWidth(),getHeight(), x_mid, y_mid, brushSize, Color.GREEN);
		drawFunction(SQUARE_ROOT,g2,getWidth(),getHeight(), x_mid, y_mid, brushSize, Color.ORANGE);
		drawFunction(RECIPROCAL,g2,getWidth(),getHeight(), x_mid, y_mid, brushSize, Color.PINK);
		drawFunction(EXPONENTIAL,g2,getWidth(),getHeight(), x_mid, y_mid, brushSize, Color.MAGENTA);
		drawFunction(NATURAL_LOGARITHM,g2,getWidth(),getHeight(), x_mid, y_mid, brushSize, Color.YELLOW);
		drawFunction(CUSTOM_FUNCTION,g2,getWidth(),getHeight(), x_mid, y_mid, brushSize, Color.BLACK);
		
		
		setVisible(true);
	}

	public static Graphics2D drawFunction(int functionType, Graphics2D g2d, int canvasWidth, int canvasHeight, int xCntr, int yCntr, double brushSize, Color color){
            // Treat each location as a 10x10 block. If position 1,1 then go to (5,5) - If position 3,5 then go to (25, 45) eg: (x*10)-5, (y*10)-5 
		Ellipse2D.Double shape;
		//int brushSize = 1;
//		int x_centr  = xCntr;
//		int y_centr = yCntr;
		double xBrushCntr =xCntr-brushSize/2;
		double yBrushCntr = yCntr-brushSize/2;
		if(color!=null){
			g2d.setColor(color);
		}
		switch(functionType){
			case LINEAR:
				for(double d=0.0,d1=0.0;d<x_max && d1>-x_max;d+=xUnit,d1-=xUnit){
					shape = new Ellipse2D.Double(xBrushCntr+d, yBrushCntr-d,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
					shape = new Ellipse2D.Double(xBrushCntr+d1, yBrushCntr-d1,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
				}
				break;
			case SQUARE:
				for(double i=0.0, i1=0.0;i<x_max && i1>-x_max;i+=xUnit,i1-=xUnit){
					shape = new Ellipse2D.Double(xBrushCntr+i*stretchGraphHorizontlyBy, (yBrushCntr-Math.pow(i, 2))*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
					shape = new Ellipse2D.Double(xBrushCntr-i*stretchGraphHorizontlyBy, (yBrushCntr-Math.pow(i1, 2))*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
				}
				break;
			case CUBE:
				for(double i=0.0, i1=0.0;i<x_max && i1>-x_max;i+=xUnit,i1-=xUnit){
					shape = new Ellipse2D.Double(xBrushCntr+i*stretchGraphHorizontlyBy, (yBrushCntr-Math.pow(i, 3))*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
					shape = new Ellipse2D.Double(xBrushCntr+i1*stretchGraphHorizontlyBy, (yBrushCntr+(-(Math.pow(i1, 3))))*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
				}
				break;	
			case ABSOLUTE_VALUE:
				for(double i=0.0, i1=0.0;i<x_max && i1>-x_max;i+=xUnit,i1-=xUnit){
					shape = new Ellipse2D.Double(xBrushCntr+i*stretchGraphHorizontlyBy, yBrushCntr-Math.abs(i)*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
					shape = new Ellipse2D.Double(xBrushCntr+i1*stretchGraphHorizontlyBy, yBrushCntr-Math.abs(i1)*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
				}
				break;	
			case SQUARE_ROOT:
				for(double i=0.0, i1=0.0;i<x_max && i1>-x_max;i+=xUnit,i1-=xUnit){
					shape = new Ellipse2D.Double(xBrushCntr+i*stretchGraphHorizontlyBy, yBrushCntr-Math.sqrt(i)*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
					shape = new Ellipse2D.Double(xBrushCntr+i1*stretchGraphHorizontlyBy, yBrushCntr-Math.sqrt(i1)*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
				}
				break;	
			case RECIPROCAL:
				for(double i=0.0, i1=0.0;i<x_max && i1>-x_max;i+=xUnit,i1-=xUnit){
					shape = new Ellipse2D.Double(xBrushCntr+i*stretchGraphHorizontlyBy, yBrushCntr-(1/i)*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
					shape = new Ellipse2D.Double(xBrushCntr+i1*stretchGraphHorizontlyBy, yBrushCntr-(1/i1)*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
				}
				break;	
			case EXPONENTIAL:
				for(double i=0.0, i1=0.0;i<x_max && i1>-x_max;i+=xUnit,i1-=xUnit){
					shape = new Ellipse2D.Double(xBrushCntr+i*stretchGraphHorizontlyBy, yBrushCntr-(Math.pow(Math.E, i))*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
					shape = new Ellipse2D.Double(xBrushCntr+i1*stretchGraphHorizontlyBy, yBrushCntr-(Math.pow(Math.E, i1))*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
					System.out.println("dsafjal;sfk");
				}
				break;
			case NATURAL_LOGARITHM:
				for(double i=0.0, i1=0.0;i<x_max && i1>-x_max;i+=xUnit,i1-=xUnit){
					shape = new Ellipse2D.Double(xBrushCntr+i*stretchGraphHorizontlyBy, yBrushCntr-Math.log(i)*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
					shape = new Ellipse2D.Double(xBrushCntr+i1*stretchGraphHorizontlyBy, yBrushCntr-Math.log(i1)*stretchGraphVerticallyBy,(double)(brushSize/.7),(double)(brushSize/.7));
					g2d.draw(shape);
				}
				break;
			case CUSTOM_FUNCTION:
				double  y = 0.0;
				for(double i=0.0, i1=0.0; i<x_max ; i+=xUnit,i1-=xUnit){
					y=(((Math.pow(i, 3)-2)/(Math.pow(Math.abs(i),3)+1)));
					shape = new Ellipse2D.Double((int)(xBrushCntr+i*stretchGraphHorizontlyBy), (int)(yBrushCntr-y*stretchGraphVerticallyBy),brushSize,brushSize);
					g2d.draw(shape);
					y=(((Math.pow(i1, 3)-2)/(Math.pow(Math.abs(i1),3)+1)));
					shape = new Ellipse2D.Double((int)(xBrushCntr+i1*stretchGraphHorizontlyBy), (int)(yBrushCntr-y*stretchGraphVerticallyBy),brushSize,brushSize);
					g2d.draw(shape);
				}			
				break;			
		}

            return g2d;
        	
    }
	public void drawFunc(){
		if(g2!=null)
			drawFunction(CUSTOM_FUNCTION,g2,getWidth(),getHeight(), x_mid, y_mid, brushSize, Color.BLACK);
	}
}
