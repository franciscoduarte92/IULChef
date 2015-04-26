/**********************************************************************
* Filename: Mesa.java
* Created: 2015/04/24
* @author Hugo e Francisco
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;
import java.util.HashSet;

public class Mesa implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Mesa
	***********************************************************/
	public static Set<Mesa> allInstances()
	{
		return Database.allInstances(Mesa.class);
	}
	
	private Restaurante restaurante;
	private Integer numero;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public Mesa()
	{
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param restaurante the restaurante to initialize
	* @param numero the numero to initialize
	**********************************************************************/
	public Mesa(Restaurante restaurante, Integer numero)
	{
		assert restaurante != null;
		
		this.restaurante = restaurante;
		this.numero = numero;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* ONE2MANY getter for Mesa[*] <-> Restaurante[1]
	* @return the restaurante of the mesa
	**********************************************************************/
	public Restaurante restaurante()
	{
		return restaurante;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Mesa[*] <-> Restaurante[1]
	* @param restaurante the restaurante to set
	**********************************************************************/
	public void setRestaurante(Restaurante restaurante)
	{
		this.restaurante = restaurante;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the numero of the mesa
	**********************************************************************/
	public Integer numero()
	{
		return numero;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param numero the numero to set
	**********************************************************************/
	public void setNumero(Integer numero)
	{
		this.numero = numero;
	}
	
	/**********************************************************************
	* ONE2MANY getter for Mesa[1] <-> Fatura[*]
	* @return the faturas of the mesa
	**********************************************************************/
	public Set<Fatura> faturas()
	{
		Set<Fatura> result = new HashSet<Fatura>();
		for (Fatura x : Fatura.allInstances())
			if (x.mesa()  ==  this)
				result.add(x);
		return result;
	}
	
	/**********************************************************************
	* ONE2MANY multiple setter for Mesa[1] <-> Fatura[*]
	* @param faturas the faturas to set
	**********************************************************************/
	public void setFaturas(Set<Fatura> faturas)
	{
		for (Fatura x : faturas)
			x.setMesa(this);
	}
	
	/**********************************************************************
	* ONE2MANY single setter for Mesa[1] <-> Fatura[*]
	* @param fatura the fatura to add
	**********************************************************************/
	public void addFaturas(Fatura fatura)
	{
		fatura.setMesa(this);
	}
	
	/**********************************************************************
	* ONE2MANY single remover for Mesa[1] <-> Fatura[*]
	* @param fatura the fatura to remove
	**********************************************************************/
	public void removeFaturas(Fatura fatura)
	{
		fatura.setMesa(null);
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkMesaTemUmEmpregado();
		checkNumeroMesaFixo();
		checkNumeroDeveSerPreenchido();
	}
	
	public void checkMesaTemUmEmpregado()
	{
		//	(self.restaurante.contratados->asSet->size >= 1)
		boolean invariant = restaurante.contratados().size()>=1;
		
		assert invariant : "Uma mesa tem apenas um empregado";
	}
	
	public void checkNumeroMesaFixo()
	{
		//	if (Mesa.allInstances->size <= 4) then true else false endif
		boolean invariant = allInstances().size()<=4;
		
		assert invariant : "O restaurante tem apenas quatro mesas.";
	}
	
	public void checkNumeroDeveSerPreenchido()
	{
		//	self.numero.isDefined
		boolean invariant = numero!=null;
		
		assert invariant : "O número de mesa deve ser preenchido!";
	}
	
	/**********************************************************************
	* @param other Mesa to compare to the current one
	* @return 0 if the argument is equal to the current Mesa;
	* a value less than 0 if the argument is greater than the current Mesa;
	* and a value greater than 0 if the argument is less than this Mesa.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Mesa;
		
			return this.numero.compareTo(((Mesa) other).numero);
//		return this.hashCode() - ((Mesa) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Mesa to check equality to the current one
	* @return true if the argument is equal to the current Mesa and false otherwise
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
		
		final Mesa another = (Mesa) other;
		if (!super.equals(another))
			return false;
		if ((this.numero == null) ? (another.numero != null) : !this.numero.equals(another.numero))
			return false;
		
		return true;
	}
	
	/**********************************************************************
	* Object serializer
	**********************************************************************/
	@Override
	public String toString()
	{
		return "Mesa[numero="+numero() + ", faturas(" + faturas().size() + "), restaurante(" + (restaurante()==null?"0":"1")+ ")]";
	}
	
}
