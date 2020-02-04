package br.com.md2.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.md2.dao.TabelasDao;
import br.com.md2.model.Autor;
import br.com.md2.model.Cliente;
import br.com.md2.model.Departamento;
import br.com.md2.model.Estado;
import br.com.md2.model.Funcionarios;
import br.com.md2.model.Governador;
import br.com.md2.model.Livro;
import br.com.md2.model.Pedido;

@Controller
public class TabelasController {

	@Autowired
	private TabelasDao tabelasDao;
	
    @GetMapping("/admin/tabelas")
    @Transactional
    @ResponseBody
    public void salva() {
    	departamentoFuncionario();
    	pedidoCliente();
    	estadoGovernador();
    	livroAutor();
    }

    /* Cria e Grava Livro <--> Autor (Many to Many) */
    @ResponseBody
    private String livroAutor() {
    	Livro livro1 = new Livro("Diversos Topicos");
    	Livro livro2 = new Livro("Outros topicos");
    	
    	Autor autor1 = new Autor("Marcelo Carvalho");
    	Autor autor2 = new Autor("Lucas Simoes");
    	
    	Set<Autor> listaDeAutores1 = new HashSet<>();
    	listaDeAutores1.add(autor1);
    	listaDeAutores1.add(autor2);
    	livro1.setAutores(listaDeAutores1);

    	Set<Autor> listaDeAutores2 = new HashSet<>();
    	listaDeAutores2.add(autor1);
    	livro2.setAutores(listaDeAutores2);
    	
    	tabelasDao.save(livro1);
    	tabelasDao.save(livro2);
    	
    	return "Livro/Autor criado com sucesso!";
    }
    
    /* Cria e Grava Estado -- Governador *(One to One) */
    @ResponseBody
    private String estadoGovernador() {
    	Estado estado = new Estado("MG");
    	Governador governador = new Governador("Marcelo");
    	estado.setGovernador(governador);
    	tabelasDao.save(estado);
    	return "Estado/Governador criado com sucesso!";
    }
    
    /* Cria e Grava Departamento -> Funcionario (One to Many) */
    @ResponseBody
    private String departamentoFuncionario() {
    	Departamento departamento = new Departamento("Contabilidade");
    	List<Funcionarios> listaDeFuncionarios = new ArrayList<Funcionarios>();    	
    	listaDeFuncionarios.add(criaFuncionario(departamento, "Marcelo"));
    	listaDeFuncionarios.add(criaFuncionario(departamento, "Lucas"));
    	listaDeFuncionarios.add(criaFuncionario(departamento, "Elisete"));
    	departamento.setListaFuncionarios(listaDeFuncionarios);
    	tabelasDao.save(departamento);
    	return "Departamento/Funcionarios gravado com sucesso!!";
    }

    /* Cria e grava Pedido -> Cliente (Many to One)*/
    @ResponseBody
    private String pedidoCliente() {
    	Cliente cliente = new Cliente("Marcelo");
    	Set<Pedido> pedido = new HashSet<Pedido>();
    	pedido.add(criaPedido(cliente, "xyz123"));
    	pedido.add(criaPedido(cliente, "999999"));
    	pedido.add(criaPedido(cliente, "AAAAAAA"));
    	pedido.add(criaPedido(cliente, "12345-A"));    	
    	cliente.setPedido(pedido);
    	tabelasDao.save(cliente);
    	return "Cliente/Pedido criado com sucesso!";
    }

    /* Cria os Funcionarios do Departamento */
    private Funcionarios criaFuncionario(Departamento departamento, String funcionario) {
    	Funcionarios func = new Funcionarios();
    	func.setDepartamento(departamento);
    	func.setNome(funcionario);
    	return func;
    }
    
    /* Cria os Pedidos do Cliente*/
    private Pedido criaPedido(Cliente cliente, String nrPedido) {
    	Pedido pedido = new Pedido();
    	pedido.setCliente(cliente);
    	pedido.setNrPedido(nrPedido);
    	return pedido;
    }
}
