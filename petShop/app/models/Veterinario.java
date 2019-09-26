package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Veterinario extends Usuario {
	public String crmv;

}
