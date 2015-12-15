package br.com.tutorial.model.dao;

import java.text.MessageFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.jdbc.PreparedStatement;

import br.com.tutorial.model.entity.Usuario;

public class UsuarioDAO extends AbstractDAO<Usuario, String>{
	
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PU-UDF");
	private EntityManager em;
	
	public void salvarUsuario(Usuario usuario){
		//verifica se o usuario já existe na base de dados
		if(existe(usuario.getId())){
			throw new IllegalArgumentException(MessageFormat.format("O usuário {0} já esta cadastrado", usuario.getId()));
		}
		inserir(usuario);
	}

	public boolean usuarioExiste(String id){
		return existe(id);
	}
}
