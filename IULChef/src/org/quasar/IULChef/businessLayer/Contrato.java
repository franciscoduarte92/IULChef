/**********************************************************************
* Filename: Contrato.java
* Created: 2015/04/24
* @author Hugo e Francisco
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;

public class Contrato implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Contrato
	***********************************************************/
	public static Set<Contrato> allInstances()
	{
		return Database.allInstances(Contrato.class);
	}
	
	private Restaurante empregadores;
	private Empregado contratados;
	private CalendarDate fim;
	private CalendarDate inicio;
	private Double vencimento;
	
	/**********************************************************************
	* Associative constructor
	* @param empregadores the empregadores to initialize
	* @param contratados the contratados to initialize
	**********************************************************************/
	public Contrato(Restaurante empregadores, Empregado contratados)
	{
		assert empregadores != null;
		assert contratados != null;
		
		this.empregadores = empregadores;
		this.contratados = contratados;
		
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param empregadores the empregadores to initialize
	* @param contratados the contratados to initialize
	* @param fim the fim to initialize
	* @param inicio the inicio to initialize
	* @param vencimento the vencimento to initialize
	**********************************************************************/
	public Contrato(Restaurante empregadores, Empregado contratados, CalendarDate fim, CalendarDate inicio, Double vencimento)
	{
		assert empregadores != null;
		assert contratados != null;
		
		this.empregadores = empregadores;
		this.contratados = contratados;
		this.fim = fim;
		this.inicio = inicio;
		this.vencimento = vencimento;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* ASSOCIATIVE2MEMBER getter for Contrato[*] <-> Restaurante[1]
	* @return the empregadores of the contrato
	**********************************************************************/
	public Restaurante empregadores()
	{
		return empregadores;
	}
	
	/**********************************************************************
	* ASSOCIATIVE2MEMBER setter for Contrato[*] <-> Restaurante[1]
	* @param empregadores the empregadores to set
	**********************************************************************/
	public void setEmpregadores(Restaurante empregadores)
	{
		this.empregadores = empregadores;
	}
	
	/**********************************************************************
	* ASSOCIATIVE2MEMBER getter for Contrato[*] <-> Empregado[1]
	* @return the contratados of the contrato
	**********************************************************************/
	public Empregado contratados()
	{
		return contratados;
	}
	
	/**********************************************************************
	* ASSOCIATIVE2MEMBER setter for Contrato[*] <-> Empregado[1]
	* @param contratados the contratados to set
	**********************************************************************/
	public void setContratados(Empregado contratados)
	{
		this.contratados = contratados;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the fim of the contrato
	**********************************************************************/
	public CalendarDate fim()
	{
		return fim;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param fim the fim to set
	**********************************************************************/
	public void setFim(CalendarDate fim)
	{
		this.fim = fim;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the inicio of the contrato
	**********************************************************************/
	public CalendarDate inicio()
	{
		return inicio;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param inicio the inicio to set
	**********************************************************************/
	public void setInicio(CalendarDate inicio)
	{
		this.inicio = inicio;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the vencimento of the contrato
	**********************************************************************/
	public Double vencimento()
	{
		return vencimento;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param vencimento the vencimento to set
	**********************************************************************/
	public void setVencimento(Double vencimento)
	{
		this.vencimento = vencimento;
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkDataFimDeveSerPreenchida();
		checkVencimentoDeveSerPreenchido();
		checkDataInicioDeveSerPreenchida();
	}
	
	public void checkDataFimDeveSerPreenchida()
	{
		//	self.fim.isDefined
		boolean invariant = fim != null;
		
		assert invariant : "A data de fim do contrato deve ser preenchida!";
	}
	
	public void checkVencimentoDeveSerPreenchido()
	{
		//	self.vencimento.isDefined
		boolean invariant = vencimento != null;
		
		assert invariant : "O vencimento a pagar mensalmente ao empregado no âmbito do contrato deve ser preenchido!";
	}
	
	public void checkDataInicioDeveSerPreenchida()
	{
		//	self.inicio.isDefined
		boolean invariant = inicio != null;
		
		assert invariant : "A data de início do contrato deve ser preenchida!";
	}
	
	/**********************************************************************
	* @param other Contrato to compare to the current one
	* @return 0 if the argument is equal to the current Contrato;
	* a value less than 0 if the argument is greater than the current Contrato;
	* and a value greater than 0 if the argument is less than this Contrato.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Contrato;
		
		//	return this.fim.compareTo(((Contrato) other).fim);
		//	return this.inicio.compareTo(((Contrato) other).inicio);
		//	return this.vencimento.compareTo(((Contrato) other).vencimento);
		return this.hashCode() - ((Contrato) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Contrato to check equality to the current one
	* @return true if the argument is equal to the current Contrato and false otherwise
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
		
		final Contrato another = (Contrato) other;
		if (!super.equals(another))
			return false;
		if ((this.fim == null) ? (another.fim != null) : !this.fim.equals(another.fim))
			return false;
		if ((this.inicio == null) ? (another.inicio != null) : !this.inicio.equals(another.inicio))
			return false;
		if ((this.vencimento == null) ? (another.vencimento != null) : !this.vencimento.equals(another.vencimento))
			return false;
		
		return true;
	}
	
	/**********************************************************************
	* Object serializer
	**********************************************************************/
	@Override
	public String toString()
	{
		return "Contrato[fim="+fim() + ", inicio="+inicio() + ", vencimento="+vencimento() + ", contratados(" + (contratados()==null?"0":"1")+ "), empregadores(" + (empregadores()==null?"0":"1")+ ")]";
	}
	
}
