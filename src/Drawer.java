import java.io. * ;
import java.util.Scanner;

import java.awt.*;
import javax.swing.*;

public class Drawer extends JPanel{
	double[][] input;
	int[] label;

	public Drawer(double[][] ninput, int[] nlabel){
		input = ninput;
		label = nlabel;
  		this.setPreferredSize(new Dimension(280,280));
 	}

 	public void paint(Graphics g) {
  		Graphics2D g2D = (Graphics2D) g;
	  	for (int i = 0;i<28; i++) {
	  		for (int j = 0; j<28; j++) {
	  			double alpha = (input[0][j+(28*i)]*255);
	  			Color culor = new Color(0,0,0,(int)alpha);
	  			//System.out.println(input[0][j+(28*i)]);
	  			g2D.setPaint(culor);
	  			g2D.fillRect(j*10, i*10, 10, 10);
	  		}
	  	}
  	}
}
