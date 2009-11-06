/*
 * UtilJdbc.java
 * 
 * Data de criação: 27/07/2007
 */
package br.com.ap.comum.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import br.com.ap.comum.excecao.JdbcException;
import br.com.ap.comum.log.LogAbstrato;
import br.com.ap.comum.objeto.UtilObjeto;
import br.com.ap.comum.objeto.UtilPrimitivo;
import br.com.ap.comum.string.UtilString;
import br.com.ap.comum.util.UtilJdbcException;
import br.com.ap.comum.util.UtilLog;
import br.com.ap.comum.validador.UtilValidadorDeNumerosIguais;
import br.com.ap.comum.validador.UtilValidadorDeStringsIguais;

/**
 * Classe utilitária responsável pelo tratamento de objetos da API JDBC.
 * 
 * @author adrianop
 */
public final class UtilJdbc {

    private UtilJdbc() {
	// Construtor
    }

    /**
     * Retorna novo Statement.
     * 
     * @param conexao Conexão
     * @param sql Instrução SQL
     * @return PreparedStatement
     * @throws JdbcException Exceção vinda da api do JDBC
     */
    public static PreparedStatement novoPreparedStatement(Connection conexao,
	    String sql) throws JdbcException {
	PreparedStatement statement = null;

	if (isReferencia(conexao) && !isVazio(sql)) {
	    try {
		statement = conexao.prepareStatement(sql);
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoCriarOStatement(e);
	    }
	}

	return statement;
    }

    /**
     * Retorna novo CallableStatement.
     * 
     * @param conexao Conexão
     * @param sql Instrução SQL
     * @return CallableStatement
     * @throws JdbcException Exceção vinda da api do JDBC
     */
    public static CallableStatement novoCallableStatement(Connection conexao,
	    String sql) throws JdbcException {
	CallableStatement statement = null;

	if (isReferencia(conexao) && !isVazio(sql)) {
	    try {
		statement = conexao.prepareCall(sql);
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoCriarOStatement(e);
	    }
	}

	return statement;
    }

    /**
     * Executa um statement.
     * 
     * @param statement PreparedStatement
     * @return true se o primeiro resultado for um resultset.
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see PreparedStatement#execute()
     */
    public static boolean executar(PreparedStatement statement)
	    throws JdbcException {
	boolean resultado = false;

	if (isReferencia(statement)) {
	    try {
		resultado = statement.execute();
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoInvocarSQL(e, "");
	    }
	}
	return resultado;
    }

    /**
     * Executa um statement.
     * 
     * @param statement PreparedStatement
     * @return ResultSet
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see PreparedStatement#execute()
     */
    public static ResultSet executarQuery(PreparedStatement statement)
	    throws JdbcException {
	ResultSet resultado = null;

	if (isReferencia(statement)) {
	    try {
		resultado = statement.executeQuery();
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoInvocarSQL(e, "");
	    }
	}
	return resultado;
    }

    /**
     * Executa um statement.
     * 
     * @param statement PreparedStatement
     * @param sql Instrução SQL
     * @return ResultSet
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see PreparedStatement#execute()
     */
    public static ResultSet executarQuery(PreparedStatement statement,
	    String sql) throws JdbcException {
	ResultSet resultado = null;

	if (isReferencia(statement) && !isVazio(sql)) {
	    try {
		resultado = statement.executeQuery(sql);
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoInvocarSQL(e, sql);
	    }
	}
	return resultado;
    }

    /**
     * Executa um statement.
     * 
     * @param statement PreparedStatement
     * @return quantidade de registros afetados.
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see PreparedStatement#execute()
     */
    public static int executarUpdate(PreparedStatement statement)
	    throws JdbcException {
	int resultado = 0;

	if (isReferencia(statement)) {
	    try {
		resultado = statement.executeUpdate();
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoInvocarSQL(e, "");
	    }
	}
	return resultado;
    }

    /**
     * Executa um statement.
     * 
     * @param statement PreparedStatement
     * @param sql Instrução SQL
     * @return quantidade de registros afetados.
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see PreparedStatement#execute()
     */
    public static int executarUpdate(PreparedStatement statement, String sql)
	    throws JdbcException {
	int resultado = 0;

	if (isReferencia(statement) && !isVazio(sql)) {
	    try {
		resultado = statement.executeUpdate(sql);
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoInvocarSQL(e, sql);
	    }
	}
	return resultado;
    }

