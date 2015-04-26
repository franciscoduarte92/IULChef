/**********************************************************************
* Filename: Entidade.java
* Created: 2015/04/24
* @author Hugo e Francisco
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;

public abstract class Entidade implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Entidade
	***********************************************************/
	public static Set<Entidade> allInstances()
	{
		return Database.allInstances(Entidade.class);
	}
	
	protected String morada;
	protected Integer nc;
	private String nome;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public Entidade()
	{
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param morada the morada to initialize
	* @param nc the nc to initialize
	* @param nome the nome to initialize
	**********************************************************************/
	public Entidade(String morada, Integer nc, String nome)
	{
		this.morada = morada;
		this.nc = nc;
		this.nome = nome;
		
		check();
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the morada of the entidade
	**********************************************************************/
	public String morada()
	{
		return morada;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param morada the morada to set
	**********************************************************************/
	public void setMorada(String morada)
	{
		this.morada = morada;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the nc of the entidade
	**********************************************************************/
	public Integer nc()
	{
		return nc;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param nc the nc to set
	**********************************************************************/
	public void setNc(Integer nc)
	{
		this.nc = nc;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the nome of the entidade
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
	* User-defined operation specified in SOIL/OCL
	* @param nome the nome to set
	* @param morada the morada to set
	* @param nc the nc to set
	**********************************************************************/
	public void init(String nome, String morada, Integer nc)
	{
		//	self.nome := nome; self.morada := morada; self.nc := nc
		this.nome=nome;
		this.morada=morada;
		this.nc=nc;
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkNCdeveSerUnico();
		checkNCDeveSerPreenchido();
		checkNomeDeveSerPreenchido();
		checkNCcomNoveDigitos();
	}
	
	public void checkNCdeveSerUnico()
	{
		//	Entidade.allInstances->isUnique($elem5 : Entidade | $elem5.nc)
		boolean invariant = allInstances().contains(this);
		
		assert invariant : "O número de contribuinte da entidade deve ser único!";
	}
	
	public void checkNCDeveSerPreenchido()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.nc.isDefined
		boolean invariant = true;
		
		assert invariant : "O número de contribuinte da entidade deve ser preenchido!";
	}
	
	public void checkNomeDeveSerPreenchido()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.nome.isDefined
		boolean invariant = true;
		
		assert invariant : "O nome da entidade deve ser preenchido!";
	}
	
	public void checkNCcomNoveDigitos()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	Entidade.allInstances->sortedBy($elem6 : Entidade | $elem6.nc)->forAll($elem7 : Entidade | (($elem7.oclAsType(Entidade).nc > 0) and ($elem7.oclAsType(Entidade).nc < 999999999)))
		boolean invariant = true;
		
		assert invariant : "O valor do numero de contribuinte tem ter 9 digitos";
	}
	
	/**********************************************************************
	* @param other Entidade to compare to the current one
	* @return 0 if the argument is equal to the current Entidade;
	* a value less than 0 if the argument is greater than the current Entidade;
	* and a value greater than 0 if the argument is less than this Entidade.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Entidade;
		
		//	TODO: uncomment the option that is best suitable
		//	return this.morada.compareTo(((Entidade) other).morada);
		//	return this.nc.compareTo(((Entidade) other).nc);
		//	return this.nome.compareTo(((Entidade) other).nome);
		return this.hashCode() - ((Entidade) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Entidade to check equality to the current one
	* @return true if the argument is equal to the current Entidade and false otherwise
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
		
		final Entidade another = (Entidade) other;
		if ((this.morada == null) ? (another.morada != null) : !this.morada.equals(another.morada))
			return false;
		if ((this.nc == null) ? (another.nc != null) : !this.nc.equals(another.nc))
			return false;
		if ((this.nome == null) ? (another.nome != null) : !this.nome.equals(another.nome))
			return false;
		
		return true;
	}
	
	/**********************************************************************
	* Object serializer
	**********************************************************************/
	@Override
	public String toString()
	{
		return "Entidade[morada="+morada() + ", nc="+nc() + ", nome="+nome() + "]";
	}
	
}
