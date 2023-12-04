package tp_iniflex;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario  extends Pessoa implements Comparable<Funcionario>{
	
	/*
	 * Considerando que só as instâncias podem alterar a si.
	 */
	private BigDecimal salario;
	private String funcao;
	private static BigDecimal massaSalario;
	
	/*
	 * Considerando que todos os campos devem ser preenchidos.
	 */
	Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.funcao = funcao;
		this.massaSalario = this.massaSalario.add(salario); 
	}
	
	public BigDecimal getSalario() {
		return this.salario;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public String getFuncao() {
		return this.funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public static BigDecimal getMassaSalario() {
		return Funcionario.massaSalario;
	}

	@Override 
	public int compareTo(Funcionario aux) { 
		return this.nome.compareToIgnoreCase(aux.getNome());
	}
	
	public String toString() {
		
		DecimalFormat formatoDecimal = new DecimalFormat("###,##0.##");
		DateTimeFormatter formatoDataBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return "Nome: " + this.nome + 
				"\nData de Nascimento: " + this.dataNascimento.format(formatoDataBR) +
				"\nSalário: " + formatoDecimal.format(this.salario) + 
				"\nFunção: " + this.funcao + "\n";
	}
	
}