    /**
     * Executa um statement.
     * 
     * @param statement CallableStatement
     * @return true se o primeiro resultado for um resultset.
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see PreparedStatement#execute()
     */
    public static boolean executar(CallableStatement statement)
	    throws JdbcException {
	boolean resultado = false;

	if (isReferencia(statement)) {
	    try {
		resultado = statement.execute();
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoInvocarSQL(e, "");
	    }
	}
	return resultado;
    }

    /**
     * Executa um statement.
     * 
     * @param statement CallableStatement
     * @return ResultSet
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see PreparedStatement#execute()
     */
    public static ResultSet executarQuery(CallableStatement statement)
	    throws JdbcException {
	ResultSet resultado = null;

	if (isReferencia(statement)) {
	    try {
		resultado = statement.executeQuery();
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoInvocarSQL(e, "");
	    }
	}
	return resultado;
    }

    /**
     * Executa um statement.
     * 
     * @param statement CallableStatement
     * @param sql Instrução SQL
     * @return ResultSet
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see PreparedStatement#execute()
     */
    public static ResultSet executarQuery(CallableStatement statement,
	    String sql) throws JdbcException {
	ResultSet resultado = null;

	if (isReferencia(statement) && !isVazio(sql)) {
	    try {
		resultado = statement.executeQuery(sql);
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoInvocarSQL(e, sql);
	    }
	}
	return resultado;
    }

    /**
     * Executa um statement.
     * 
     * @param statement CallableStatement
     * @return quantidade de registros afetados.
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see PreparedStatement#execute()
     */
    public static int executarUpdate(CallableStatement statement)
	    throws JdbcException {
	int resultado = 0;

	if (isReferencia(statement)) {
	    try {
		resultado = statement.executeUpdate();
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoInvocarSQL(e, "");
	    }
	}
	return resultado;
    }

    /**
     * Executa um statement.
     * 
     * @param statement CallableStatement
     * @param sql Instrução SQL
     * @return quantidade de registros afetados.
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see PreparedStatement#executeUpdate()
     */
    public static int executarUpdate(CallableStatement statement, String sql)
	    throws JdbcException {
	int resultado = 0;

	if (isReferencia(statement) && !isVazio(sql)) {
	    try {
		resultado = statement.executeUpdate(sql);
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoInvocarSQL(e, sql);
	    }
	}
	return resultado;
    }

    /**
     * Retorna o objeto da coluna do statement.
     * 
     * @param statement CallableStatement.
     * @param indice Índice da coluna do statement.
     * @return Objeto referênte à coluna do statement.
     * @throws JdbcException Exceção vinda da api do JDBC
     */
    public static Object getObjeto(CallableStatement statement, int indice)
	    throws JdbcException {
	Object res = null;

	if (isReferencia(statement)) {
	    try {
		res = statement.getObject(indice);
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoRecuperarAColunaDoCallable(
			indice, e);
	    }
	}
	return res;
    }

    /**
     * Retorna o objeto da coluna do resultset.
     * 
     * @param resultSet ResultSet.
     * @param coluna Coluna do resultset.
     * @return Objeto referênte à coluna do resultset.
     * @throws JdbcException Exceção vinda da api do JDBC
     */
    public static Object getObjeto(ResultSet resultSet, String coluna)
	    throws JdbcException {
	Object res = null;

	if (isReferencia(resultSet)) {
	    try {
		res = resultSet.getObject(coluna);
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoRecuperarAColunaDoResultSet(
			coluna, e);
	    }
	}
	return res;
    }

    /**
     * Move o cursor para o próximo registro.
     * 
     * @param resultSet ResultSet.
     * @return true se o registro atual for válido.
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see ResultSet#next()
     */
    public static boolean isProximoRegistro(ResultSet resultSet)
	    throws JdbcException {
	boolean resultado = false;

	if (isReferencia(resultSet)) {
	    try {
		resultado = resultSet.next();
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoIrAoProximoRegistroDoResultset(e);
	    }
	}
	return resultado;
    }

