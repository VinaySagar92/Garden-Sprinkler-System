/**
 * @date 12/07/2016
 */
package High;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.LinkedHashMap;

import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * 
 * @author VINAY SAGAR GONABAVI and SHIVAM VARMA
 *
 */
public class Graph extends JPanel{
	public LinkedHashMap<String, Double> XYvalues = new LinkedHashMap<String, Double>();
	int base;
	String xRepresentation;
	String yRepresentation;
	double limit;
	private int x, y;	
	//JButton graphtocontrol;
	public Graph(LinkedHashMap m, int base, String xRepresentation, String yRepresentation, Double limit){	
		
			JButton graphtocontrol;
			this.XYvalues=m;
			this.xRepresentation=xRepresentation;
			this.yRepresentation=yRepresentation;
			this.limit=limit;
			this.base=base;
			setBackground(Color.WHITE);
			setLayout(null);
			repaint();
			
		}
	//Override paintComponent to perform your own custom drawingz
	
	
	/**
	 * @param Graphics g
	 */
	@Override
	 protected void paintComponent(Graphics g) 
	 {
		int offset=base/10;
	    super.paintComponent(g);
	     
	     
	     Graphics2D g2 = (Graphics2D)g;	
	     
	     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	    
	   
	     //Y axis  
	     x =50;	
	     y=10;
	     g2.setPaint(Color.BLACK);
	     g2.fill(new Rectangle2D.Double(x,y,1,300));
	     
	    //X axis
	     x =50;		
	     y=310;
	     g2.setPaint(Color.BLACK);
	     g2.fill(new Rectangle2D.Double(x,y,550,1));
	     
	     //Draw ticks on graph
	     int drop=0;
	     int value=base;
	     for(int i=0;i<10;i++)
	     {
	    	 x=45;
	    	 y=10+drop;
	    	 g2.drawString(Integer.toString(value), 10, y);
	    	 g2.fill(new Rectangle2D.Double(x,y,10,1));
	    	 drop= drop+30;
	    	 value=value-offset;
	     }
	     
	     //make rectangles
	     int gap=20;
	     double ratio=base/300.0; //defines the distance every tick represents.
	     g2.setFont(new Font("TimesRoman", Font.PLAIN, 12));
	     g2.setPaint(Color.GRAY);
	     
	     for (String key : XYvalues.keySet()) 
	     {
	    	 double value1=XYvalues.get(key);
	    	 if(value1>limit)
	    		 g2.setPaint(Color.RED);
	    	 else
	    		 g2.setPaint(Color.GRAY);
	    	 int height= (int)(value1/ratio);
	    	 y=310-height;
	    	 x=50+gap;
	    	 g2.fill(new Rectangle2D.Double(x,y,40,height));
	    	 gap=gap+80;

	     }
	     
	     //x axis coordinates
	     int gap2=20;
		 g2.setPaint(Color.BLACK);
		 for (String key : XYvalues.keySet()) 
	     {
			 x=45+gap2;  //x,y value for the x axis values
	    	 y=320;
	    	 g2.drawString(key, x, y);
	    	 gap2=gap2+80;

	     }
	     
	     //XY representation
	     g2.setPaint(Color.BLUE);
	     g2.setFont(new Font("TimesRoman", Font.PLAIN, 18));
	     x=380;
	     y=50;
	     g2.drawString("X represents: "+xRepresentation, x, y);
	     y=80;
	     g2.drawString("Y represents: "+yRepresentation, x, y);
	}   
}