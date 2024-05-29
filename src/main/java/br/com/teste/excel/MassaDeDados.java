package br.com.teste.excel;

import br.com.teste.excel.ExcelUtils;

import static br.com.teste.excel.ExcelUtils.*;

public class MassaDeDados {

	int colunaEmail = 0;
	int colunaNome = 1;
	int colunaSenha = 2;
	int colunaConfirmarSenha = 3;
	int colunaNmCompletoDaConta = 4;
	int colunaNmDaConta = 5;
	int colunaDvDaConta = 6;
	int colunaSaldoDaConta = 7;
	int colunaVlrDaTransferencia = 8;
	int colunaDescDaTransferencia = 9;

	public String getEmail(int linhaMassaDeDados) throws Exception {
		setExcelFile("./MassaDeDados.xlsx", "TesteComSucesso");
		String email = getCellData(linhaMassaDeDados, colunaEmail);
		return email;
	}

	public String getNome(int linhaMassaDeDados) throws Exception {
		setExcelFile("./MassaDeDados.xlsx", "TesteComSucesso");
		String nome = getCellData(linhaMassaDeDados, colunaNome);
		return nome;
	}

	public String getSenha(int linhaMassaDeDados) throws Exception {
		setExcelFile("./MassaDeDados.xlsx", "TesteComSucesso");
		String senha = getCellData(linhaMassaDeDados, colunaSenha);
		return senha;
	}

	public String getConfirmarSenha(int linhaMassaDeDados) throws Exception {
		setExcelFile("./MassaDeDados.xlsx", "TesteComSucesso");
		String confirmarSenha = getCellData(linhaMassaDeDados, colunaConfirmarSenha);
		return confirmarSenha;
	}

	public void setNumeroDaConta( int linhaMassaDeDados, String numeroConta, String dvDaConta)throws Exception {
		setCellData(numeroConta+ "-" +dvDaConta, linhaMassaDeDados, colunaNmCompletoDaConta, "./MassaDeDados.xlsx", "TesteComSucesso");
		setCellData(numeroConta, linhaMassaDeDados, colunaNmDaConta, "./MassaDeDados.xlsx", "TesteComSucesso");
		setCellData(dvDaConta, linhaMassaDeDados, colunaDvDaConta, "./MassaDeDados.xlsx", "TesteComSucesso");
	}
	public void setSaldoDaConta( int linhaMassaDeDados, String saldoDaConta)throws Exception {
		setCellData(saldoDaConta,linhaMassaDeDados, colunaSaldoDaConta, "./MassaDeDados.xlsx", "TesteComSucesso");
	}

	public String getNumeroDaContaCompleto(int linhaMassaDeDados) throws Exception {
		setExcelFile("./MassaDeDados.xlsx", "TesteComSucesso");
		String numeroDaContaCompleto = getCellData(linhaMassaDeDados, colunaNmCompletoDaConta);
		return numeroDaContaCompleto;
	}

	public String getNumeroDaConta(int linhaMassaDeDados) throws Exception {
		setExcelFile("./MassaDeDados.xlsx", "TesteComSucesso");
		String numeroDaConta = getCellData(linhaMassaDeDados, colunaNmDaConta);
		return numeroDaConta;
	}
	public String getDvDaConta(int linhaMassaDeDados) throws Exception {
		setExcelFile("./MassaDeDados.xlsx", "TesteComSucesso");
		String dvDaConta = getCellData(linhaMassaDeDados, colunaDvDaConta);
		return dvDaConta;
	}
	public String getValorDaTransferencia(int linhaMassaDeDados) throws Exception {
		setExcelFile("./MassaDeDados.xlsx", "TesteComSucesso");
		String vlrDaTransferencia = getCellData(linhaMassaDeDados, colunaVlrDaTransferencia);
		return vlrDaTransferencia;
	}
	public String getSaldo(int linhaMassaDeDados) throws Exception {
		setExcelFile("./MassaDeDados.xlsx", "TesteComSucesso");
		String saldoDaConta = getCellData(linhaMassaDeDados, colunaSaldoDaConta);
		return saldoDaConta;
	}
	public String getDescDaTransferencia(int linhaMassaDeDados) throws Exception {
		setExcelFile("./MassaDeDados.xlsx", "TesteComSucesso");
		String descDaTransferencia = getCellData(linhaMassaDeDados, colunaDescDaTransferencia);
		return descDaTransferencia;
	}




}
