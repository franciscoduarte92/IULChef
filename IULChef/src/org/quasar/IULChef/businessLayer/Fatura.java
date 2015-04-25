/**********************************************************************
* Filename: Fatura.java
* Created: 2015/04/25
* @author Francisco Duarte & Hugo CHaves
**********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;
import java.util.HashSet;

public class Fatura implements Comparable<Object>
{
	
	/***********************************************************
	* @return all instances of class Fatura
	***********************************************************/
	public static Set<Fatura> allInstances()
	{
		return Database.allInstances(Fatura.class);
	}
	
	private Empregado empregado;
	private Cliente cliente;
	private Restaurante restaurante;
	private Mesa mesa;
	private CalendarDate data;
	private Integer numero;
	
	/**********************************************************************
	* Default constructor
	**********************************************************************/
	public Fatura()
	{
	}
	
	/**********************************************************************
	* Parameterized constructor
	* @param empregado the empregado to initialize
	* @param cliente the cliente to initialize
	* @param restaurante the restaurante to initialize
	* @param mesa the mesa to initialize
	* @param data the data to initialize
	* @param numero the numero to initialize
	**********************************************************************/
	public Fatura(Empregado empregado, Cliente cliente, Restaurante restaurante, Mesa mesa, CalendarDate data, Integer numero)
	{
		assert empregado != null;
		assert restaurante != null;
		assert mesa != null;
		
		this.empregado = empregado;
		this.cliente = cliente;
		this.restaurante = restaurante;
		this.mesa = mesa;
		this.data = data;
		this.numero = numero;
		
		check();
		
		Database.insert(this);
	}
	
	/**********************************************************************
	* ONE2MANY getter for Fatura[*] <-> Empregado[1]
	* @return the empregado of the fatura
	**********************************************************************/
	public Empregado empregado()
	{
		return empregado;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Fatura[*] <-> Empregado[1]
	* @param empregado the empregado to set
	**********************************************************************/
	public void setEmpregado(Empregado empregado)
	{
		this.empregado = empregado;
	}
	
	/**********************************************************************
	* ONE2MANY getter for Fatura[*] <-> Cliente[1]
	* @return the cliente of the fatura
	**********************************************************************/
	public Cliente cliente()
	{
		return cliente;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Fatura[*] <-> Cliente[1]
	* @param cliente the cliente to set
	**********************************************************************/
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
	
	/**********************************************************************
	* ONE2MANY getter for Fatura[*] <-> Restaurante[1]
	* @return the restaurante of the fatura
	**********************************************************************/
	public Restaurante restaurante()
	{
		return restaurante;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Fatura[*] <-> Restaurante[1]
	* @param restaurante the restaurante to set
	**********************************************************************/
	public void setRestaurante(Restaurante restaurante)
	{
		this.restaurante = restaurante;
	}
	
	/**********************************************************************
	* ONE2MANY getter for Fatura[*] <-> Mesa[1]
	* @return the mesa of the fatura
	**********************************************************************/
	public Mesa mesa()
	{
		return mesa;
	}
	
	/**********************************************************************
	* ONE2MANY setter for Fatura[*] <-> Mesa[1]
	* @param mesa the mesa to set
	**********************************************************************/
	public void setMesa(Mesa mesa)
	{
		this.mesa = mesa;
	}
	
	/**********************************************************************
	* Standard attribute getter
	* @return the data of the fatura
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
	* @return the numero of the fatura
	**********************************************************************/
	public Integer numero()
	{
		return numero;
	}
	
	/**********************************************************************
	* Standard attribute setter
	* @param numero the numero to set
	**********************************************************************/
	public void setNumero(Integer numero)
	{
		this.numero = numero;
	}
	
	/**********************************************************************
	* ONE2MANY getter for Fatura[1] <-> Pedido[1..*]
	* @return the pedidos of the fatura
	**********************************************************************/
	public Set<Pedido> pedidos()
	{
		Set<Pedido> result = new HashSet<Pedido>();
		for (Pedido x : Pedido.allInstances())
			if (x.fatura()  ==  this)
				result.add(x);
		return result;
	}
	
	/**********************************************************************
	* ONE2MANY multiple setter for Fatura[1] <-> Pedido[1..*]
	* @param pedidos the pedidos to set
	**********************************************************************/
	public void setPedidos(Set<Pedido> pedidos)
	{
		for (Pedido x : pedidos)
			x.setFatura(this);
	}
	
	/**********************************************************************
	* ONE2MANY single setter for Fatura[1] <-> Pedido[1..*]
	* @param pedido the pedido to add
	**********************************************************************/
	public void addPedidos(Pedido pedido)
	{
		pedido.setFatura(this);
	}
	
	/**********************************************************************
	* ONE2MANY single remover for Fatura[1] <-> Pedido[1..*]
	* @param pedido the pedido to remove
	**********************************************************************/
	public void removePedidos(Pedido pedido)
	{
		pedido.setFatura(null);
	}
	
	/**********************************************************************
	* User-defined operation specified in SOIL/OCL
	* @param numero the numero to set
	* @param data the data to set
	**********************************************************************/
	public void init(Integer numero, CalendarDate data)
	{
		//	TODO conclude the implementation for this SOIL specification:
		//	self.numero := numero; self.data := data
	}
	
	/**********************************************************************
	* INVARIANT CHECKERS
	**********************************************************************/
	public void check()
	{
		checkRestauranteNaoPodeTerMaisQue10ProdutosDevolvidos();
		checkNumeroDeveSerPreenchido();
		checkDataDeveSerPreenchida();
		checkCozinheirosNaoFaturam();
	}
	
	public void checkRestauranteNaoPodeTerMaisQue10ProdutosDevolvidos()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	(Pedido.allInstances->collect($e : Pedido | $e.devolvido)->count(true) < 100)
		boolean invariant = true;
		
		assert invariant : "No Restaurante nao se pode devolver mais que dez produtos";
	}
	
	public void checkNumeroDeveSerPreenchido()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.numero.isDefined
		boolean invariant = true;
		
		assert invariant : "O número de mesa deve ser preenchido!";
	}
	
	public void checkDataDeveSerPreenchida()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	self.data.isDefined
		boolean invariant = true;
		
		assert invariant : "A data da fatura deve ser preenchida!";
	}
	
	public void checkCozinheirosNaoFaturam()
	{
		//	TODO conclude the implementation of this OCL invariant:
		//	(self.empregado.tipo <> TipoEmpregado::Cozinheiro)
		boolean invariant = true;
		
		assert invariant : "Os cozinheiros não passam faturas!";
	}
	
	/**********************************************************************
	* @param other Fatura to compare to the current one
	* @return 0 if the argument is equal to the current Fatura;
	* a value less than 0 if the argument is greater than the current Fatura;
	* and a value greater than 0 if the argument is less than this Fatura.
	**********************************************************************/
	@Override
	public int compareTo(Object other)
	{
		assert other instanceof Fatura;
		
		//	TODO: uncomment the option that is best suitable
		//	return this.data.compareTo(((Fatura) other).data);
		//	return this.numero.compareTo(((Fatura) other).numero);
		return this.hashCode() - ((Fatura) other).hashCode();
	}
	
	/**********************************************************************
	* @param other Fatura to check equality to the current one
	* @return true if the argument is equal to the current Fatura and false otherwise
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
		
		final Fatura another = (Fatura) other;
		if (!super.equals(another))
			return false;
		if ((this.data == null) ? (another.data != null) : !this.data.equals(another.data))
			return false;
		if ((this.numero == null) ? (another.numero != null) : !this.numero.equals(another.numero))
			return false;
		
		return true;
	}
	
	/**********************************************************************
	* Object serializer
	**********************************************************************/
	@Override
	public String toString()
	{
		return "Fatura[data="+data() + ", numero="+numero() + ", cliente(" + (cliente()==null?"0":"1")+ "), empregado(" + (empregado()==null?"0":"1")+ "), mesa(" + (mesa()==null?"0":"1")+ "), pedidos(" + pedidos().size() + "), restaurante(" + (restaurante()==null?"0":"1")+ ")]";
	}
	
}
