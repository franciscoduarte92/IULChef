/**********************************************************************
* Filename: Contagem.java
* Created: 2015/04/24
* @author Hugo e Francisco
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;

public class Contagem implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Contagem
	***********************************************************/
	public static Set<Contagem> allInstances()
	{
		return Database.allInstances(Contagem.class);
	}
	
	private ProdutoSimples produtoSimples;
	private Inventario inventario;
	private Integer existencias;
	private Integer quebras;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public Contagem()
	{
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param produtoSimples the produtoSimples to initialize
	* @param inventario the inventario to initialize
	* @param existencias the existencias to initialize
	* @param quebras the quebras to initialize
	**********************************************************************/
	public Contagem(ProdutoSimples produtoSimples, Inventario inventario, Integer existencias, Integer quebras)
	{
		assert produtoSimples != null;
		assert inventario != null;
		
		this.produtoSimples = produtoSimples;
		this.inventario = inventario;
		this.existencias = existencias;
		this.quebras = quebras;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* ONE2MANY getter for Contagem[*] <-> ProdutoSimples[1]
	* @return the produtoSimples of the contagem
	**********************************************************************/
	public ProdutoSimples produtoSimples()
	{
		return produtoSimples;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Contagem[*] <-> ProdutoSimples[1]
	* @param produtoSimples the produtoSimples to set
	**********************************************************************/
	public void setProdutoSimples(ProdutoSimples produtoSimples)
	{
		this.produtoSimples = produtoSimples;
	}
	
	/**********************************************************************
	* ONE2MANY getter for Contagem[*] <-> Inventario[1]
	* @return the inventario of the contagem
	**********************************************************************/
	public Inventario inventario()
	{
		return inventario;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Contagem[*] <-> Inventario[1]
	* @param inventario the inventario to set
	**********************************************************************/
	public void setInventario(Inventario inventario)
	{
		this.inventario = inventario;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the existencias of the contagem
	**********************************************************************/
	public Integer existencias()
	{
		return existencias;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param existencias the existencias to set
	**********************************************************************/
	public void setExistencias(Integer existencias)
	{
		this.existencias = existencias;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the quebras of the contagem
	**********************************************************************/
	public Integer quebras()
	{
		return quebras;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param quebras the quebras to set
	**********************************************************************/
	public void setQuebras(Integer quebras)
	{
		this.quebras = quebras;
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkExistenciasTeemDeSerPreenchidas();
	}
	
	public void checkExistenciasTeemDeSerPreenchidas()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.existencias.isDefined
		boolean invariant = true;
		
		assert invariant : "Todas as existencias teem que ser preenchidas na contagem";
	}
	
	/**********************************************************************
	* @param other Contagem to compare to the current one
	* @return 0 if the argument is equal to the current Contagem;
	* a value less than 0 if the argument is greater than the current Contagem;
	* and a value greater than 0 if the argument is less than this Contagem.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Contagem;
		
		//	TODO: uncomment the option that is best suitable
		//	return this.existencias.compareTo(((Contagem) other).existencias);
		//	return this.quebras.compareTo(((Contagem) other).quebras);
		return this.hashCode() - ((Contagem) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Contagem to check equality to the current one
	* @return true if the argument is equal to the current Contagem and false otherwise
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
		
		final Contagem another = (Contagem) other;
		if (!super.equals(another))
			return false;
		if ((this.existencias == null) ? (another.existencias != null) : !this.existencias.equals(another.existencias))
			return false;
		if ((this.quebras == null) ? (another.quebras != null) : !this.quebras.equals(another.quebras))
			return false;
		
		return true;
	}
	
	/**********************************************************************
	* Object serializer
	**********************************************************************/
	@Override
	public String toString()
	{
		return "Contagem[existencias="+existencias() + ", quebras="+quebras() + ", inventario(" + (inventario()==null?"0":"1")+ "), produtoSimples(" + (produtoSimples()==null?"0":"1")+ ")]";
	}
	
}
