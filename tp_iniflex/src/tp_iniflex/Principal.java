package tp_iniflex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Principal {
	public static void main(String[] args) {
		
		final BigDecimal salarioMinimo = new BigDecimal(1212.00);
		
		DecimalFormat formatoDecimal = new DecimalFormat("###,##0.##");
		BigDecimal quantSM;
		long idadeMaisVelho = 0;
		LocalDate hoje = LocalDate.now();
		String nomeMaisVelho = null;
		 //Considerando que a questão pede uma lista.
		List<Funcionario> listaFuncionarios = new ArrayList<>();
		Map<String, List<Funcionario>> mapaFuncionariosPorFuncao = new HashMap<>();
		
		//Item 3.1:
		listaFuncionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador"));
		listaFuncionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38), "Operador"));
		listaFuncionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 02), new BigDecimal(9836.14), "Coordenador"));
		listaFuncionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor"));
		listaFuncionarios.add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), new BigDecimal(2234.68), "Recepcionista"));
		listaFuncionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador"));
		listaFuncionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), new BigDecimal(4071.84), "Contador"));
		listaFuncionarios.add(new Funcionario("Laura", LocalDate.of(1994, 07, 8), new BigDecimal(3017.45), "Gerente"));
		listaFuncionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), new BigDecimal(1606.85), "Eletricista"));
		listaFuncionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 02), new BigDecimal(2799.93), "Gerente"));
		
		//Item 3.2 (considerando que é pra remover por nome, não pela referência ao objeto João):
		removeFuncionarioPorNome(listaFuncionarios, "João");
		
		for(Funcionario f: listaFuncionarios) {
			//Item 3.3:
			System.out.println(f);
			
			//Item 3.4:
			f.setSalario(f.getSalario().multiply(new BigDecimal(1.1)));
			
			//Item 3.5:
			if(mapaFuncionariosPorFuncao.containsKey(f.getFuncao())) {
				mapaFuncionariosPorFuncao.get(f.getFuncao()).add(f);
			}
			else {
				List<Funcionario> listaAuxiliar = new ArrayList<>();
				listaAuxiliar.add(f);
				mapaFuncionariosPorFuncao.put(f.getFuncao(), listaAuxiliar);
			}
			
			//Para o item 3.9:
			if(f.getDataNascimento().until(hoje, ChronoUnit.YEARS) > idadeMaisVelho){
				idadeMaisVelho = f.getDataNascimento().until(hoje, ChronoUnit.YEARS);
				nomeMaisVelho = f.getNome();
			}
			
			//Item 3.12:
			quantSM = f.getSalario().divide(salarioMinimo, RoundingMode.HALF_UP);
			System.out.println("Quantidade de salários mínimo: " + formatoDecimal.format(quantSM) + "\n");
		}
		
		//Item 3.6:
		for (Entry<String, List<Funcionario>> aux : mapaFuncionariosPorFuncao.entrySet()) {
		     System.out.println(aux.getKey() + ":");
		     for(Funcionario f: aux.getValue()) {
		    	 System.out.println(f);
		     }
		}
		
		//Item 3.8:
		for(Funcionario f: listaFuncionarios) {
			if(f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12) {
				System.out.println(f);
			}
		}
		
		//Item 3.9:
		System.out.println("Item 3.9.\nFuncionário com a maior idade:\nNome: " + nomeMaisVelho + "\nIdade: " + idadeMaisVelho);
		
		//Item 3.10:
		Collections.sort(listaFuncionarios);
		for(Funcionario f: listaFuncionarios) {
			System.out.println(f);
		}
		
		//Item 3.11:
		System.out.println("Total dos salários: " + formatoDecimal.format(Funcionario.getMassaSalario()));
		
	}
	
	/*
	 * Considerando que é uma remoção por nome:
	 * Remove o funcionário com a primeira aparição do nome da lista.
	 * Obs.: Caso fosse por objeto, poderia ter criado um objeto funcionário, e removido direto da lista passando a referência ao objeto que queira remover (list.remove(funcionarioJoao, por exemplo).
	 */
	public static void removeFuncionarioPorNome(List<Funcionario> lista, String nomeFuncionario) {	
		for(Funcionario f: lista) {
			if(f.getNome().equals(nomeFuncionario)) {
				lista.remove(f);
				break;
			}
		}
		
	}

}
