package br.com.md2.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.md2.dao.TabelasDao;
import br.com.md2.model.Autor;
import br.com.md2.model.Cliente;
import br.com.md2.model.Departamento;
import br.com.md2.model.Estado;
import br.com.md2.model.Funcionarios;
import br.com.md2.model.Governador;
import br.com.md2.model.Livro;
import br.com.md2.model.Pedido;

@RestController
public class TabelasController {

	@Autowired
	private TabelasDao tabelasDao;
	
    @GetMapping("/admin/tabelas")
    @Transactional
    public String salva() {
    	String mensagem;
       	mensagem = estadoGovernador();
    	mensagem += "<br>" + departamentoFuncionario();
    	mensagem += "<br>" + pedidoCliente();
    	mensagem += "<br>" + livroAutor();    	
    	return mensagem;
    }

    /* Cria e Grava Estado -- Governador *(One to One) */
    private String estadoGovernador() {
    	Estado estado = new Estado("DF");
    	Governador governador = new Governador("Marcelo");
    	estado.setGovernador(governador);
   		String msg = tabelasDao.save(estado);
    	return msg;
    }
    
    /* Grava Livro <--> Autor (Many to Many) */
    private String livroAutor() {
    	Livro livro;
    	livro = criaLivroAutor("Varios Topicos", "Marcelo Carvalho", "Lucas Simoes");
    	tabelasDao.save(livro);
    	livro = criaLivroAutor("Outros Topicos", "Marcelo Carvalho");
    	tabelasDao.save(livro);
    	return "Livro/Autor criado com sucesso!";
    }
    
	/* Cria e Grava Departamento -> Funcionario (One to Many) */
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
    
    /* Cria Livro e Autor */
    private Livro criaLivroAutor(String livro, String ...autor) {
    	Livro liv = new Livro(livro);
    	Set<Autor> listaDeAutores = new HashSet<>();
    	for(String aut : autor) {
    		Autor auto = new Autor(aut);
    		listaDeAutores.add(auto);
    	}
    	liv.setAutores(listaDeAutores);
    	return liv;
    }
}
