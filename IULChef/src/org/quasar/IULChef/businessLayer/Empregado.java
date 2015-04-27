/**********************************************************************
 * Filename: Empregado.java
 * Created: 2015/04/24
 * @author Hugo e Francisco
 **********************************************************************/
package org.quasar.IULChef.businessLayer;

import org.quasar.IULChef.persistenceLayer.Database;

import java.util.Set;
import java.util.Queue;
import java.util.HashSet;

public class Empregado extends Entidade implements Comparable<Object> {

	/***********************************************************
	 * @return all instances of class Empregado
	 ***********************************************************/
	public static Set<Entidade> allInstances() {
		return Database.allInstances(Empregado.class);
	}

	private Integer idade;
	private TipoEmpregado tipo;

	/**********************************************************************
	 * Default constructor
	 **********************************************************************/
	public Empregado() {
		super();
	}

	/**********************************************************************
	 * Parameterized constructor
	 * 
	 * @param morada
	 *            the morada to initialize (inherited)
	 * @param nc
	 *            the nc to initialize (inherited)
	 * @param nome
	 *            the nome to initialize (inherited)
	 * @param idade
	 *            the idade to initialize
	 * @param tipo
	 *            the tipo to initialize
	 **********************************************************************/
	public Empregado(String morada, Integer nc, String nome, Integer idade,
			TipoEmpregado tipo) {
		super(morada, nc, nome);
		this.idade = idade;
		this.tipo = tipo;

		check();

		Database.insert(this);
	}

	/**********************************************************************
	 * Standard attribute getter
	 * 
	 * @return the idade of the empregado
	 **********************************************************************/
	public Integer idade() {
		return idade;
	}

	/**********************************************************************
	 * Standard attribute setter
	 * 
	 * @param idade
	 *            the idade to set
	 **********************************************************************/
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	/**********************************************************************
	 * Standard attribute getter
	 * 
	 * @return the tipo of the empregado
	 **********************************************************************/
	public TipoEmpregado tipo() {
		return tipo;
	}

	/**********************************************************************
	 * Standard attribute setter
	 * 
	 * @param tipo
	 *            the tipo to set
	 **********************************************************************/
	public void setTipo(TipoEmpregado tipo) {
		this.tipo = tipo;
	}

	/**********************************************************************
	 * ONE2MANY getter for Empregado[1] <-> Fatura[*]
	 * 
	 * @return the faturas of the empregado
	 **********************************************************************/
	public Set<Fatura> faturas() {
		Set<Fatura> result = new HashSet<Fatura>();
		for (Fatura x : Fatura.allInstances())
			if (x.empregado() == this)
				result.add(x);
		return result;
	}

	/**********************************************************************
	 * ONE2MANY multiple setter for Empregado[1] <-> Fatura[*]
	 * 
	 * @param faturas
	 *            the faturas to set
	 **********************************************************************/
	public void setFaturas(Set<Fatura> faturas) {
		for (Fatura x : faturas)
			x.setEmpregado(this);
	}

	/**********************************************************************
	 * ONE2MANY single setter for Empregado[1] <-> Fatura[*]
	 * 
	 * @param fatura
	 *            the fatura to add
	 **********************************************************************/
	public void addFaturas(Fatura fatura) {
		fatura.setEmpregado(this);
	}

	/**********************************************************************
	 * ONE2MANY single remover for Empregado[1] <-> Fatura[*]
	 * 
	 * @param fatura
	 *            the fatura to remove
	 **********************************************************************/
	public void removeFaturas(Fatura fatura) {
		fatura.setEmpregado(null);
	}

	/**********************************************************************
	 * MEMBER2ASSOCIATIVE getter for Empregado[1..*] <-> Contrato[1..*]
	 * 
	 * @return the contrato of the contratados
	 **********************************************************************/
	public Set<Contrato> contrato() {
		Set<Contrato> result = new HashSet<Contrato>();
		for (Contrato x : Contrato.allInstances())
			if (x.contratados() == this)
				result.add(x);
		return result;
	}

