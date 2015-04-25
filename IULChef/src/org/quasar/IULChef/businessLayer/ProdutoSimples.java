/**********************************************************************
* Filename: ProdutoSimples.java
* Created: 2015/04/25
* @author Francisco Duarte & Hugo CHaves
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;
import java.util.HashSet;

public class ProdutoSimples extends Produto implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class ProdutoSimples
	***********************************************************/
	public static Set<Produto> allInstances()
	{
		return Database.allInstances(ProdutoSimples.class);
	}
	
	private Integer codigoBarras;
	private FamiliaProdutoSimples familia;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public ProdutoSimples()
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
	* @param codigoBarras the codigoBarras to initialize
	* @param familia the familia to initialize
	**********************************************************************/
	public ProdutoSimples(Set<Restaurante> restaurantes, String nome, Double precoVenda, Integer quantidade, TipoProduto tipo, Unidade unidade, Integer codigoBarras, FamiliaProdutoSimples familia)
	{
		super(restaurantes, nome, precoVenda, quantidade, tipo, unidade);
		this.codigoBarras = codigoBarras;
		this.familia = familia;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the codigoBarras of the produtoSimples
	**********************************************************************/
	public Integer codigoBarras()
	{
		return codigoBarras;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param codigoBarras the codigoBarras to set
	**********************************************************************/
	public void setCodigoBarras(Integer codigoBarras)
	{
		this.codigoBarras = codigoBarras;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the familia of the produtoSimples
	**********************************************************************/
	public FamiliaProdutoSimples familia()
	{
		return familia;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param familia the familia to set
	**********************************************************************/
	public void setFamilia(FamiliaProdutoSimples familia)
	{
		this.familia = familia;
	}
	
	/**********************************************************************
	* ONE2MANY getter for ProdutoSimples[1] <-> Contagem[*]
	* @return the contagens of the produtoSimples
	**********************************************************************/
	public Set<Contagem> contagens()
	{
		Set<Contagem> result = new HashSet<Contagem>();
		for (Contagem x : Contagem.allInstances())
			if (x.produtoSimples()  ==  this)
				result.add(x);
		return result;
	}
	
	/**********************************************************************
	* ONE2MANY multiple setter for ProdutoSimples[1] <-> Contagem[*]
	* @param contagens the contagens to set
	**********************************************************************/
	public void setContagens(Set<Contagem> contagens)
	{
		for (Contagem x : contagens)
			x.setProdutoSimples(this);
	}
	
	/**********************************************************************
	* ONE2MANY single setter for ProdutoSimples[1] <-> Contagem[*]
	* @param contagem the contagem to add
	**********************************************************************/
	public void addContagens(Contagem contagem)
	{
		contagem.setProdutoSimples(this);
	}
	
	/**********************************************************************
	* ONE2MANY single remover for ProdutoSimples[1] <-> Contagem[*]
	* @param contagem the contagem to remove
	**********************************************************************/
	public void removeContagens(Contagem contagem)
	{
		contagem.setProdutoSimples(null);
	}
	
	/**********************************************************************
	* ONE2MANY getter for ProdutoSimples[1] <-> Compra[*]
	* @return the compras of the produtoSimples
	**********************************************************************/
	public Set<Compra> compras()
	{
		Set<Compra> result = new HashSet<Compra>();
		for (Compra x : Compra.allInstances())
			if (x.produtoSimples()  ==  this)
				result.add(x);
		return result;
	}
	
	/**********************************************************************
	* ONE2MANY multiple setter for ProdutoSimples[1] <-> Compra[*]
	* @param compras the compras to set
	**********************************************************************/
	public void setCompras(Set<Compra> compras)
	{
		for (Compra x : compras)
			x.setProdutoSimples(this);
	}
	
	/**********************************************************************
	* ONE2MANY single setter for ProdutoSimples[1] <-> Compra[*]
	* @param compra the compra to add
	**********************************************************************/
	public void addCompras(Compra compra)
	{
		compra.setProdutoSimples(this);
	}
	
	/**********************************************************************
	* ONE2MANY single remover for ProdutoSimples[1] <-> Compra[*]
	* @param compra the compra to remove
	**********************************************************************/
	public void removeCompras(Compra compra)
	{
		compra.setProdutoSimples(null);
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkTemQueTerPeloMenosUmProduto();
		checkNaoPodeHaverMaisQue20Quebras();
		checkNaoPodeHaverMaisQue300produtos();
		checkCodigoBarrasMinDigitos();
		checkFamiliaDeveSerPreenchida();
		checkCodigoBarrasMaxDigitos();
		checkCodigoBarrasDeveSerUnico();
	}
	
	public void checkTemQueTerPeloMenosUmProduto()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	(ProdutoSimples.allInstances->collect($elem20 : ProdutoSimples | $elem20.contagens->collect($e : Contagem | $e.existencias))->asSequence->first >= 1)
		boolean invariant = true;
		
		assert invariant : "Tem que existir pelo menos uma produto!";
	}
	
	public void checkNaoPodeHaverMaisQue20Quebras()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	(ProdutoSimples.allInstances->collect($elem19 : ProdutoSimples | $elem19.contagens->collect($e : Contagem | $e.quebras))->asSequence->last < 20)
		boolean invariant = true;
		
		assert invariant : " O valor das quebras tem de ser =< 20";
	}
	
	public void checkNaoPodeHaverMaisQue300produtos()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	(ProdutoSimples.allInstances->collect($elem18 : ProdutoSimples | $elem18.contagens->collect($e : Contagem | $e.existencias))->asSequence->last < 300)
		boolean invariant = true;
		
		assert invariant : " O valor das existencias tem de ser <300";
	}
	
	public void checkCodigoBarrasMinDigitos()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	(ProdutoSimples.allInstances->collect($elem16 : ProdutoSimples | $elem16.codigoBarras)->min >= 0)
		boolean invariant = true;
		
		assert invariant : "O valor minimo do codigo de barras tem que ter 9 digitos";
	}
	
	public void checkFamiliaDeveSerPreenchida()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.familia.isDefined
		boolean invariant = true;
		
		assert invariant : "A familia do produto simples deve ser preenchida!";
	}
	
	public void checkCodigoBarrasMaxDigitos()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	(ProdutoSimples.allInstances->collect($elem17 : ProdutoSimples | $elem17.codigoBarras)->max <= 999999999)
		boolean invariant = true;
		
		assert invariant : "O valor maximo do codigo de barras tem que ter 9 digitos";
	}
	
	public void checkCodigoBarrasDeveSerUnico()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	ProdutoSimples.allInstances->select($elem14 : ProdutoSimples | $elem14.codigoBarras.isDefined)->isUnique($elem15 : ProdutoSimples | $elem15.codigoBarras)
		boolean invariant = true;
		
		assert invariant : "O código de barras do produto deve ser único!";
	}
	
	/**********************************************************************
	* @param other ProdutoSimples to compare to the current one
	* @return 0 if the argument is equal to the current ProdutoSimples;
	* a value less than 0 if the argument is greater than the current ProdutoSimples;
	* and a value greater than 0 if the argument is less than this ProdutoSimples.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof ProdutoSimples;
		
		//	TODO: uncomment the option that is best suitable
		//	return this.codigoBarras.compareTo(((ProdutoSimples) other).codigoBarras);
		//	return this.familia.compareTo(((ProdutoSimples) other).familia);
		//	return this.nome.compareTo(((ProdutoSimples) other).nome);
		//	return this.precoVenda.compareTo(((ProdutoSimples) other).precoVenda);
		//	return this.quantidade.compareTo(((ProdutoSimples) other).quantidade);
		//	return this.tipo.compareTo(((ProdutoSimples) other).tipo);
		//	return this.unidade.compareTo(((ProdutoSimples) other).unidade);
		return this.hashCode() - ((ProdutoSimples) other).hashCode();
	}
	
	/**********************************************************************
	* @param other ProdutoSimples to check equality to the current one
	* @return true if the argument is equal to the current ProdutoSimples and false otherwise
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
		
		final ProdutoSimples another = (ProdutoSimples) other;
		if (!super.equals(another))
			return false;
		if ((this.codigoBarras == null) ? (another.codigoBarras != null) : !this.codigoBarras.equals(another.codigoBarras))
			return false;
		if ((this.familia == null) ? (another.familia != null) : !this.familia.equals(another.familia))
			return false;
		
		return true;
	}
	
	/**********************************************************************
	* Object serializer
	**********************************************************************/
	@Override
	public String toString()
	{
		return "ProdutoSimples[codigoBarras="+codigoBarras() + ", familia="+familia() + ", nome="+nome() + ", precoVenda="+precoVenda() + ", quantidade="+quantidade() + ", tipo="+tipo() + ", unidade="+unidade() + ", composicao(" + (composicao()==null?"0":"1")+ "), compras(" + compras().size() + "), confecionados(" + confecionados().size() + "), contagens(" + contagens().size() + "), pedidos(" + pedidos().size() + "), restaurantes(" + restaurantes().size() + ")]";
	}
	
}
