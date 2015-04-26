/**********************************************************************
* Filename: Cliente.java
* Created: 2015/04/24
* @author Hugo e Francisco
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;
import java.util.HashSet;

public class Cliente extends Entidade implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Cliente
	***********************************************************/
	public static Set<Entidade> allInstances()
	{
		return Database.allInstances(Cliente.class);
	}
	
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public Cliente()
	{
		super();
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param morada the morada to initialize (inherited)
	* @param nc the nc to initialize (inherited)
	* @param nome the nome to initialize (inherited)
	**********************************************************************/
	public Cliente(String morada, Integer nc, String nome)
	{
		super(morada, nc, nome);
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* ONE2MANY getter for Cliente[0..1] <-> Fatura[*]
	* @return the faturas of the cliente
	**********************************************************************/
	public Set<Fatura> faturas()
	{
		Set<Fatura> result = new HashSet<Fatura>();
		for (Fatura x : Fatura.allInstances())
			if (x.cliente()  ==  this)
				result.add(x);
		return result;
	}
	
	/**********************************************************************
	* ONE2MANY multiple setter for Cliente[0..1] <-> Fatura[*]
	* @param faturas the faturas to set
	**********************************************************************/
	public void setFaturas(Set<Fatura> faturas)
	{
		for (Fatura x : faturas)
			x.setCliente(this);
	}
	
	/**********************************************************************
	* ONE2MANY single setter for Cliente[0..1] <-> Fatura[*]
	* @param fatura the fatura to add
	**********************************************************************/
	public void addFaturas(Fatura fatura)
	{
		fatura.setCliente(this);
	}
	
	/**********************************************************************
	* ONE2MANY single remover for Cliente[0..1] <-> Fatura[*]
	* @param fatura the fatura to remove
	**********************************************************************/
	public void removeFaturas(Fatura fatura)
	{
		fatura.setCliente(null);
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkClienteTemUmaFaturaEmesa();
	}
	
	public void checkClienteTemUmaFaturaEmesa()
	{
		//	self.faturas->collect($e : Fatura | $e.mesa)->isUnique(m : Mesa | Tuple {numero:m.numero})
		boolean invariant = false;
		for (Fatura el : faturas()) {
			if(el.mesa()!=null)
				invariant=true;
		}
		
		
		
		assert invariant : "O cliente tem uma fatura associada a uma e so uma mesa!";
	}
	
	/**********************************************************************
	* @param other Cliente to compare to the current one
	* @return 0 if the argument is equal to the current Cliente;
	* a value less than 0 if the argument is greater than the current Cliente;
	* and a value greater than 0 if the argument is less than this Cliente.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Cliente;
		
		//	return this.morada.compareTo(((Cliente) other).morada);
			return this.nc.compareTo(((Cliente) other).nc);
		//	return this.nome.compareTo(((Cliente) other).nome);
//		return this.hashCode() - ((Cliente) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Cliente to check equality to the current one
	* @return true if the argument is equal to the current Cliente and false otherwise
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
		
		final Cliente another = (Cliente) other;
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
		return "Cliente[morada="+morada() + ", nc="+nc() + ", nome="+nome() + ", faturas(" + faturas().size() + ")]";
	}
	
}