	/**********************************************************************
	 * MEMBER2ASSOCIATIVE setter for Empregado[1..*] <-> Contrato[1..*]
	 * 
	 * @param contrato
	 *            the contrato to set
	 **********************************************************************/
	public void setContrato(Set<Contrato> contrato) {
		for (Contrato x : contrato)
			x.setContratados(this);
	}

	/**********************************************************************
	 * MEMBER2MEMBER getter for Empregado[1..*] <-> Restaurante[1..*]
	 * 
	 * @return the empregadores of the contratados
	 **********************************************************************/
	public Set<Restaurante> empregadores() {
		Set<Restaurante> result = new HashSet<Restaurante>();
		for (Contrato x : Contrato.allInstances())
			if (x.contratados() == this && x.empregadores() != null)
				result.add(x.empregadores());
		return result;
	}

	/**********************************************************************
	 * MEMBER2MEMBER setter for Empregado[1..*] <-> Restaurante[1..*]
	 * 
	 * @param empregadores
	 *            the empregadores to set
	 **********************************************************************/
	public void setEmpregadores(Set<Restaurante> empregadores) {
		for (Restaurante t : empregadores)
			for (Contrato x : Contrato.allInstances())
				if (x.contratados() == this)
					x.setEmpregadores(t);
	}

	/**********************************************************************
	 * User-defined operation specified in SOIL/OCL
	 * 
	 * @param r
	 *            the r to set
	 * @param f
	 *            the f to set
	 * @param p
	 *            the p to set
	 * @param quantidade
	 *            the quantidade to set
	 * @param preco
	 *            the preco to set
	 * @param data
	 *            the data to set
	 **********************************************************************/
	public void ComprarIngredientes(Restaurante r, Fornecedor f,
			ProdutoSimples p, Integer quantidade, Double preco,
			CalendarDate data) {
		// (preco <= 3)
		boolean pre_ComprarIngredientesPrecoAquisicaoBarato = preco <= 3;

		assert pre_ComprarIngredientesPrecoAquisicaoBarato : "Preco tem de ser mais barato que 3";
		// -----------------------------------------------------------------------------
		// (quantidade >= 5)
		boolean pre_ComprarIngredientesQuantidadeMinima = quantidade >= 5;

		assert pre_ComprarIngredientesQuantidadeMinima : "Tem que se comprar pelo menos 5 produtos";
		// -----------------------------------------------------------------------------
		// declare c : Compra; c := new Compra; c.init(quantidade, preco, data);
		// insert (c,p) into Compra_ProdutoSimples; insert (c,f) into
		// Compra_Fornecedor; insert (r,c) into Restaurante_Compra
		Compra comp = new Compra();
		comp.init(quantidade, preco, data);
		Database.insert(comp, p);
		Database.insert(comp, f);
		Database.insert(r, comp);
		// -----------------------------------------------------------------------------
		// (p.compras->select(c : Compra | (c.data = data))->isEmpty = false)
		boolean post_ComprarIngredientesCompraSemSucesso = false;
		for (Compra c : p.compras()) {
			if (c.data() == data)
				post_ComprarIngredientesCompraSemSucesso = true;
		}

		assert post_ComprarIngredientesCompraSemSucesso : "Nao foi possivel efectuar a compra";
	}

