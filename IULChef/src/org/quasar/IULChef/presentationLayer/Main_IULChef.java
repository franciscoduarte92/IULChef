/**********************************************************************
 * Filename: Main_IULChef.java
 * Created: 2015/04/25
 * @author Francisco Duarte & Hugo CHaves
 **********************************************************************/
package org.quasar.IULChef.presentationLayer;

import org.quasar.IULChef.businessLayer.*;
import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Scanner;

public abstract class Main_IULChef {
	/***********************************************************
	 * @param args
	 ***********************************************************/
	public static void main(String[] args) {
		Database.open("database", "IULChef", "db4o");

		boolean over = false;

		do {
			Scanner in = new Scanner(System.in);

			displayMenu();

			int option = 0;
			try {
				if (in.hasNext()) {
					String answer = in.next();
					option = Integer.parseInt(answer);
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input!...\n");
				continue;
			}

			switch (option) {
			case 0:
				over = true;
				break;
			case 1:
				showResults(CalendarDate.class);
				break;
			case 2:
				showResults(Cliente.class);
				break;
			case 3:
				showResults(Composicao.class);
				break;
			case 4:
				showResults(Compra.class);
				break;
			case 5:
				showResults(Contagem.class);
				break;
			case 6:
				showResults(Contrato.class);
				break;
			case 7:
				showResults(Empregado.class);
				break;
			case 8:
				showResults(Entidade.class);
				break;
			case 9:
				showResults(Fatura.class);
				break;
			case 10:
				showResults(Fornecedor.class);
				break;
			case 11:
				showResults(Inventario.class);
				break;
			case 12:
				showResults(Mesa.class);
				break;
			case 13:
				showResults(Pedido.class);
				break;
			case 14:
				showResults(Produto.class);
				break;
			case 15:
				showResults(ProdutoComposto.class);
				break;
			case 16:
				showResults(ProdutoSimples.class);
				break;
			case 17:
				showResults(Restaurante.class);
				break;
			default:
				System.out.println("Invalid option!...\n");
				break;
			}
			in.close();
		} while (!over);

		Database.close();
	}

	/***********************************************************
	 * The main menu of the IULChef information system
	 ***********************************************************/
	public static void displayMenu() {
		System.out.println("------------------------------------");
		System.out.println("IULChef Information System");
		System.out.println("------------------------------------");
		System.out.println("0) EXIT");
		System.out.println("1) CalendarDate");
		System.out.println("2) Cliente");
		System.out.println("3) Composicao");
		System.out.println("4) Compra");
		System.out.println("5) Contagem");
		System.out.println("6) Contrato");
		System.out.println("7) Empregado");
		System.out.println("8) Entidade");
		System.out.println("9) Fatura");
		System.out.println("10) Fornecedor");
		System.out.println("11) Inventario");
		System.out.println("12) Mesa");
		System.out.println("13) Pedido");
		System.out.println("14) Produto");
		System.out.println("15) ProdutoComposto");
		System.out.println("16) ProdutoSimples");
		System.out.println("17) Restaurante");
		System.out.println();
		System.out.print("OPTION> ");
	}

	/***********************************************************
	 * @param c
	 *            the class whose instances we want to show
	 ***********************************************************/
	public static void showResults(Class<?> c) {
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------");
		System.out.println("| " + Database.allInstances(c).size()
				+ " instances of class " + c.getSimpleName());
		System.out
				.println("---------------------------------------------------------------------------------------------------------------------");
		for (Object o : Database.allInstances(c))
			System.out.println(o);
		System.out.println();
	}
}
