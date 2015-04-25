/**********************************************************************
* Filename: ProdutoComposto.java
* Created: 2015/04/25
* @author Francisco Duarte & Hugo CHaves
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;
import java.util.HashSet;

public class ProdutoComposto extends Produto implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class ProdutoComposto
	***********************************************************/
	public static Set<Produto> allInstances()
	{
		return Database.allInstances(ProdutoComposto.class);
	}
	
	private GrupoProdutoComposto grupo;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public ProdutoComposto()
	{
		super();
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param restaurantes the restaurantes to initialize (inherited)
	* @param nome the nome to initialize (inherited)
	* @param precoVenda the precoVenda to initialize (inherited)
	* @param quantidade the quantidade to initialize (inherited)
	* @param tipo the tipo to initialize (inherited)
	* @param unidade the unidade to initialize (inherited)
	* @param grupo the grupo to initialize
	**********************************************************************/
	public ProdutoComposto(Set<Restaurante> restaurantes, String nome, Double precoVenda, Integer quantidade, TipoProduto tipo, Unidade unidade, GrupoProdutoComposto grupo)
	{
		super(restaurantes, nome, precoVenda, quantidade, tipo, unidade);
		this.grupo = grupo;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the grupo of the produtoComposto
	**********************************************************************/
	public GrupoProdutoComposto grupo()
	{
		return grupo;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param grupo the grupo to set
	**********************************************************************/
	public void setGrupo(GrupoProdutoComposto grupo)
	{
		this.grupo = grupo;
	}
	
	/**********************************************************************
	* MEMBER2ASSOCIATIVE getter for ProdutoComposto[*] <-> Composicao[*]
	* @return the composicao of the confecionados
	**********************************************************************/
	public Set<Composicao> composicao()
	{
		Set<Composicao> result = new HashSet<Composicao>();
		for (Composicao x : Composicao.allInstances())
			if (x.confecionados() == this)
				result.add(x);
		return result;
	}
	
	/**********************************************************************
	* MEMBER2ASSOCIATIVE setter for ProdutoComposto[*] <-> Composicao[*]
	* @param composicao the composicao to set
	**********************************************************************/
	public void setComposicao(Set<Composicao> composicao)
	{
		for (Composicao x : composicao)
			x.setConfecionados(this);
	}
	
	/**********************************************************************
	* MEMBER2MEMBER getter for ProdutoComposto[*] <-> Produto[*]
	* @return the ingredientes of the confecionados
	**********************************************************************/
	public Set<Produto> ingredientes()
	{
		Set<Produto> result = new HashSet<Produto>();
		for (Composicao x : Composicao.allInstances())
			if (x.confecionados() == this && x.ingredientes() != null)
				result.add(x.ingredientes());
		return result;
	}
	
	/**********************************************************************
	* MEMBER2MEMBER setter for ProdutoComposto[*] <-> Produto[*]
	* @param ingredientes the ingredientes to set
	**********************************************************************/
	public void setIngredientes(Set<Produto> ingredientes)
	{
		for (Produto t : ingredientes)
			for (Composicao x : Composicao.allInstances())
				if (x.confecionados() == this)
					x.setIngredientes(t);
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkProdutoCompostoTemNoMinimoTresIngredientes();
		checkGrupoDeveSerPreenchido();
		checkProdutoCompostoTemQueSerConfecionado();
	}
	
	public void checkProdutoCompostoTemNoMinimoTresIngredientes()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	(self.ingredientes->size >= 3)
		boolean invariant = true;
		
		assert invariant : "Um produto composto tem de ter no minimo tres ingredientes!";
	}
	
	public void checkGrupoDeveSerPreenchido()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.grupo.isDefined
		boolean invariant = true;
		
		assert invariant : "O grupo do produto composto deve ser preenchido!";
	}
	
	public void checkProdutoCompostoTemQueSerConfecionado()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	(self.confecionados->asSequence->size > 0)
		boolean invariant = true;
		
		assert invariant : "Um produto composto tem de ser confecionado";
	}
	
	/**********************************************************************
	* @param other ProdutoComposto to compare to the current one
	* @return 0 if the argument is equal to the current ProdutoComposto;
	* a value less than 0 if the argument is greater than the current ProdutoComposto;
	* and a value greater than 0 if the argument is less than this ProdutoComposto.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof ProdutoComposto;
		
		//	TODO: uncomment the option that is best suitable
		//	return this.grupo.compareTo(((ProdutoComposto) other).grupo);
		//	return this.nome.compareTo(((ProdutoComposto) other).nome);
		//	return this.precoVenda.compareTo(((ProdutoComposto) other).precoVenda);
		//	return this.quantidade.compareTo(((ProdutoComposto) other).quantidade);
		//	return this.tipo.compareTo(((ProdutoComposto) other).tipo);
		//	return this.unidade.compareTo(((ProdutoComposto) other).unidade);
		return this.hashCode() - ((ProdutoComposto) other).hashCode();
	}
	
	/**********************************************************************
	* @param other ProdutoComposto to check equality to the current one
	* @return true if the argument is equal to the current ProdutoComposto and false otherwise
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
		
		final ProdutoComposto another = (ProdutoComposto) other;
		if (!super.equals(another))
			return false;
		if ((this.grupo == null) ? (another.grupo != null) : !this.grupo.equals(another.grupo))
			return false;
		
		return true;
	}
	
	/**********************************************************************
	* Object serializer
	**********************************************************************/
	@Override
	public String toString()
	{
		return "ProdutoComposto[grupo="+grupo() + ", nome="+nome() + ", precoVenda="+precoVenda() + ", quantidade="+quantidade() + ", tipo="+tipo() + ", unidade="+unidade() + ", composicao(" + composicao().size() + "), confecionados(" + confecionados().size() + "), ingredientes(" + ingredientes().size() + "), pedidos(" + pedidos().size() + "), restaurantes(" + restaurantes().size() + ")]";
	}
	
}
