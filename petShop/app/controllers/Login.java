package controllers;

import java.util.Date;
import java.util.List;

import models.Cliente;
import models.Pet;
import models.TipoUsuario;
import models.Usuario;
import models.Veterinario;
import play.mvc.Controller;

public class Login extends Controller {
	public static void logout() {
		session.clear();
		Application.index();
	}

	public static void form() {
		render();
	}

	public static void autenticar(String email, String senha) {
		Usuario usuario = Usuario.find("email = ? and senha = ?", email, senha).first();
		
		if (usuario == null) {
			flash.error("Usuário não encontrado");
			form();
		} else {
			session.put("usuarioID", usuario.id);
			session.put("nomeUsuario", usuario.nome);
			session.put("emailUsuario", usuario.email);
			
			
			if (usuario.tipoUsuario.equals(TipoUsuario.admin)) {
				Usuarios.index();
			} else if (usuario.tipoUsuario.equals(TipoUsuario.Veterinario)) {
				Veterinarios.index();
			} else if(usuario.tipoUsuario.equals(TipoUsuario.Cliente)){
				Clientes.index();
			}

		}

	}

	/*
	 * public static void logar(String nome, String senha) {
	 * 
	 * Cliente cl1 = Cliente.find("nome = ?1 and senha = ?2", nome, senha).first();
	 * 
	 * if(cl1 == null) { form(); flash.error("Usuário não encontrado"); }else {
	 * session.put("cliente.nome", cl1.nome); }
	 * 
	 * }
	 */

}