	/**********************************************************************
	 * User-defined operation specified in SOIL/OCL
	 * 
	 * @param r
	 *            the r to set
	 * @param e
	 *            the e to set
	 **********************************************************************/
	public void ContrataEmpregado(Restaurante r, Empregado e) {
		// (e.idade >= 21)
		boolean pre_ContrataEmpregadoMaiorIdade = e.idade() >= 21;

		assert pre_ContrataEmpregadoMaiorIdade : "Para contratar um empregado este necessita ser maior de idade(21 anos)";
		// -----------------------------------------------------------------------------
		// (self.empregadores->collect($e : Restaurante |
		// $e.contratados)->select(x : Empregado | (x.nome =
		// e.nome))->includes(e) = false)
		boolean pre_ContrataEmpregadoVerificaJaContratado = true;

		for (Restaurante rest : empregadores()) {
			for (Empregado emp : rest.contratados()) {
				if (emp.nome() == e.nome() && rest.nome() == r.nome())
					pre_ContrataEmpregadoVerificaJaContratado = false;
			}
		}

		assert pre_ContrataEmpregadoVerificaJaContratado : "Só se pode contratar o empregado se ele não estiver já contratado no mesmo restaurante";
		// -----------------------------------------------------------------------------
		// (Empregado.allInstances->select($elem3 : Empregado | ($elem3.tipo =
		// TipoEmpregado::Gerente))->includes(self) = true)
		boolean pre_ContrataEmpregadoVerificaSeGerente = tipo() == TipoEmpregado.Gerente;

		assert pre_ContrataEmpregadoVerificaSeGerente : "Só o tipo de empregado Gerente é que pode contratar um empregado";
		// -----------------------------------------------------------------------------
		// ((self.empregadores->collect($e : Restaurante |
		// $e.contratados)->select(x : Empregado | (x.tipo =
		// TipoEmpregado::Cozinheiro))->size < 1) = true)
		boolean pre_ContrataEmpregadoSoUmCozinheiro = true;
		int count = 0;
		for (Restaurante rest : empregadores()) {
			for (Empregado emp : rest.contratados()) {
				if ((rest.nome() == r.nome())
						&& (emp.tipo() == TipoEmpregado.Cozinheiro))
					count++;
			}
		}

		pre_ContrataEmpregadoSoUmCozinheiro = count == 0;

		assert pre_ContrataEmpregadoSoUmCozinheiro : "Não é permitido mais do que um cozinheiro por restaurante";
		// -----------------------------------------------------------------------------
		// declare cd : CalendarDate, c : Contrato; cd := new CalendarDate; c :=
		// new Contrato between (r,e); cd.initS('2014-06-25'); c.inicio := cd;
		// cd.initS('2015-06-25'); c.fim := cd; c.vencimento := 800
		CalendarDate d1 = new CalendarDate();
		CalendarDate d2 = new CalendarDate();
		Contrato c = new Contrato(r, e);
		d1.initS("2014-06-25");
		d2.initS("2015-06-25");
		c.setInicio(d1);
		c.setFim(d2);
		c.setVencimento((double) 800);
		// -----------------------------------------------------------------------------
		// (self.empregadores->collect($e : Restaurante |
		// $e.contratados)->includes(e) = false)

		boolean post_ContrataEmpregadoInsucesso = false;

		count = 0;
		for (Restaurante rest : empregadores()) {
			for (Empregado emp : rest.contratados()) {
				if ((rest.nome() == r.nome()) && (emp.nc() == e.nc()))
					post_ContrataEmpregadoInsucesso = true;
			}
		}

		assert post_ContrataEmpregadoInsucesso : "Contrato nao realizado";
	}

