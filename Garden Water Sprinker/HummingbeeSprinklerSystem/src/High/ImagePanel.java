/**
 * @date 12/07/2016
 */
package High;


import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * @author VINAY SAGAR GONABAVI and SHIVAM VARMA
 *
 */
public class ImagePanel extends JPanel {

	  private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }
	  
	  /**
		 * @param Graphics g
		 */
	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	  }

	}