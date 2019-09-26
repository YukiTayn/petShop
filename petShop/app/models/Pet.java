package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Pet extends Model{
	public String raca;
	public String idade;
	public String peso;
	public String carteiraVacina;

	@ManyToOne
	@JoinColumn(name="cliente_id")
	public Cliente cliente;
}
