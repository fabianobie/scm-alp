/*
 * PaginacaoConsultaHolder.java
 * 
 * Data de criação: 20/06/2008
 *
 * 
 * 
 */

package br.com.ap.arquitetura.holder;

/**
 * Classe para ecapsulamento de dados para consulta retorno com páginação.
 * 
 * @author AdrianoP
 */
public final class PaginacaoHolder extends HolderAbstrato {

    /**
     * Constroi o objeto.
     */
    private PaginacaoHolder() {
	// Construtor.
    }

    private static ThreadLocal<Integer> numeroPagina   = new ThreadLocal<Integer>();

    private static ThreadLocal<Integer> limiteRegistro = new ThreadLocal<Integer>();

    private static ThreadLocal<Integer> totalRegistros = new ThreadLocal<Integer>();

    /**
     * @return O numero da pagina na consulta
     */
    public static Integer getNumeroPagina() {
	return numeroPagina.get();
    }

    /**
     * Atribui o valor do numero da pagina.
     * 
     * @param _numeroPagina Valor que será atribuído.
     */
    public static void setNumeroPagina(Integer _numeroPagina) {
	numeroPagina.set(_numeroPagina);
    }

    /**
     * @return o limite de registros que deverá ser retornada na consulta por
     *         página
     */
    public static Integer getLimiteRegistro() {
	return limiteRegistro.get();
    }

    /**
     * Atribui o valor do limite de registros.
     * 
     * @param _limiteRegistro Valor que será atribuído.
     */
    public static void setLimiteRegistro(Integer _limiteRegistro) {
	limiteRegistro.set(_limiteRegistro);
    }

    /**
     * @return O total de registros existentes para a consulta
     */
    public static Integer getTotalRegistros() {
	return totalRegistros.get();
    }

    /**
     * Atribui o valor do total de registros.
     * 
     * @param _totalRegistros Valor que será atribuído.
     */
    public static void setTotalRegistros(Integer _totalRegistros) {
	totalRegistros.set(_totalRegistros);
    }

}
