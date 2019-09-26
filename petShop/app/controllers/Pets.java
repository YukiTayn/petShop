package controllers;

import java.util.List;

import models.Pet;
import play.mvc.Controller;

public class Pets extends Controller{

	public static void form() {
		//Cliente cliente = session.get("");
		render();
	}
	
	public static void cadastro(Pet pet) {
		pet.save();
		listar();
	}
	
	
	public static void listar() {
		List<Pet> pet = Pet.findAll();
		render(pet);
	}
	
	public static void remover(Long id){
		Pet pet = Pet.findById(id);
		pet.delete();
		listar();
	}
	
	public static void pesquisar(String Raca) {
		List<Pet> pet = Pet.find("raca like ?", "%" + Raca + "%").fetch();
		render("Pets/listar.html", pet);
	}
	
	public static void editar(Long id) {
		Pet pet = Pet.findById(id);
		render("Pets/form.html");
	}
	
	public static void adcionarPet(Pet pet){
		pet.save();
}
}
