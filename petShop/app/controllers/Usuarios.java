package controllers;


import java.util.List;

import models.TipoUsuario;
import models.Usuario;
import play.mvc.Controller;


public class Usuarios extends Controller{
	public static void index() {
		render();
	}
	public static void form() {
		render();
	}
	public static void cads(Usuario usuario) {
		usuario.tipoUsuario = TipoUsuario.admin;
		usuario.save();	
		listar();
	}
	public static void listar() {
		List<Usuario> usu = Usuario.findAll();
		render(usu);
	}
	public static void pesquisar(String nome) {
		List<Usuario> usu = Usuario.find("crmv like ?", "%" + nome + "%").fetch();
		render("Veterinarios/listar.html", usu);

	}
	

}
