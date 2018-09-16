package ejerciciosProglll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;


/** Ejercicio de hilos con ventanas. Programa esta clase para que se cree una ventana
 * que pida un dato de texto al usuario y un botón de confirmar para que se confirme.
 * Haz que al pulsar el botón de confirmación se llame al procesoConfirmar()
 * que simula un proceso de almacenamiento externo que tarda unos segundos.
 * Observa que hasta que ocurre esta confirmación la ventana no responde.
 * 1. Arréglalo para que la ventana no se quede "frita" hasta que se acabe de confirmar.
 * 2. Haz que el botón de "confirmar" no se pueda pulsar dos veces mientras el proceso
 * de confirmación se esté realizando
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class VentanaConfirmacionLenta extends JFrame{
	
	private JPanel az;
	private JPanel za;
	private JButton ac;
	private JTextField tex;
	
	private boolean hola2;
	
	private static Random r = new Random();
	// Este método simula un proceso que tarda un tiempo en hacerse (entre 5 y 10 segundos)
	private static void procesoConfirmar() {
		
		try {
			Thread.sleep( 5000 + 1000*r.nextInt(6) );
		} catch (InterruptedException e) {}
		
		
	}
	
	public VentanaConfirmacionLenta() {
		
		Container cp = this.getContentPane();
		
		
		az = new JPanel(new GridLayout(1,2));
		az.setPreferredSize(new Dimension(200,90));
		az.setBackground(Color.white);
		za = new JPanel(new GridLayout(1,4));
		za.setPreferredSize(new Dimension(100,50));
		ac = new JButton("Confirmar");
		
		az.add(new JLabel("Introduce texto:"));
		tex = new JTextField();
		tex.setPreferredSize(new Dimension(100,80));
		JPanel lb = new JPanel();
		lb.add(tex,BorderLayout.CENTER);
		lb.setBackground(Color.white);
		az.add(lb);
		
		za.add(ac);
		
		
		
		ac.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				Thread holi = new Thread (new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
							
							
							ac.setEnabled(false);
							tex.setEnabled(false);
							procesoConfirmar();
							hola2 = false;
							ac.setEnabled(true);
							tex.setEnabled(true);
							System.out.println(tex.getText()); //se deshabilita el textfield para no poder cambiar el texto mientras "esperas"  
							
							
							
							
						
						
					}
				});
				
					
				holi.start();
				
				
				hola2=true;
			}
		});
		
		
		
		
		
		
		cp.add(az, BorderLayout.NORTH);
		cp.add(za,BorderLayout.SOUTH);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Ventana Confirmacion Lenta");
		this.pack();;
		this.setVisible(true);
		
		
	}

		
	public static void main(String[] args) {
		
		// TODO Desarrollar la clase de acuerdo a los comentarios de la cabecera
		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaConfirmacionLenta();
				
			}
		});
		
		
		
		
	}

}