	/**********************************************************************
	 * User-defined operation specified in SOIL/OCL
	 * 
	 * @param nome
	 *            the nome to set
	 * @param tipop
	 *            the tipop to set
	 * @param unidade
	 *            the unidade to set
	 * @param precoVenda
	 *            the precoVenda to set
	 * @param quantidade
	 *            the quantidade to set
	 * @param quantidades_ingredientes
	 *            the quantidades_ingredientes to set
	 * @param ingredientes
	 *            the ingredientes to set
	 * @param grupo
	 *            the grupo to set
	 **********************************************************************/
	public void CriarProdutoComposto(String nome, TipoProduto tipop,
			Unidade unidade, Double precoVenda, Integer quantidade,
			Queue<Integer> quantidades_ingredientes,
			Set<ProdutoSimples> ingredientes, GrupoProdutoComposto grupo) {
		// (Empregado.allInstances->select($elem4 : Empregado | ($elem4.tipo =
		// TipoEmpregado::Cozinheiro))->includes(self) = true)
		boolean pre_CriarProdutoCompostoVerificaSeCozinheiro = this.tipo
				.equals(TipoEmpregado.Cozinheiro);

		assert pre_CriarProdutoCompostoVerificaSeCozinheiro : "Só o tipo de empregado Cozinheiro é que pode criar um produto composto";
		// -----------------------------------------------------------------------------
		// (ingredientes->size = quantidades_ingredientes->size)
		boolean pre_CriarProdutoCompostoVerificaTamanhoListasIgual = ingredientes
				.size() == quantidade;

		assert pre_CriarProdutoCompostoVerificaTamanhoListasIgual : "Só o tipo de empregado Cozinheiro é que pode criar um produto composto";
		// -----------------------------------------------------------------------------
		// declare itr : Integer, c : Composicao, pc : ProdutoComposto; pc :=
		// new ProdutoComposto; pc.init(nome, tipop, unidade, precoVenda,
		// quantidade); pc.grupo := grupo; itr := 0; for ing in ingredientes do
		// c := new Composicao((pc.nome + itr.toString)) between (pc,ing);
		// c.quantidade := quantidades_ingredientes->at(itr); itr := (itr + 1)
		// end
		int itr;
		ProdutoComposto pc;

		pc = new ProdutoComposto();
		pc.init(nome, tipop, unidade, precoVenda, quantidade);
		pc.setGrupo(grupo);

		itr = 0;
		for (ProdutoSimples ing : ingredientes) {

			new Composicao(pc, ing,
					(double) quantidades_ingredientes.toArray()[itr]);
			itr++;

		}

		// -----------------------------------------------------------------------------
		// (Pedido.allInstances->collect($e : Pedido | $e.produto)->select(p :
		// Produto | (p.nome = nome))->notEmpty = false)
		boolean post_CriarProdutoCompostoInsucesso = Pedido.allInstances()
				.contains(nome);

		assert post_CriarProdutoCompostoInsucesso : "Nao foi possivel criar o produto composto";
	}

	/**********************************************************************
	 * User-defined operation specified in SOIL/OCL
	 * 
	 * @param r
	 *            the r to set
	 * @param empre
	 *            the empre to set
	 **********************************************************************/
	public void Despedir(Restaurante r, Empregado empre) {
		// (self.empregadores->collect($e : Restaurante |
		// $e.contratados)->select(e : Empregado | (e.nome =
		// empre.nome))->includes(empre) = true)
		boolean pre_DespedirVerificaContratado = true;
		for (Restaurante e : empregadores()) {
			if (!e.contratados().contains(empre))
				pre_DespedirVerificaContratado = false;
		}
		assert pre_DespedirVerificaContratado : "Só se pode despedir o empregado se ele estiver já contratado no mesmo restaurante";
		// -----------------------------------------------------------------------------
		// ((empre.faturas->size < 5) = true)
		boolean pre_DespedirMinimoDeVendas = this.faturas().size() < 5;

		assert pre_DespedirMinimoDeVendas : "Para despedir o empregado é necessario esse empregado alcançar o minimo de vendas";
		// -----------------------------------------------------------------------------
		// delete (r,empre) from Contrato
		Database.delete(r, empre);
		// -----------------------------------------------------------------------------
		// (self.empregadores->collect($e : Restaurante |
		// $e.contratados)->includes(empre) = false)
		boolean post_DespedirInsucesso = true;
		for (Restaurante e : empregadores()) {
			if (e.contratados().contains(empre))
				post_DespedirInsucesso = false;
		}

		assert post_DespedirInsucesso : "Nao foi possivel despedir o empregado";
	}

	/**********************************************************************
	 * User-defined operation specified in SOIL/OCL
	 **********************************************************************/
	@SuppressWarnings("null")
	public void EliminarDevolucoes() {
		// declare pe : Bag(Pedido); pe := Pedido.allInstances->asBag->select(p
		// : Pedido | (p.devolvido = true)); for b in pe do destroy b end;
		// destroy pe
		Set<Pedido> pedidos_devolvidos = new HashSet<Pedido>();

		for (Pedido pe : Pedido.allInstances()) {
			if (pe.devolvido() == true) {
//				System.out.println("sdg");
				pedidos_devolvidos.add(pe);
			}
		}

		for (Pedido pe : pedidos_devolvidos) {
			Database.delete(pe);
		}

		pedidos_devolvidos.clear();

		// -----------------------------------------------------------------------------
		// (Pedido.allInstances->asBag->exists(p : Pedido | (p.devolvido =
		// true)) = false)
		boolean post_EliminarDevolucoesInsusesso = true;
		for (Pedido p : Pedido.allInstances()) {
			if (p.devolvido() == true)
				post_EliminarDevolucoesInsusesso = false;
		}

		assert post_EliminarDevolucoesInsusesso : "Devolucoes nao eliminadas";
	}

