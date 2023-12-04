package tp_iniflex;

import java.time.LocalDate;

/*
 * Considerando que não haverá um objeto pessoa, mas sim suas subclasses.
 */
public abstract class Pessoa {
	
	/*
	 * Considerando que só as instâncias podem alterar a si.
	 */
	protected String nome;
	protected LocalDate dataNascimento;
	
	/*
	 * Considerando que só há uma subclasse, logo, sem especificidade na atribuição de nome e data de nascimento.
	 */
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento){
		this.dataNascimento = dataNascimento;
	}

}
