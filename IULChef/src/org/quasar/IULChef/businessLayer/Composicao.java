/**********************************************************************
* Filename: Composicao.java
* Created: 2015/04/24
* @author Hugo e Francisco
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;

public class Composicao implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Composicao
	***********************************************************/
	public static Set<Composicao> allInstances()
	{
		return Database.allInstances(Composicao.class);
	}
	
	private ProdutoComposto confecionados;
	private Produto ingredientes;
	private Double quantidade;
	
	/**********************************************************************
	* Associative constructor
	* @param confecionados the confecionados to initialize
	* @param ingredientes the ingredientes to initialize
	**********************************************************************/
	public Composicao(ProdutoComposto confecionados, Produto ingredientes)
	{
		assert confecionados != null;
		assert ingredientes != null;
		
		this.confecionados = confecionados;
		this.ingredientes = ingredientes;
		
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param confecionados the confecionados to initialize
	* @param ingredientes the ingredientes to initialize
	* @param quantidade the quantidade to initialize
	**********************************************************************/
	public Composicao(ProdutoComposto confecionados, Produto ingredientes, Double quantidade)
	{
		assert confecionados != null;
		assert ingredientes != null;
		
		this.confecionados = confecionados;
		this.ingredientes = ingredientes;
		this.quantidade = quantidade;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* ASSOCIATIVE2MEMBER getter for Composicao[*] <-> ProdutoComposto[1]
	* @return the confecionados of the composicao
	**********************************************************************/
	public ProdutoComposto confecionados()
	{
		return confecionados;
	}
	
	/**********************************************************************
	* ASSOCIATIVE2MEMBER setter for Composicao[*] <-> ProdutoComposto[1]
	* @param confecionados the confecionados to set
	**********************************************************************/
	public void setConfecionados(ProdutoComposto confecionados)
	{
		this.confecionados = confecionados;
	}
	
	/**********************************************************************
	* ASSOCIATIVE2MEMBER getter for Composicao[*] <-> Produto[1]
	* @return the ingredientes of the composicao
	**********************************************************************/
	public Produto ingredientes()
	{
		return ingredientes;
	}
	
	/**********************************************************************
	* ASSOCIATIVE2MEMBER setter for Composicao[*] <-> Produto[1]
	* @param ingredientes the ingredientes to set
	**********************************************************************/
	public void setIngredientes(Produto ingredientes)
	{
		this.ingredientes = ingredientes;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the quantidade of the composicao
	**********************************************************************/
	public Double quantidade()
	{
		return quantidade;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param quantidade the quantidade to set
	**********************************************************************/
	public void setQuantidade(Double quantidade)
	{
		this.quantidade = quantidade;
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkQuantidadeDeveSerPreenchida();
	}
	
	public void checkQuantidadeDeveSerPreenchida()
	{
		//	self.quantidade.isDefined
		boolean invariant = quantidade!=null;
		
		assert invariant : "A quantidade do ingrediente na composição do produto composto deve ser preenchida!";
	}
	
	/**********************************************************************
	* @param other Composicao to compare to the current one
	* @return 0 if the argument is equal to the current Composicao;
	* a value less than 0 if the argument is greater than the current Composicao;
	* and a value greater than 0 if the argument is less than this Composicao.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Composicao;
		
		//	return this.quantidade.compareTo(((Composicao) other).quantidade);
		return this.hashCode() - ((Composicao) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Composicao to check equality to the current one
	* @return true if the argument is equal to the current Composicao and false otherwise
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
		
		final Composicao another = (Composicao) other;
		if (!super.equals(another))
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
		return "Composicao[quantidade="+quantidade() + ", confecionados(" + (confecionados()==null?"0":"1")+ "), ingredientes(" + (ingredientes()==null?"0":"1")+ ")]";
	}
	
}