	/**********************************************************************
	 * User-defined operation specified in SOIL/OCL
	 * 
	 * @param data
	 *            the data to set
	 **********************************************************************/
	public void FazerInventario(CalendarDate data) {
		// declare quantidade : Integer, contagem : Contagem, produtos_simples :
		// Set(Produto), invent : Inventario;
		// invent := new Inventario; invent.init(data);
		// produtos_simples := self.empregadores->collect($e : Restaurante |
		// $e.produtos)->asSet;
		// for ps in produtos_simples do quantidade :=
		// produtos_simples->select(p : Produto | (p.nome =
		// ps.nome))->collect($e : Produto | $e.quantidade)->sum;
		// contagem := new Contagem; contagem.existencias := quantidade; insert
		// (contagem,ps.oclAsType(ProdutoSimples)) into Contagem_ProdutoSimples;
		// insert (invent,contagem) into Inventario_Contagem end
		Integer quantidade = 0;
		Contagem contagem = new Contagem();
		Inventario invent = new Inventario();
		invent.setData(data);
		Restaurante r = empregadores().iterator().next();
		invent.setRestaurante(r);
		
		Set<Produto> produtos_simples = r.produtos();

		for (Produto produto : produtos_simples) {
			quantidade += produto.quantidade();
			contagem.setExistencias(quantidade);
			Database.insert(contagem, produto);
			Database.insert(invent, contagem);
		}
	}

	/**********************************************************************
	 * User-defined operation specified in SOIL/OCL
	 * 
	 * @param f
	 *            the f to set
	 * @param p
	 *            the p to set
	 * @param quantidade
	 *            the quantidade to set
	 **********************************************************************/
	public void FazerPedido(Fatura f, Produto p, Integer quantidade) {
		// (quantidade >= 1)
		boolean pre_FazerPedidoQuantidadeMaisDeUmPedido = quantidade >= 1;

		assert pre_FazerPedidoQuantidadeMaisDeUmPedido : "Para fazer pedido tem que se pedir 1 produto pelo menos";
		// -----------------------------------------------------------------------------
		// (Empregado.allInstances->select($elem2 : Empregado | ($elem2.tipo =
		// TipoEmpregado::EmpregadoMesa))->includes(self) = true)
		boolean pre_FazerPedidoVerificaEmpregadoMesa = this.tipo
				.equals(TipoEmpregado.EmpregadoMesa);

		assert pre_FazerPedidoVerificaEmpregadoMesa : "Só o tipo de empregado Empregado de Mesa é que pode fazer pedido";
		// -----------------------------------------------------------------------------
		// declare pe : Pedido; pe := new Pedido; pe.init(quantidade); insert
		// (pe,p) into Pedido_Produto; insert (f,pe) into Fatura_Pedido
		Pedido pe;
		pe = new Pedido();
		pe.init(quantidade);

		Database.insert(pe, p);
		Database.insert(f, pe);
		// -----------------------------------------------------------------------------
		// Pedido.allInstances->collect($e : Pedido | $e.produto)->includes(p)
		boolean post_FazerPedidoNaoRealizado = Pedido.allInstances()
				.contains(p);

		assert post_FazerPedidoNaoRealizado : "Pedido nao realizado";
	}

