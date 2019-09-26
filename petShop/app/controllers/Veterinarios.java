package controllers;

import java.util.List;

import models.TipoUsuario;
import models.Veterinario;
import play.mvc.Controller;

public class Veterinarios extends Controller {

	public static void index() {
		render();
	}

	public static void form() {
		render();
	}

	public static void cadsVeterinario(Veterinario veterinario) {
		veterinario.tipoUsuario = TipoUsuario.Veterinario;
		veterinario.save();	
		listar();
	}

	public static void listar() {
		List<Veterinario> veter = Veterinario.findAll();
		render(veter);
	}

	public static void pesquisar(String parcrmv) {
		List<Veterinario> veter = Veterinario.find("crmv like ?", "%" + parcrmv + "%").fetch();
		render("Veterinarios/listar.html", veter);

	}

	public static void editar(Long id) {
		Veterinario ver = Veterinario.findById(id);
		render("Veterinarios/form.html", ver);
	}

	public static void remover(Long id) {
		Veterinario ve = Veterinario.findById(id);
		ve.delete();
		listar();
	}

}
