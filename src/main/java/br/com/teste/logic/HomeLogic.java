package br.com.teste.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.teste.driver.StoredActions;
import br.comteste.pages.HomePage;

public class HomeLogic {

	private HomePage homePage;
	private StoredActions action;

	public HomeLogic(WebDriver driver) {
		homePage = PageFactory.initElements(driver, HomePage.class);
		action = new StoredActions(driver);

	}

	public void clicaBtnRegistrar() throws Exception {
		action.waitElementToBeClickable(homePage.btnRegistrar, 5);
		action.click(homePage.btnRegistrar);
	}
	public void insereCampoEmail(String texto) {
		action.waitVisibilityOf(homePage.campoEmail,5);
		action.insertText(homePage.campoEmail, texto);
	}

	public void insereCampoSenha(String texto) {
		action.waitVisibilityOf(homePage.campoSenha,5);
		action.insertText(homePage.campoSenha, texto);
	}

	public void clicaBtnAcessar() throws Exception {
		action.waitElementToBeClickable(homePage.btnAcessar, 5);
		action.click(homePage.btnAcessar);
		action.sleep(5);
	}
}
