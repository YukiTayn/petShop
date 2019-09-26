package jobs;

import models.Cliente;
import models.Usuario;
import models.Veterinario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Inicializador extends Job{
	public void doJob() {
		if(Cliente.count()==0) {
			Fixtures.loadModels("test-data.yml");
		}
		if(Veterinario.count()==0) {
			Fixtures.loadModels("test-data.yml");
		}
		if(Usuario.count()==0) {
			Fixtures.loadModels("test-data.yml");
		}
	}
}