    /**
     * Retorna o metadata do resultSet.
     * 
     * @param resultSet ResultSet.
     * @return metadata
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see ResultSet#getMetaData()
     */
    public static ResultSetMetaData getMetaData(ResultSet resultSet)
	    throws JdbcException {
	ResultSetMetaData resultado = null;

	if (isReferencia(resultSet)) {
	    try {
		resultado = resultSet.getMetaData();
	    } catch (SQLException e) {
		throw UtilJdbcException.erroAoRecuperarOMetadata(e);
	    }
	}
	return resultado;
    }

    /**
     * Quantidade de colunas do metadata.
     * 
     * @param metaData Metadata do resultset.
     * @return quantidade de colunas
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see ResultSetMetaData#getColumnCount()
     */
    public static int getColunas(ResultSetMetaData metaData)
	    throws JdbcException {
	int resultado = 0;

	if (isReferencia(metaData)) {
	    try {
		resultado = metaData.getColumnCount();
	    } catch (SQLException e) {
		throw UtilJdbcException
			.erroAoRecuperarAQuantidadeDeColunasDoRegistro(e);
	    }
	}
	return resultado;
    }

    /**
     * Nome da coluna do metadata.
     * 
     * @param metaData Metadata do resultset.
     * @param indice Índice da coluna
     * @return nome da coluna
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see ResultSetMetaData#getColumnName(int)
     */
    public static String getNomeDaColuna(ResultSetMetaData metaData, int indice)
	    throws JdbcException {
	String resultado = null;

	if (isReferencia(metaData)) {
	    try {
		resultado = metaData.getColumnName(indice);
	    } catch (SQLException e) {
		throw UtilJdbcException
			.erroAoRecuperarONomeDaColunaDoRegistro(e);
	    }
	}
	return resultado;
    }

    /**
     * Nome da coluna do metadata.
     * 
     * @param metaData Metadata do resultset.
     * @param indice Índice da coluna
     * @return nome da coluna
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see ResultSetMetaData#getColumnName(int)
     */
    public static String getTipoDaColuna(ResultSetMetaData metaData, int indice)
	    throws JdbcException {
	String resultado = null;

	if (isReferencia(metaData)) {
	    try {
		resultado = metaData.getColumnTypeName(indice);
	    } catch (SQLException e) {
		throw UtilJdbcException
			.erroAoRecuperarOTipoDaColunaDoRegistro(e);
	    }
	}
	return resultado;
    }

    /**
     * Código do tipo da coluna do metadata.
     * 
     * @param metaData Metadata do resultset.
     * @param indice Índice da coluna
     * @return código da coluna.
     * @throws JdbcException Exceção vinda da api do JDBC
     * @see ResultSetMetaData#getColumnName(int)
     * @see java.sql.Types
     */
    public static int getCodigoDoTipoDaColuna(ResultSetMetaData metaData,
	    int indice) throws JdbcException {
	int resultado = 0;

	if (isReferencia(metaData)) {
	    try {
		resultado = metaData.getColumnType(indice);
	    } catch (SQLException e) {
		throw UtilJdbcException
			.erroAoRecuperarOTipoDaColunaDoRegistro(e);
	    }
	}
	return resultado;
    }

    /**
     * Fecha o statement.
     * 
     * @param statement Statement
     * @return PreparedStatement.
     */
    public static Statement fechar(Statement statement) {
	if (isReferencia(statement)) {
	    try {
		statement.close();
	    } catch (SQLException e) {
		getLog().warn("Não foi possível fechar o statement", e);
	    } finally {
		statement = null;
	    }
	}
	return statement;
    }

    /**
     * Fecha o resultset.
     * 
     * @param resultSet ResultSet
     * @return ResultSet
     */
    public static ResultSet fechar(ResultSet resultSet) {
	if (isReferencia(resultSet)) {
	    try {
		resultSet.close();
	    } catch (SQLException e) {
		getLog().warn("Não foi possível fechar o resultset", e);
	    } finally {
		resultSet = null;
	    }
	}
	return resultSet;
    }

