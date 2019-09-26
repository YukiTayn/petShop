package controllers;

import java.util.Date;
import java.util.List;

import models.Cliente;
import models.Pet;
import play.mvc.Controller;

public class Clientes extends Controller{
	
	public static void index() {
		render();
	}
	
	public static void form() {
		List<Pet> pets = Pet.findAll(); 
		render(pets);
	}
	public static void cadastro(Cliente clientes){
 		clientes.save();
		listar();	
	}
	public static void pesquisar(String porNome){
		List<Clientes> clientes = Cliente.find("nome like ?", "%"+ porNome + "%").fetch();
		render("Clientes/listar.html", clientes);
	}
	public static void listar(){
		List<Cliente> clientes = Cliente.findAll();
		render(clientes);
	}
	public static void remover(Long id){
		Cliente cl = Cliente.findById(id);
		cl.delete();
		listar();
	}
	public static void editar(Long id){
		Cliente cl = Cliente.findById(id);
		List<Pet> pets = Pet.findAll(); 
		render("Clientes/form.html", cl, pets);	
	}
	public static void adcionarPet(Pet pet){
		pet.save();
		
	}
}
