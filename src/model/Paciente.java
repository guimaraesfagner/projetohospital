package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;



@Entity
@SequenceGenerator(name="seq_paciente_id",sequenceName="seq_paciente_id")
public class Paciente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(generator="seq_paciente_id",strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String idade;
	private String sexo;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="idlazer",insertable=true, updatable=true)
	private Lazer lazer;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="idescolaridade",insertable=true, updatable=true)
	private Escolaridade escolaridade;
	
	public Paciente() {		
	}


	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Lazer getLazer() {
		return lazer;
	}

	public void setLazer(Lazer lazer) {
		this.lazer = lazer;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
}
