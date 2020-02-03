package br.com.md2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.md2.dao.FuncionarioDao;
import br.com.md2.model.Funcionario;
import br.com.md2.model.FuncionarioTelefones;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioDao funcionarioDao;
    
    @GetMapping("/admin/funcionario")
    @Transactional
    @ResponseBody
    public String salva() {
    	
    	Funcionario funcionario = new Funcionario("Marcelo Carvalho");
    	
    	FuncionarioTelefones funcTel1 = new FuncionarioTelefones();
    	funcTel1.setTelefones("+5511991604150");
    	funcTel1.setFuncionario(funcionario);
    	
    	FuncionarioTelefones funcTel2 = new FuncionarioTelefones();
    	funcTel2.setTelefones("11991581189");
    	funcTel2.setFuncionario(funcionario);

    	List<FuncionarioTelefones> listTel = new ArrayList<FuncionarioTelefones>();
    	listTel.add(funcTel1);
    	listTel.add(funcTel2);    	
    	
    	funcionario.setListaFuncionarioTelefones(listTel);    	
    	
        funcionarioDao.save(funcionario);
        
        return "Funcionario criado com sucesso!";
    }
}
