/**********************************************************************
* Filename: Compra.java
* Created: 2015/04/24
* @author Hugo e Francisco
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;

public class Compra implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Compra
	***********************************************************/
	public static Set<Compra> allInstances()
	{
		return Database.allInstances(Compra.class);
	}
	
	private Restaurante restaurante;
	private Fornecedor fornecedor;
	private ProdutoSimples produtoSimples;
	private CalendarDate data;
	private Double precoAquisicao;
	private Integer quantidade;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public Compra()
	{
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param restaurante the restaurante to initialize
	* @param fornecedor the fornecedor to initialize
	* @param produtoSimples the produtoSimples to initialize
	* @param data the data to initialize
	* @param precoAquisicao the precoAquisicao to initialize
	* @param quantidade the quantidade to initialize
	**********************************************************************/
	public Compra(Restaurante restaurante, Fornecedor fornecedor, ProdutoSimples produtoSimples, CalendarDate data, Double precoAquisicao, Integer quantidade)
	{
		assert restaurante != null;
		assert fornecedor != null;
		assert produtoSimples != null;
		
		this.restaurante = restaurante;
		this.fornecedor = fornecedor;
		this.produtoSimples = produtoSimples;
		this.data = data;
		this.precoAquisicao = precoAquisicao;
		this.quantidade = quantidade;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* ONE2MANY getter for Compra[*] <-> Restaurante[1]
	* @return the restaurante of the compra
	**********************************************************************/
	public Restaurante restaurante()
	{
		return restaurante;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Compra[*] <-> Restaurante[1]
	* @param restaurante the restaurante to set
	**********************************************************************/
	public void setRestaurante(Restaurante restaurante)
	{
		this.restaurante = restaurante;
	}
	
	/**********************************************************************
	* ONE2MANY getter for Compra[*] <-> Fornecedor[1]
	* @return the fornecedor of the compra
	**********************************************************************/
	public Fornecedor fornecedor()
	{
		return fornecedor;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Compra[*] <-> Fornecedor[1]
	* @param fornecedor the fornecedor to set
	**********************************************************************/
	public void setFornecedor(Fornecedor fornecedor)
	{
		this.fornecedor = fornecedor;
	}
	
	/**********************************************************************
	* ONE2MANY getter for Compra[*] <-> ProdutoSimples[1]
	* @return the produtoSimples of the compra
	**********************************************************************/
	public ProdutoSimples produtoSimples()
	{
		return produtoSimples;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Compra[*] <-> ProdutoSimples[1]
	* @param produtoSimples the produtoSimples to set
	**********************************************************************/
	public void setProdutoSimples(ProdutoSimples produtoSimples)
	{
		this.produtoSimples = produtoSimples;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the data of the compra
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
	* Standard attribute getter
	* @return the precoAquisicao of the compra
	**********************************************************************/
	public Double precoAquisicao()
	{
		return precoAquisicao;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param precoAquisicao the precoAquisicao to set
	**********************************************************************/
	public void setPrecoAquisicao(Double precoAquisicao)
	{
		this.precoAquisicao = precoAquisicao;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the quantidade of the compra
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
	* @param precoAquisicao the precoAquisicao to set
	* @param data the data to set
	**********************************************************************/
	public void init(Integer quantidade, Double precoAquisicao, CalendarDate data)
	{
		//	self.quantidade := quantidade; self.precoAquisicao := precoAquisicao; self.data := data
		this.quantidade = quantidade;
		this.precoAquisicao = precoAquisicao;
		this.data = data;
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkDataDeveSerPreenchida();
	}
	
	public void checkDataDeveSerPreenchida()
	{
		//	self.data.isDefined
		boolean invariant = data != null;
		
		assert invariant : "A data da compra deve ser preenchida!";
	}
	
	/**********************************************************************
	* @param other Compra to compare to the current one
	* @return 0 if the argument is equal to the current Compra;
	* a value less than 0 if the argument is greater than the current Compra;
	* and a value greater than 0 if the argument is less than this Compra.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Compra;
		
		//	return this.data.compareTo(((Compra) other).data);
		//	return this.precoAquisicao.compareTo(((Compra) other).precoAquisicao);
		//	return this.quantidade.compareTo(((Compra) other).quantidade);
		return this.hashCode() - ((Compra) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Compra to check equality to the current one
	* @return true if the argument is equal to the current Compra and false otherwise
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
		
		final Compra another = (Compra) other;
		if (!super.equals(another))
			return false;
		if ((this.data == null) ? (another.data != null) : !this.data.equals(another.data))
			return false;
		if ((this.precoAquisicao == null) ? (another.precoAquisicao != null) : !this.precoAquisicao.equals(another.precoAquisicao))
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
		return "Compra[data="+data() + ", precoAquisicao="+precoAquisicao() + ", quantidade="+quantidade() + ", fornecedor(" + (fornecedor()==null?"0":"1")+ "), produtoSimples(" + (produtoSimples()==null?"0":"1")+ "), restaurante(" + (restaurante()==null?"0":"1")+ ")]";
	}
	
}
