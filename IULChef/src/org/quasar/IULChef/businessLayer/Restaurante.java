/**********************************************************************
 * Filename: Restaurante.java
 * Created: 2015/04/24
 * @author Hugo e Francisco
 **********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.HashSet;

public class Restaurante extends Entidade implements Comparable<Object> {

	/***********************************************************
	 * @return all instances of class Restaurante
	 ***********************************************************/
	public static Set<Entidade> allInstances() {
		return Database.allInstances(Restaurante.class);
	}

	/**********************************************************************
	 * Default constructor
	 **********************************************************************/
	public Restaurante() {
		super();
	}

	/**********************************************************************
	 * Parameterized constructor
	 * 
	 * @param morada
	 *            the morada to initialize (inherited)
	 * @param nc
	 *            the nc to initialize (inherited)
	 * @param nome
	 *            the nome to initialize (inherited)
	 **********************************************************************/
	public Restaurante(String morada, Integer nc, String nome) {
		super(morada, nc, nome);

		check();

		Database.insert(this);
	}

	/**********************************************************************
	 * ONE2MANY getter for Restaurante[1] <-> Compra[*]
	 * 
	 * @return the compras of the restaurante
	 **********************************************************************/
	public Set<Compra> compras() {
		Set<Compra> result = new HashSet<Compra>();
		for (Compra x : Compra.allInstances())
			if (x.restaurante() == this)
				result.add(x);
		return result;
	}

	/**********************************************************************
	 * ONE2MANY multiple setter for Restaurante[1] <-> Compra[*]
	 * 
	 * @param compras
	 *            the compras to set
	 **********************************************************************/
	public void setCompras(Set<Compra> compras) {
		for (Compra x : compras)
			x.setRestaurante(this);
	}

	/**********************************************************************
	 * ONE2MANY single setter for Restaurante[1] <-> Compra[*]
	 * 
	 * @param compra
	 *            the compra to add
	 **********************************************************************/
	public void addCompras(Compra compra) {
		compra.setRestaurante(this);
	}

	/**********************************************************************
	 * ONE2MANY single remover for Restaurante[1] <-> Compra[*]
	 * 
	 * @param compra
	 *            the compra to remove
	 **********************************************************************/
	public void removeCompras(Compra compra) {
		compra.setRestaurante(null);
	}

	/**********************************************************************
	 * ONE2MANY getter for Restaurante[1] <-> Mesa[*] ordered
	 * 
	 * @return the mesas of the restaurante
	 **********************************************************************/
	public SortedSet<Mesa> mesas() {
		SortedSet<Mesa> result = new TreeSet<Mesa>();
		for (Mesa x : Mesa.allInstances())
			if (x.restaurante() == this)
				result.add(x);
		return result;
	}

	/**********************************************************************
	 * ONE2MANY multiple setter for Restaurante[1] <-> Mesa[*] ordered
	 * 
	 * @param mesas
	 *            the mesas to set
	 **********************************************************************/
	public void setMesas(SortedSet<Mesa> mesas) {
		for (Mesa x : mesas)
			x.setRestaurante(this);
	}

	/**********************************************************************
	 * ONE2MANY single setter for Restaurante[1] <-> Mesa[*] ordered
	 * 
	 * @param mesa
	 *            the mesa to add
	 **********************************************************************/
	public void addMesas(Mesa mesa) {
		mesa.setRestaurante(this);
	}

	/**********************************************************************
	 * ONE2MANY single remover for Restaurante[1] <-> Mesa[*] ordered
	 * 
	 * @param mesa
	 *            the mesa to remove
	 **********************************************************************/
	public void removeMesas(Mesa mesa) {
		mesa.setRestaurante(null);
	}

	/**********************************************************************
	 * ONE2MANY getter for Restaurante[1] <-> Inventario[*]
	 * 
	 * @return the inventarios of the restaurante
	 **********************************************************************/
	public Set<Inventario> inventarios() {
		Set<Inventario> result = new HashSet<Inventario>();
		for (Inventario x : Inventario.allInstances())
			if (x.restaurante() == this)
				result.add(x);
		return result;
	}

	/**********************************************************************
	 * ONE2MANY multiple setter for Restaurante[1] <-> Inventario[*]
	 * 
	 * @param inventarios
	 *            the inventarios to set
	 **********************************************************************/
	public void setInventarios(Set<Inventario> inventarios) {
		for (Inventario x : inventarios)
			x.setRestaurante(this);
	}

	/**********************************************************************
	 * ONE2MANY single setter for Restaurante[1] <-> Inventario[*]
	 * 
	 * @param inventario
	 *            the inventario to add
	 **********************************************************************/
	public void addInventarios(Inventario inventario) {
		inventario.setRestaurante(this);
	}

	/**********************************************************************
	 * ONE2MANY single remover for Restaurante[1] <-> Inventario[*]
	 * 
	 * @param inventario
	 *            the inventario to remove
	 **********************************************************************/
	public void removeInventarios(Inventario inventario) {
		inventario.setRestaurante(null);
	}

	/**********************************************************************
	 * MEMBER2ASSOCIATIVE getter for Restaurante[1..*] <-> Contrato[1..*]
	 * 
	 * @return the contrato of the empregadores
	 **********************************************************************/
	public Set<Contrato> contrato() {
		Set<Contrato> result = new HashSet<Contrato>();
		for (Contrato x : Contrato.allInstances())
			if (x.empregadores() == this)
				result.add(x);
		return result;
	}

	/**********************************************************************
	 * MEMBER2ASSOCIATIVE setter for Restaurante[1..*] <-> Contrato[1..*]
	 * 
	 * @param contrato
	 *            the contrato to set
	 **********************************************************************/
	public void setContrato(Set<Contrato> contrato) {
		for (Contrato x : contrato)
			x.setEmpregadores(this);
	}

	/**********************************************************************
	 * MEMBER2MEMBER getter for Restaurante[1..*] <-> Empregado[1..*]
	 * 
	 * @return the contratados of the empregadores
	 **********************************************************************/
	public Set<Empregado> contratados() {
		Set<Empregado> result = new HashSet<Empregado>();
		for (Contrato x : Contrato.allInstances())
			if (x.empregadores() == this && x.contratados() != null)
				result.add(x.contratados());
		return result;
	}

	/**********************************************************************
	 * MEMBER2MEMBER setter for Restaurante[1..*] <-> Empregado[1..*]
	 * 
	 * @param contratados
	 *            the contratados to set
	 **********************************************************************/
	public void setContratados(Set<Empregado> contratados) {
		for (Empregado t : contratados)
			for (Contrato x : Contrato.allInstances())
				if (x.empregadores() == this)
					x.setContratados(t);
	}

	/**********************************************************************
	 * MANY2MANY getter for Restaurante[*] <-> Produto[*]
	 * 
	 * @return the produtos of the restaurantes
	 **********************************************************************/
	public Set<Produto> produtos() {
		Set<Produto> result = new HashSet<Produto>();
		for (Produto x : Produto.allInstances())
			if (x.restaurantes() != null && x.restaurantes().contains(this))
				result.add(x);
		return result;
	}

	/**********************************************************************
	 * MANY2MANY multiple setter for Restaurante[*] <-> Produto[*]
	 * 
	 * @param produtos
	 *            the produtos to set
	 **********************************************************************/
	public void setProdutos(Set<Produto> produtos) {
		for (Produto x : produtos)
			x.restaurantes().add(this);
	}

	/**********************************************************************
	 * MANY2MANY single setter for Restaurante[*] <-> Produto[*]
	 * 
	 * @param produto
	 *            the produto to add
	 **********************************************************************/
	public void addProdutos(Produto produto) {
		produto.addRestaurantes(this);
	}

	/**********************************************************************
	 * MANY2MANY single setter for Restaurante[*] <-> Produto[*]
	 * 
	 * @param produto
	 *            the produto to remove
	 **********************************************************************/
	public void removeProdutos(Produto produto) {
		produto.removeRestaurantes(this);
	}

	/**********************************************************************
	 * ONE2MANY getter for Restaurante[1] <-> Fatura[*]
	 * 
	 * @return the faturas of the restaurante
	 **********************************************************************/
	public Set<Fatura> faturas() {
		Set<Fatura> result = new HashSet<Fatura>();
		for (Fatura x : Fatura.allInstances())
			if (x.restaurante() == this)
				result.add(x);
		return result;
	}

	/**********************************************************************
	 * ONE2MANY multiple setter for Restaurante[1] <-> Fatura[*]
	 * 
	 * @param faturas
	 *            the faturas to set
	 **********************************************************************/
	public void setFaturas(Set<Fatura> faturas) {
		for (Fatura x : faturas)
			x.setRestaurante(this);
	}

	/**********************************************************************
	 * ONE2MANY single setter for Restaurante[1] <-> Fatura[*]
	 * 
	 * @param fatura
	 *            the fatura to add
	 **********************************************************************/
	public void addFaturas(Fatura fatura) {
		fatura.setRestaurante(this);
	}

	/**********************************************************************
	 * ONE2MANY single remover for Restaurante[1] <-> Fatura[*]
	 * 
	 * @param fatura
	 *            the fatura to remove
	 **********************************************************************/
	public void removeFaturas(Fatura fatura) {
		fatura.setRestaurante(null);
	}

	/**********************************************************************
	 * INVARIANT CHECKERS
	 **********************************************************************/
	public void check() {
		checkRestauranteTemPeloMenosUmEmpregado();
		checkNumeroMesaDeveSerUnico();
		checkDataInventarioDeveSerUnica();
		checkRestauranteTemVariosProdutos();
		checkRestauranteTemPeloMenosUmFornecedor();
	}

	public void checkRestauranteTemPeloMenosUmEmpregado() {
		// (Restaurante.allInstances->collect($e : Restaurante |
		// $e.contratados)->collect($elem11 : Empregado |
		// $elem11.contrato)->size > 1)
		boolean invariant = contratados().size() > 1;

		assert invariant : "Um restaurante tem de ter pelo menos um empregado";
	}

	public void checkNumeroMesaDeveSerUnico() {
		// self.mesas->isUnique($elem8 : Mesa | $elem8.numero)
		int count = 0;
		for (Mesa m : mesas()) {
			for (Mesa m2 : mesas()) {
				if (m.equals(m2))
					count++;
			}
		}
		boolean invariant = count < 2;

		assert invariant : "Um restaurante não pode ter mais do que uma mesa com o mesmo número!";
	}

	public void checkDataInventarioDeveSerUnica() {
		// self.inventarios->isUnique($elem9 : Inventario | $elem9.data)
		int count = 0;
		for (Inventario i : inventarios()) {
			for (Inventario i2 : inventarios()) {
				if (i.equals(i2))
					count++;
			}
		}
		boolean invariant = count < 2;

		assert invariant : "Um restaurante não pode ter mais do que um inventário com a mesma data!";
	}

	public void checkRestauranteTemVariosProdutos() {
		// (self.produtos->asSequence->size > 1)
		boolean invariant = produtos().size() > 1;

		assert invariant : "O restaurante tem mais que um produto!";
	}

	public void checkRestauranteTemPeloMenosUmFornecedor() {
		// (Restaurante.allInstances->collect($e : Restaurante |
		// $e.compras)->collect($elem10 : Compra | $elem10.fornecedor)->size >
		// 1)
		boolean invariant = !compras().isEmpty();

		assert invariant : "Um restaurante tem de ter um fornecedor";
	}

	/**********************************************************************
	 * @param other
	 *            Restaurante to compare to the current one
	 * @return 0 if the argument is equal to the current Restaurante; a value
	 *         less than 0 if the argument is greater than the current
	 *         Restaurante; and a value greater than 0 if the argument is less
	 *         than this Restaurante.
	 **********************************************************************/
	@Override
	public int compareTo(Object other) {
		assert other instanceof Restaurante;

		// return this.morada.compareTo(((Restaurante) other).morada);
		return this.nc().compareTo(((Restaurante) other).nc());
		// return this.nome.compareTo(((Restaurante) other).nome);
		// return this.hashCode() - ((Restaurante) other).hashCode();
	}

	/**********************************************************************
	 * @param other
	 *            Restaurante to check equality to the current one
	 * @return true if the argument is equal to the current Restaurante and
	 *         false otherwise
	 **********************************************************************/
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;

		final Restaurante another = (Restaurante) other;
		if (!super.equals(another))
			return false;

		return true;
	}

	/**********************************************************************
	 * Object serializer
	 **********************************************************************/
	@Override
	public String toString() {
		return "Restaurante[morada=" + morada() + ", nc=" + nc() + ", nome="
				+ nome() + ", compras(" + compras().size() + "), contratados("
				+ contratados().size() + "), contrato(" + contrato().size()
				+ "), faturas(" + faturas().size() + "), inventarios("
				+ inventarios().size() + "), mesas(" + mesas().size()
				+ "), produtos(" + produtos().size() + ")]";
	}

}
