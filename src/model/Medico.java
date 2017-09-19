package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Medico implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String nomeMedico;
	private String telefone;
	private String especialidade;

	public Medico (){
		super();
		
	}
	
	public Medico(String nomeMedico, String telefone, String especialidade){
		this.nomeMedico = nomeMedico;
		this.telefone = telefone;
		this.especialidade = especialidade;
		
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getnomeMedico() {
		return nomeMedico;
	}

	public void setnomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	

	public String getTelefone() {
		return telefone;
	}

	public void settelefone(String telefone) {
		this.telefone = telefone;
	}
}
	
	
