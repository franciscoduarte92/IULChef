package org.quasar.IULChef.presentationLayer;

import org.quasar.IULChef.persistenceLayer.Database;

public class Main_IULChef_GUI {

	public static void main(String[] args) {
			Database.open("C:/Users/Francisco/Documents/GitHub/IULChef/IULChef/database", "IULChef", "db4o");
			
			new IULChef_Login();
	}
}
