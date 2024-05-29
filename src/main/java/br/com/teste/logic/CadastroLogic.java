package br.com.teste.logic;

import br.comteste.pages.CadastroPage;
import com.mongodb.assertions.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.teste.driver.StoredActions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroLogic {

	private CadastroPage cadastroPage;
	private StoredActions action;

	public CadastroLogic(WebDriver driver) {
		cadastroPage = PageFactory.initElements(driver, CadastroPage.class);
		action = new StoredActions(driver);

	}
	public void insereEmail(String texto) {
		action.waitVisibilityOf(cadastroPage.campoEmail,5);
		action.clearText(cadastroPage.campoEmail);
		action.insertText(cadastroPage.campoEmail, texto);
	}
	public void insereNome(String texto) {
		action.waitVisibilityOf(cadastroPage.campoNome,5);
		action.clearText(cadastroPage.campoNome);
		action.insertText(cadastroPage.campoNome, texto);
	}
	public void insereSenha(String texto) {
		action.waitVisibilityOf(cadastroPage.campoSenha,5);
		action.clearText(cadastroPage.campoSenha);
		action.insertText(cadastroPage.campoSenha, texto);
	}

	public void insereConfirmaSenha(String texto) {
		action.clearText(cadastroPage.campoConfirmarSenha);
		action.insertText(cadastroPage.campoConfirmarSenha, texto);
	}

	public void clicaBtnCriarContaComSaldo() {
		action.click(cadastroPage.btnCriarContaComSaldo);
	}
	public void clicaBtnCadastrar() {
		action.waitElementToBeClickable(cadastroPage.btnCadastrar,5);
		action.click(cadastroPage.btnCadastrar);
	}
	public boolean validaContaCriadaComSucesso() {
	try {
		action.waitVisibilityOf(cadastroPage.popUpTextoContaCriadaComSucesso, 5);
		return true;
	}
		catch ( Exception e) {
			return false;
		}

	}
	public String getNumeroContaCriada(){
		String textoNumeroDaConta=  action.getText(cadastroPage.popUpTextoContaCriadaComSucesso);
		int  indexHifen= textoNumeroDaConta.indexOf('-');
		String antesDoHifen = textoNumeroDaConta.substring(0, indexHifen);

		StringBuilder numeros = new StringBuilder();
		for (char c : antesDoHifen.toCharArray()) {
			if (Character.isDigit(c)) {
				numeros.append(c);
			}
		}

		return numeros.toString();

	}

	public String getDvContaCriada(){
		String textoNumeroDaConta=  action.getText(cadastroPage.popUpTextoContaCriadaComSucesso);
		int  indexHifen= textoNumeroDaConta.indexOf('-');
		String depoisDoHifen = textoNumeroDaConta.substring(indexHifen + 1);

		StringBuilder numeros = new StringBuilder();
		for (char c : depoisDoHifen.toCharArray()) {
			if (Character.isDigit(c)) {
				numeros.append(c);
			}
		}

		return numeros.toString();

	}

	public void clicaBtnFechar() {
		action.waitVisibilityOf(cadastroPage.popUpBtnFechar, 5);
		action.click(cadastroPage.popUpBtnFechar);
	}



}