    /**
     * Fecha a conexão.
     * 
     * @param conexao Connection
     * @return Connection
     */
    public static Connection fechar(Connection conexao) {
	if (isReferencia(conexao)) {
	    try {
		conexao.close();
	    } catch (SQLException e) {
		getLog().warn("Não foi possível fechar a conexão", e);
	    } finally {
		conexao = null;
	    }
	}
	return conexao;
    }

    /**
     * Fecha a conexão, statement e resultset.
     * 
     * @param conexao Connection
     * @param statement Statement
     * @param resultSet ResultSet
     */
    public static void fechar(Connection conexao, Statement statement,
	    ResultSet resultSet) {
	fechar(resultSet);
	fechar(statement);
	fechar(conexao);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param _byte parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(byte _byte) {
	byte valorDefault = UtilPrimitivo.getValorDefaultByte();
	return UtilValidadorDeNumerosIguais.validar(_byte, valorDefault);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param _short parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(short _short) {
	short valorDefault = UtilPrimitivo.getValorDefaultShort();
	return UtilValidadorDeNumerosIguais.validar(_short, valorDefault);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param _int parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(int _int) {
	int valorDefault = UtilPrimitivo.getValorDefaultInt();
	return UtilValidadorDeNumerosIguais.validar(_int, valorDefault);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param _long parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(long _long) {
	long valorDefault = UtilPrimitivo.getValorDefaultLong();
	return UtilValidadorDeNumerosIguais.validar(_long, valorDefault);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param _char parâmetro validado
     * @return booleano
     */
    @SuppressWarnings("boxing")
    public static boolean isNulo(char _char) {
	char valorDefault = UtilPrimitivo.getValorDefaultChar();
	return UtilValidadorDeStringsIguais.validar(_char, valorDefault);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param _float parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(float _float) {
	float valorDefault = UtilPrimitivo.getValorDefaultFloat();
	return UtilValidadorDeNumerosIguais.validar(_float, valorDefault);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param _double parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(double _double) {
	double valorDefault = UtilPrimitivo.getValorDefaultDouble();
	return UtilValidadorDeNumerosIguais.validar(_double, valorDefault);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(Byte objeto) {
	return !UtilObjeto.isReferencia(objeto) || isNulo(objeto.byteValue());
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(Short objeto) {
	return !UtilObjeto.isReferencia(objeto) || isNulo(objeto.shortValue());
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(Integer objeto) {
	return !UtilObjeto.isReferencia(objeto) || isNulo(objeto.intValue());
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(Character objeto) {
	return !UtilObjeto.isReferencia(objeto) || isNulo(objeto.charValue());
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(Boolean objeto) {
	return !UtilObjeto.isReferencia(objeto);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(Float objeto) {
	return !UtilObjeto.isReferencia(objeto) || isNulo(objeto.floatValue());
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(Double objeto) {
	return !UtilObjeto.isReferencia(objeto) || isNulo(objeto.doubleValue());
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(String objeto) {
	return !UtilObjeto.isReferencia(objeto);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(Date objeto) {
	return !UtilObjeto.isReferencia(objeto);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(Time objeto) {
	return !UtilObjeto.isReferencia(objeto);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(Timestamp objeto) {
	return !UtilObjeto.isReferencia(objeto);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(InputStream objeto) {
	return !UtilObjeto.isReferencia(objeto);
    }

    /**
     * Retorna true se o parâmetro for nulo para o JDBC.
     * 
     * @param objeto parâmetro validado
     * @return booleano
     */
    public static boolean isNulo(Reader objeto) {
	return !UtilObjeto.isReferencia(objeto);
    }

    /**
     * Retorna true se o objeto tiver referência.
     * 
     * @param objeto Objeto validado.
     * @return true se o objeto tiver referência.
     */
    private static boolean isReferencia(Object objeto) {
	return UtilObjeto.isReferencia(objeto);
    }

    /**
     * Retorna true se a string for vazia.
     * 
     * @param string String validada
     * @return true se a string for vazia.
     */
    private static boolean isVazio(String string) {
	return UtilString.isVazio(string);
    }

    /**
     * Retorna LogAbstrato.
     * 
     * @return LogAbstrato
     */
    private static LogAbstrato getLog() {
	return UtilLog.getLog();
    }

}
