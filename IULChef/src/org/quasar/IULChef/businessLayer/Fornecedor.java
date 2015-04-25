/**********************************************************************
* Filename: Fornecedor.java
* Created: 2015/04/25
* @author Francisco Duarte & Hugo CHaves
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;
import java.util.HashSet;

public class Fornecedor extends Entidade implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Fornecedor
	***********************************************************/
	public static Set<Entidade> allInstances()
	{
		return Database.allInstances(Fornecedor.class);
	}
	
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public Fornecedor()
	{
		super();
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param morada the morada to initialize (inherited)
	* @param nc the nc to initialize (inherited)
	* @param nome the nome to initialize (inherited)
	**********************************************************************/
	public Fornecedor(String morada, Integer nc, String nome)
	{
		super(morada, nc, nome);
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* ONE2MANY getter for Fornecedor[1] <-> Compra[*]
	* @return the compras of the fornecedor
	**********************************************************************/
	public Set<Compra> compras()
	{
		Set<Compra> result = new HashSet<Compra>();
		for (Compra x : Compra.allInstances())
			if (x.fornecedor()  ==  this)
				result.add(x);
		return result;
	}
	
	/**********************************************************************
	* ONE2MANY multiple setter for Fornecedor[1] <-> Compra[*]
	* @param compras the compras to set
	**********************************************************************/
	public void setCompras(Set<Compra> compras)
	{
		for (Compra x : compras)
			x.setFornecedor(this);
	}
	
	/**********************************************************************
	* ONE2MANY single setter for Fornecedor[1] <-> Compra[*]
	* @param compra the compra to add
	**********************************************************************/
	public void addCompras(Compra compra)
	{
		compra.setFornecedor(this);
	}
	
	/**********************************************************************
	* ONE2MANY single remover for Fornecedor[1] <-> Compra[*]
	* @param compra the compra to remove
	**********************************************************************/
	public void removeCompras(Compra compra)
	{
		compra.setFornecedor(null);
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkMoradaFornecedorTemDeSerPreenchida();
	}
	
	public void checkMoradaFornecedorTemDeSerPreenchida()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.morada.isDefined
		boolean invariant = true;
		
		assert invariant : "A morada do fornecedor tem de ser sempre preenchida!";
	}
	
	/**********************************************************************
	* @param other Fornecedor to compare to the current one
	* @return 0 if the argument is equal to the current Fornecedor;
	* a value less than 0 if the argument is greater than the current Fornecedor;
	* and a value greater than 0 if the argument is less than this Fornecedor.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Fornecedor;
		
		//	TODO: uncomment the option that is best suitable
		//	return this.morada.compareTo(((Fornecedor) other).morada);
		//	return this.nc.compareTo(((Fornecedor) other).nc);
		//	return this.nome.compareTo(((Fornecedor) other).nome);
		return this.hashCode() - ((Fornecedor) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Fornecedor to check equality to the current one
	* @return true if the argument is equal to the current Fornecedor and false otherwise
	**********************************************************************/
	@Override
	public boolean equals(Object other)
	{
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;
		
		final Fornecedor another = (Fornecedor) other;
		if (!super.equals(another))
			return false;
		
		return true;
	}
	
	/**********************************************************************
	* Object serializer
	**********************************************************************/
	@Override
	public String toString()
	{
		return "Fornecedor[morada="+morada() + ", nc="+nc() + ", nome="+nome() + ", compras(" + compras().size() + ")]";
	}
	
}
