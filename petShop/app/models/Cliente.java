package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Usuario{
	public Date dataNascimento;
	public String endereco;
	
	@OneToMany(mappedBy="cliente")
	public List<Pet>pets;
	
}
