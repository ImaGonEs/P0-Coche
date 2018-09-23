import java.awt.*;

import javax.swing.*;


public class JLabelCoche extends JLabel {
	
	public static final int size = 100;  
	
	
	public JLabelCoche() {
		
		setBounds( 0, 0, size, size );
	
	}
	

	private double rot = Math.PI/2;
	
	public void setRot( double dir) {
		rot = dir/180*Math.PI;
		
		rot = rot + Math.PI/2;
	}

	
	@Override
	protected void paintComponent(Graphics g) {

		Image img = ((ImageIcon)getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g; 
	
        g2.rotate( rot, 50, 50 ); 
       
        g2.drawImage( img, 0, 0, size, size, null );
	}
}