package br.com.fin.tech.dao;

import java.util.List;

import br.com.fin.tech.bean.Receita;
import br.com.fin.tech.exception.DBException;

public interface ReceitaDAO {
	
    void insert(Receita receita)  throws DBException;
    List<Receita> getAll(int cdUsuario);
    Receita getByCd(int cdReceita)  throws DBException;
    void update(Receita receita)  throws DBException;
    void delete(int cdReceita) throws DBException ; 
}
