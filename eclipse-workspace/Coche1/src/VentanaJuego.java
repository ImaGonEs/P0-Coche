import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class VentanaJuego extends JFrame{

		private JPanel az;
		private JPanel za;
		private JButton ac;
		private JButton pa;
		private JButton izk;
		private JButton der;
		protected Coche lul;
		private boolean ar;
		private boolean vivo;
		private JLabelCoche sans;
		private Thread mov;
		
		
		public VentanaJuego() {
			
			ar = true;
			vivo = false;
			
			Container cp = this.getContentPane();
			
			az = new JPanel();
			az.setPreferredSize(new Dimension(750,750));
			az.setBackground(Color.black);
			za = new JPanel(new GridLayout(1,4));
			za.setPreferredSize(new Dimension(100,50));
			ac = new JButton("ac");
			pa = new JButton("pa");
			izk = new JButton("izk");
			der = new JButton("der");
			
			sans = new JLabelCoche();
			sans.setBackground(Color.black);
			sans.setIcon(new ImageIcon(VentanaJuego.class.getResource("coche.png"))); //new ImageIcon("C:\\Users\\iger\\Music\\coche.png")
			sans.setPreferredSize(new Dimension (200,200));
			az.add(sans);
			
			
			za.add(ac);
			za.add(pa);
			za.add(izk);
			za.add(der);
			
			
			cp.add(az, BorderLayout.NORTH);
			cp.add(za,BorderLayout.SOUTH);
			
			this.setResizable(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setTitle("Coche");
			this.pack();;
			this.setVisible(true);
			
			
			mov = new Thread () {    //hilo que actualiza el sprite
				
				public void run() {
					while(ar=true) {
						
						
						
						
				sans.setLocation((int) lul.getPosx(),(int) lul.getPosy());
				sans.setRot(lul.getDir());
					}
				}
				
			};
				
				
		
			
			Thread par = new Thread () {  //hilo de acelerar y parar

				public void run() {


					
					double velu= 1;
				
					while(ar==true) {
						
						if (lul.getPosx()>=700 || lul.getPosx()<=0 ) {
							System.out.println("AHORA");
							double dir = (180-lul.getDir());
							if (dir<0) {
								
								dir=dir+360;
							}
							lul.setDir(dir);
							
							
							}
						
						if (lul.getPosy()<=0 || lul.getPosy()>=600) {
							System.out.println("AHORA");
							System.out.println(lul.getDir());
							double dir = (360-lul.getDir());
							System.out.println(dir);
							lul.setDir(dir);
							
							
							
						
						}
						
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();

						}
						if (vivo==false) {
							
							if(velu>=0) {
								velu= velu-0.5;
								if(velu<0) {
								velu=0;
							}
								lul.setVel(velu);
							}
						}else {
							
							
							if(velu<12) {
								velu= velu+0.5;
								if(velu>12) {
									velu=12;
								}
							lul.setVel(velu);
							
							}
							
						}
						
						lul.setPosx(lul.getPosx()+lul.getVel()*Math.cos(lul.getDir()*(Math.PI/180)));
						lul.setPosy(lul.getPosy()+lul.getVel()*Math.sin(lul.getDir()*(Math.PI/180)));
						System.out.println(lul);
						System.out.println(lul.getDir());

						
					
					}

				}

			};
			
			ac.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					vivo=true;
					if(!par.isAlive()) {
					par.start();
					
					}
				}
			});
			
			pa.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					vivo=false;
						if(!par.isAlive()) {
						par.start();
						
						}
				}
			});
			
			izk.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					lul.setDir(lul.getDir()-10);
				}
			});
			
			der.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					lul.setDir(lul.getDir()+10);
				}
			});
			
		}
		
		
		
		
		
		
		
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			
			
			
			
	SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					VentanaJuego o = new VentanaJuego();
					o.lul = new Coche();
					o.lul.setPosx(150);
					o.lul.setPosy(100);
					o.lul.setPil("Avalon");
					o.mov.start();
					System.out.println(o.lul);
				}
			});
			
			
		}
}
