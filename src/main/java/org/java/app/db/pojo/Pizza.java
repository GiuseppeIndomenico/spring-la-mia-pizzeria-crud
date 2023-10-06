package org.java.app.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;

@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 128, nullable = false)
	@Length(min = 3, max = 128, message = "Il nome deve essere di almeno tre caratteri")

	private String nome;

	private String descrizione;

	@Min(value = 1, message = "Il prezzo deve essere un numero intero maggiore di zero")
	private int prezzo;

	private String foto;

	public Pizza() {
	}

	public Pizza(String nome, String descrizione, String foto, int prezzo) {

		setNome(nome);
		setDescrizione(descrizione);
		setFoto(foto);
		setPrezzo(prezzo);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {

		return "[" + getId() + "] pizza:\n" + "nome: " + getNome() + "\n" + "descrizione: " + getDescrizione() + "\n"
				+ "foto URL: " + getFoto() + "\n" + "prezzo: " + getPrezzo() + "Euro";
	}

}
