/**********************************************************************
* Filename: Produto.java
* Created: 2015/04/24
* @author Hugo e Francisco
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;
import java.util.HashSet;

public abstract class Produto implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Produto
	***********************************************************/
	public static Set<Produto> allInstances()
	{
		return Database.allInstances(Produto.class);
	}
	
	private Set<Restaurante> restaurantes =  new HashSet<Restaurante>();
	private String nome;
	private Double precoVenda;
	private Integer quantidade;
	private TipoProduto tipo;
	private Unidade unidade;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public Produto()
	{
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param restaurantes the restaurantes to initialize
	* @param nome the nome to initialize
	* @param precoVenda the precoVenda to initialize
	* @param quantidade the quantidade to initialize
	* @param tipo the tipo to initialize
	* @param unidade the unidade to initialize
	**********************************************************************/
	public Produto(Set<Restaurante> restaurantes, String nome, Double precoVenda, Integer quantidade, TipoProduto tipo, Unidade unidade)
	{
		this.restaurantes = restaurantes;
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.unidade = unidade;
		
		check();
	}
	
	/**********************************************************************
	* MANY2MANY getter for Produto[*] <-> Set(Restaurante)[*]
	* @return the restaurantes of the produto
	**********************************************************************/
	public Set<Restaurante> restaurantes()
	{
		return restaurantes;
	}
	
	/**********************************************************************
	* MANY2MANY setter for Produto[*] <-> Set(Restaurante)[*]
	* @param restaurantes the restaurantes to set
	**********************************************************************/
	public void setRestaurantes(Set<Restaurante> restaurantes)
	{
		this.restaurantes = restaurantes;
	}
	
	/**********************************************************************
	* MANY2MANY single setter for Produto[*] <-> Set(Restaurante)[*]
	* @param restaurante the restaurante to add
	**********************************************************************/
	public void addRestaurantes(Restaurante restaurante)
	{
		this.restaurantes.add(restaurante);
	}
	
	/**********************************************************************
	* MANY2MANY single remover for Produto[*] <-> Set(Restaurante)[*]
	* @param restaurante the restaurante to remove
	**********************************************************************/
	public void removeRestaurantes(Restaurante restaurante)
	{
		this.restaurantes.remove(restaurante);
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the nome of the produto
	**********************************************************************/
	public String nome()
	{
		return nome;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param nome the nome to set
	**********************************************************************/
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the precoVenda of the produto
	**********************************************************************/
	public Double precoVenda()
	{
		return precoVenda;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param precoVenda the precoVenda to set
	**********************************************************************/
	public void setPrecoVenda(Double precoVenda)
	{
		this.precoVenda = precoVenda;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the quantidade of the produto
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
	* Standard attribute getter
	* @return the tipo of the produto
	**********************************************************************/
	public TipoProduto tipo()
	{
		return tipo;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param tipo the tipo to set
	**********************************************************************/
	public void setTipo(TipoProduto tipo)
	{
		this.tipo = tipo;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the unidade of the produto
	**********************************************************************/
	public Unidade unidade()
	{
		return unidade;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param unidade the unidade to set
	**********************************************************************/
	public void setUnidade(Unidade unidade)
	{
		this.unidade = unidade;
	}
	
	/**********************************************************************
	* MEMBER2ASSOCIATIVE getter for Produto[*] <-> Composicao[*]
	* @return the composicao of the ingredientes
	**********************************************************************/
	public Set<Composicao> composicao()
	{
		Set<Composicao> result = new HashSet<Composicao>();
		for (Composicao x : Composicao.allInstances())
			if (x.ingredientes() == this)
				result.add(x);
		return result;
	}
	
	/**********************************************************************
	* MEMBER2ASSOCIATIVE setter for Produto[*] <-> Composicao[*]
	* @param composicao the composicao to set
	**********************************************************************/
	public void setComposicao(Set<Composicao> composicao)
	{
		for (Composicao x : composicao)
			x.setIngredientes(this);
	}
	
	/**********************************************************************
	* MEMBER2MEMBER getter for Produto[*] <-> ProdutoComposto[*]
	* @return the confecionados of the ingredientes
	**********************************************************************/
	public Set<ProdutoComposto> confecionados()
	{
		Set<ProdutoComposto> result = new HashSet<ProdutoComposto>();
		for (Composicao x : Composicao.allInstances())
			if (x.ingredientes() == this && x.confecionados() != null)
				result.add(x.confecionados());
		return result;
	}
	
	/**********************************************************************
	* MEMBER2MEMBER setter for Produto[*] <-> ProdutoComposto[*]
	* @param confecionados the confecionados to set
	**********************************************************************/
	public void setConfecionados(Set<ProdutoComposto> confecionados)
	{
		for (ProdutoComposto t : confecionados)
			for (Composicao x : Composicao.allInstances())
				if (x.ingredientes() == this)
					x.setConfecionados(t);
	}
	
	/**********************************************************************
	* ONE2MANY getter for Produto[1] <-> Pedido[*]
	* @return the pedidos of the produto
	**********************************************************************/
	public Set<Pedido> pedidos()
	{
		Set<Pedido> result = new HashSet<Pedido>();
		for (Pedido x : Pedido.allInstances())
			if (x.produto()  ==  this)
				result.add(x);
		return result;
	}
	
	/**********************************************************************
	* ONE2MANY multiple setter for Produto[1] <-> Pedido[*]
	* @param pedidos the pedidos to set
	**********************************************************************/
	public void setPedidos(Set<Pedido> pedidos)
	{
		for (Pedido x : pedidos)
			x.setProduto(this);
	}
	
	/**********************************************************************
	* ONE2MANY single setter for Produto[1] <-> Pedido[*]
	* @param pedido the pedido to add
	**********************************************************************/
	public void addPedidos(Pedido pedido)
	{
		pedido.setProduto(this);
	}
	
	/**********************************************************************
	* ONE2MANY single remover for Produto[1] <-> Pedido[*]
	* @param pedido the pedido to remove
	**********************************************************************/
	public void removePedidos(Pedido pedido)
	{
		pedido.setProduto(null);
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param nome the nome to set
	* @param tipo the tipo to set
	* @param unidade the unidade to set
	* @param precoVenda the precoVenda to set
	* @param quantidade the quantidade to set
	**********************************************************************/
	public void init(String nome, TipoProduto tipo, Unidade unidade, Double precoVenda, Integer quantidade)
	{
		//	self.nome := nome; self.tipo := tipo; self.unidade := unidade; self.precoVenda := precoVenda; self.quantidade := quantidade
		this.nome = nome;
		this.tipo = tipo;
		this.unidade = unidade;
		this.precoVenda = precoVenda; 
		this.quantidade = quantidade;
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkTipoDeveSerPreenchido();
		checkUnidadeDeveSerPreenchida();
		checkPrecoDeveSerPreenchido();
		checkNomeDeveSerPreenchido();
	}
	
	public void checkTipoDeveSerPreenchido()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.tipo.isDefined
		boolean invariant = true;
		
		assert invariant : "O tipo de produto deve ser preenchido!";
	}
	
	public void checkUnidadeDeveSerPreenchida()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.unidade.isDefined
		boolean invariant = true;
		
		assert invariant : "A unidade do produto deve ser preenchida!";
	}
	
	public void checkPrecoDeveSerPreenchido()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.precoVenda.isDefined
		boolean invariant = true;
		
		assert invariant : "O preço de venda do produto deve ser preenchido!";
	}
	
	public void checkNomeDeveSerPreenchido()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.nome.isDefined
		boolean invariant = true;
		
		assert invariant : "O nome do produto deve ser preenchido!";
	}
	
	/**********************************************************************
	* @param other Produto to compare to the current one
	* @return 0 if the argument is equal to the current Produto;
	* a value less than 0 if the argument is greater than the current Produto;
	* and a value greater than 0 if the argument is less than this Produto.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Produto;
		
		//	TODO: uncomment the option that is best suitable
		//	return this.nome.compareTo(((Produto) other).nome);
		//	return this.precoVenda.compareTo(((Produto) other).precoVenda);
		//	return this.quantidade.compareTo(((Produto) other).quantidade);
		//	return this.tipo.compareTo(((Produto) other).tipo);
		//	return this.unidade.compareTo(((Produto) other).unidade);
		return this.hashCode() - ((Produto) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Produto to check equality to the current one
	* @return true if the argument is equal to the current Produto and false otherwise
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
		
		final Produto another = (Produto) other;
		if ((this.nome == null) ? (another.nome != null) : !this.nome.equals(another.nome))
			return false;
		if ((this.precoVenda == null) ? (another.precoVenda != null) : !this.precoVenda.equals(another.precoVenda))
			return false;
		if ((this.quantidade == null) ? (another.quantidade != null) : !this.quantidade.equals(another.quantidade))
			return false;
		if ((this.tipo == null) ? (another.tipo != null) : !this.tipo.equals(another.tipo))
			return false;
		if ((this.unidade == null) ? (another.unidade != null) : !this.unidade.equals(another.unidade))
			return false;
		
		return true;
	}
	
	/**********************************************************************
	* Object serializer
	**********************************************************************/
	@Override
	public String toString()
	{
		return "Produto[nome="+nome() + ", precoVenda="+precoVenda() + ", quantidade="+quantidade() + ", tipo="+tipo() + ", unidade="+unidade() + ", composicao(" + composicao().size() + "), confecionados(" + confecionados().size() + "), pedidos(" + pedidos().size() + "), restaurantes(" + restaurantes().size() + ")]";
	}
	
}
