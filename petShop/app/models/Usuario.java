package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Usuario extends Model{
	public String nome;
	//public String username;
	public String senha;
	public String cpf;
	public String email;
	public TipoUsuario tipoUsuario;
	
	public Usuario() {
		tipoUsuario = TipoUsuario.Cliente;
	}
	
	
}
