/*
 * PerformanceTest.java
 * 
 * Data de criação: 15/07/2008
 *
 * 
 *
 */
package br.com.ap.reflexao;

import org.junit.Test;

import br.com.ap.reflexao.UtilReflexaoConstrutor;
import br.com.ap.reflexao.UtilReflexaoPropriedade;
import br.com.ap.reflexao.excecao.ReflexaoException;
import br.com.ap.comum.calculadores.UtilDivisoresDeNumero;

/**
 * JUnit de teste de performance. Serão criados 500.000 objetos com 3 atributos
 * carregados, esse teste será feito com e sem reflexão, a diferença deverá ser
 * no máximo 250%.
 * 
 * @author adrianop
 */
public class PerformanceTest extends TesteAbstrato {
	private int	quantidade	= 500000;

	/**
	 * @throws ReflexaoException
	 */
	@Test
	public void test() throws ReflexaoException {
		long t0 = _testeSemReflexao();
		long t1 = _testeComReflexao();
		double r = UtilDivisoresDeNumero.dividir(t1, t0);
		System.out.println(t0);
		System.out.println(t1);
		System.out.println("~" + (int) r + "0%");
		// A diferença de performance deverá ser no máximo 250%.
		if (r > 25) {
			fail("O teste de performance falhou, o desempenho da API deverá "
					+ "ser no máximo 250% mais lento que a implementação sem r"
					+ "eflexão");
		}

	}

	/**
	 * Teste sem reflexão.
	 * 
	 * @return tempo de execução
	 */
	private long _testeSemReflexao() {
		long inicio = System.currentTimeMillis();

		for (int i = 0; i < getQuantidade(); i++) {
			AlunoTO to = new AlunoTO();
			to.setMatricula(i);
			to.setNome("Nome " + i);
			to.setSexo(getStringFactory().novoCharacter('M'));
		}

		long fim = System.currentTimeMillis();
		return (fim - inicio);
	}

	/**
	 * Teste com reflexão.
	 * 
	 * @return tempo de execução
	 * @throws ReflexaoException
	 */
	private long _testeComReflexao() throws ReflexaoException {
		long inicio = System.currentTimeMillis();

		for (int i = 0; i < getQuantidade(); i++) {
			AlunoTO to = UtilReflexaoConstrutor.invocar(AlunoTO.class);
			UtilReflexaoPropriedade.set(to, "matricula", getNumeroFactory()
					.novoInteger(i));
			UtilReflexaoPropriedade.set(to, "nome", "Nome " + i);
			UtilReflexaoPropriedade.set(to, "sexo", getStringFactory()
					.novoCharacter('M'));
		}

		long fim = System.currentTimeMillis();
		return (fim - inicio);
	}

	/**
	 * @return quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}
}
