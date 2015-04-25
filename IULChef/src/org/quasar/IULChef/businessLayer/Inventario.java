/**********************************************************************
* Filename: Inventario.java
* Created: 2015/04/25
* @author Francisco Duarte & Hugo CHaves
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;
import java.util.HashSet;

public class Inventario implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Inventario
	***********************************************************/
	public static Set<Inventario> allInstances()
	{
		return Database.allInstances(Inventario.class);
	}
	
	private Restaurante restaurante;
	private CalendarDate data;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public Inventario()
	{
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param restaurante the restaurante to initialize
	* @param data the data to initialize
	**********************************************************************/
	public Inventario(Restaurante restaurante, CalendarDate data)
	{
		assert restaurante != null;
		
		this.restaurante = restaurante;
		this.data = data;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* ONE2MANY getter for Inventario[*] <-> Restaurante[1]
	* @return the restaurante of the inventario
	**********************************************************************/
	public Restaurante restaurante()
	{
		return restaurante;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Inventario[*] <-> Restaurante[1]
	* @param restaurante the restaurante to set
	**********************************************************************/
	public void setRestaurante(Restaurante restaurante)
	{
		this.restaurante = restaurante;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the data of the inventario
	**********************************************************************/
	public CalendarDate data()
	{
		return data;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param data the data to set
	**********************************************************************/
	public void setData(CalendarDate data)
	{
		this.data = data;
	}
	
	/**********************************************************************
	* ONE2MANY getter for Inventario[1] <-> Contagem[*]
	* @return the contagens of the inventario
	**********************************************************************/
	public Set<Contagem> contagens()
	{
		Set<Contagem> result = new HashSet<Contagem>();
		for (Contagem x : Contagem.allInstances())
			if (x.inventario()  ==  this)
				result.add(x);
		return result;
	}
	
	/**********************************************************************
	* ONE2MANY multiple setter for Inventario[1] <-> Contagem[*]
	* @param contagens the contagens to set
	**********************************************************************/
	public void setContagens(Set<Contagem> contagens)
	{
		for (Contagem x : contagens)
			x.setInventario(this);
	}
	
	/**********************************************************************
	* ONE2MANY single setter for Inventario[1] <-> Contagem[*]
	* @param contagem the contagem to add
	**********************************************************************/
	public void addContagens(Contagem contagem)
	{
		contagem.setInventario(this);
	}
	
	/**********************************************************************
	* ONE2MANY single remover for Inventario[1] <-> Contagem[*]
	* @param contagem the contagem to remove
	**********************************************************************/
	public void removeContagens(Contagem contagem)
	{
		contagem.setInventario(null);
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param data the data to set
	**********************************************************************/
	public void init(CalendarDate data)
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	self.data := data
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
	}
	
	/**********************************************************************
	* @param other Inventario to compare to the current one
	* @return 0 if the argument is equal to the current Inventario;
	* a value less than 0 if the argument is greater than the current Inventario;
	* and a value greater than 0 if the argument is less than this Inventario.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Inventario;
		
		//	TODO: uncomment the option that is best suitable
		//	return this.data.compareTo(((Inventario) other).data);
		return this.hashCode() - ((Inventario) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Inventario to check equality to the current one
	* @return true if the argument is equal to the current Inventario and false otherwise
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
		
		final Inventario another = (Inventario) other;
		if (!super.equals(another))
			return false;
		if ((this.data == null) ? (another.data != null) : !this.data.equals(another.data))
			return false;
		
		return true;
	}
	
	/**********************************************************************
	* Object serializer
	**********************************************************************/
	@Override
	public String toString()
	{
		return "Inventario[data="+data() + ", contagens(" + contagens().size() + "), restaurante(" + (restaurante()==null?"0":"1")+ ")]";
	}
	
}
