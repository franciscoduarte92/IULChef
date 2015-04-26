/**********************************************************************
* Filename: Pedido.java
* Created: 2015/04/24
* @author Hugo e Francisco
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;

public class Pedido implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Pedido
	***********************************************************/
	public static Set<Pedido> allInstances()
	{
		return Database.allInstances(Pedido.class);
	}
	
	private Produto produto;
	private Fatura fatura;
	private Boolean devolvido;
	private Integer quantidade;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public Pedido()
	{
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param produto the produto to initialize
	* @param fatura the fatura to initialize
	* @param devolvido the devolvido to initialize
	* @param quantidade the quantidade to initialize
	**********************************************************************/
	public Pedido(Produto produto, Fatura fatura, Boolean devolvido, Integer quantidade)
	{
		assert produto != null;
		assert fatura != null;
		
		this.produto = produto;
		this.fatura = fatura;
		this.devolvido = devolvido;
		this.quantidade = quantidade;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* ONE2MANY getter for Pedido[*] <-> Produto[1]
	* @return the produto of the pedido
	**********************************************************************/
	public Produto produto()
	{
		return produto;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Pedido[*] <-> Produto[1]
	* @param produto the produto to set
	**********************************************************************/
	public void setProduto(Produto produto)
	{
		this.produto = produto;
	}
	
	/**********************************************************************
	* ONE2MANY getter for Pedido[*] <-> Fatura[1]
	* @return the fatura of the pedido
	**********************************************************************/
	public Fatura fatura()
	{
		return fatura;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Pedido[*] <-> Fatura[1]
	* @param fatura the fatura to set
	**********************************************************************/
	public void setFatura(Fatura fatura)
	{
		this.fatura = fatura;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the devolvido of the pedido
	**********************************************************************/
	public Boolean devolvido()
	{
		return devolvido;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param devolvido the devolvido to set
	**********************************************************************/
	public void setDevolvido(Boolean devolvido)
	{
		this.devolvido = devolvido;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the quantidade of the pedido
	**********************************************************************/
	public Integer quantidade()
	{
		return quantidade;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param quantidade the quantidade to set
	**********************************************************************/
	public void setQuantidade(Integer quantidade)
	{
		this.quantidade = quantidade;
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param quantidade the quantidade to set
	**********************************************************************/
	public void init(Integer quantidade)
	{
		//	self.quantidade := quantidade; self.devolvido := false
		this.quantidade=quantidade;
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
	}
	
	/**********************************************************************
	* @param other Pedido to compare to the current one
	* @return 0 if the argument is equal to the current Pedido;
	* a value less than 0 if the argument is greater than the current Pedido;
	* and a value greater than 0 if the argument is less than this Pedido.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Pedido;
		
		//	TODO: uncomment the option that is best suitable
		//	return this.devolvido.compareTo(((Pedido) other).devolvido);
		//	return this.quantidade.compareTo(((Pedido) other).quantidade);
		return this.hashCode() - ((Pedido) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Pedido to check equality to the current one
	* @return true if the argument is equal to the current Pedido and false otherwise
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
		
		final Pedido another = (Pedido) other;
		if (!super.equals(another))
			return false;
		if ((this.devolvido == null) ? (another.devolvido != null) : !this.devolvido.equals(another.devolvido))
			return false;
		if ((this.quantidade == null) ? (another.quantidade != null) : !this.quantidade.equals(another.quantidade))
			return false;
		
		return true;
	}
	
	/**********************************************************************
	* Object serializer
	**********************************************************************/
	@Override
	public String toString()
	{
		return "Pedido[devolvido="+devolvido() + ", quantidade="+quantidade() + ", fatura(" + (fatura()==null?"0":"1")+ "), produto(" + (produto()==null?"0":"1")+ ")]";
	}
	
}