	/**********************************************************************
	 * User-defined operation specified in SOIL/OCL
	 * 
	 * @param c
	 *            the c to set
	 * @param m
	 *            the m to set
	 * @param data
	 *            the data to set
	 * @param numF
	 *            the numF to set
	 **********************************************************************/
	public void PassaFatura(Cliente c, Mesa m, CalendarDate data, Integer numF) {
		// (Fatura.allInstances->exists($elem0 : Fatura | ($elem0.numero =
		// numF)) = false)
		boolean pre_PassaFaturaUnica = false;
		for (Fatura f : faturas()) {
			if (f.numero() != numF)
				pre_PassaFaturaUnica = true;
		}

		assert pre_PassaFaturaUnica : "Ja existe uma fatura com o mesmo numero";
		// -----------------------------------------------------------------------------
		// (Empregado.allInstances->select($elem1 : Empregado | ($elem1.tipo =
		// TipoEmpregado::EmpregadoMesa))->includes(self) = true)
		boolean pre_PassaFaturaVerificaEmpregadoMesa = this.tipo
				.equals(TipoEmpregado.EmpregadoMesa);

		assert pre_PassaFaturaVerificaEmpregadoMesa : "Só o tipo de empregado ‘Empregado de Mesa’ é que pode passar faturas";
		// -----------------------------------------------------------------------------
		// declare f : Fatura; f := new Fatura; f.init(numF, data); insert (f,c)
		// into Fatura_Cliente; insert (f,self) into Fatura_Empregado; insert
		// (f,m) into Fatura_Mesa
		Fatura f;
		f = new Fatura();
		f.init(numF, data);

		Database.insert(f, c);
		Database.insert(f, this);
		Database.insert(f, m);
	}

	/**********************************************************************
	 * INVARIANT CHECKERS
	 **********************************************************************/
	public void check() {
		checkEmpregadoSoTemUmaMorada();
		checkTipoDeveSerPreenchido();
	}

	public void checkEmpregadoSoTemUmaMorada() {
		// Empregado.allInstances->select($elem12 : Empregado |
		// $elem12.oclIsKindOf(Entidade))->isUnique($elem13 : Empregado |
		// $elem13.morada)
		int count = 0;
		for (Entidade m : allInstances()) {
			for (Entidade m2 : allInstances()) {
				if (m.morada().equals(m2.morada()))
					count++;
			}
		}
		boolean invariant = count < 2;

		assert invariant : "Empregado so tem uma morada!";
	}

	public void checkTipoDeveSerPreenchido() {
		// self.tipo.isDefined
		boolean invariant = tipo != null;

		assert invariant : "O tipo de empregado deve ser preenchido!";
	}

	/**********************************************************************
	 * @param other
	 *            Empregado to compare to the current one
	 * @return 0 if the argument is equal to the current Empregado; a value less
	 *         than 0 if the argument is greater than the current Empregado; and
	 *         a value greater than 0 if the argument is less than this
	 *         Empregado.
	 **********************************************************************/
	@Override
	public int compareTo(Object other) {
		assert other instanceof Empregado;

		// return this.idade.compareTo(((Empregado) other).idade);
		// return this.tipo.compareTo(((Empregado) other).tipo);
		// return this.morada.compareTo(((Empregado) other).morada);
		return this.nc.compareTo(((Empregado) other).nc);
		// return this.nome.compareTo(((Empregado) other).nome);
		// return this.hashCode() - ((Empregado) other).hashCode();
	}

	/**********************************************************************
	 * @param other
	 *            Empregado to check equality to the current one
	 * @return true if the argument is equal to the current Empregado and false
	 *         otherwise
	 **********************************************************************/
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;

		final Empregado another = (Empregado) other;
		if (!super.equals(another))
			return false;
		if ((this.idade == null) ? (another.idade != null) : !this.idade
				.equals(another.idade))
			return false;
		if ((this.tipo == null) ? (another.tipo != null) : !this.tipo
				.equals(another.tipo))
			return false;

		return true;
	}

	/**********************************************************************
	 * Object serializer
	 **********************************************************************/
	@Override
	public String toString() {
		return "Empregado[idade=" + idade() + ", tipo=" + tipo() + ", morada="
				+ morada() + ", nc=" + nc() + ", nome=" + nome()
				+ ", contrato(" + contrato().size() + "), empregadores("
				+ empregadores().size() + "), faturas(" + faturas().size()
				+ ")]";
	}

}
