package org.quasar.IULChef.presentationLayer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.quasar.IULChef.persistenceLayer.Database;

public class Main_IULChef_GUI {

	public static void main(String[] args) {
			Database.open("C:/Users/Francisco/Documents/GitHub/IULChef/IULChef/database", "IULChef", "db4o");
			
			IULChef_Login login = new IULChef_Login();
			login.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e){
					System.out.println("Desconectar BD");
	                Database.close();
	            }
			});
			
			login.setVisible(true);
	}
}
