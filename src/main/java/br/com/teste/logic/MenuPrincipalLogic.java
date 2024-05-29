package br.com.teste.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.teste.driver.StoredActions;
import br.comteste.pages.MenuPrincipalPage;

public class MenuPrincipalLogic {

	private MenuPrincipalPage menuPrincipalPage;
	private StoredActions action;

	public MenuPrincipalLogic(WebDriver driver) {
		menuPrincipalPage = PageFactory.initElements(driver, MenuPrincipalPage.class);
		action = new StoredActions(driver);

	}

	public String getSaldo(){
		action.waitVisibilityOf(menuPrincipalPage.saldoDaConta,10);
	return	action.getText(menuPrincipalPage.saldoDaConta);
	}
	public String getNumeroDaConta(){
		action.waitVisibilityOf(menuPrincipalPage.numeroDaConta,10);
		return	action.getText(menuPrincipalPage.numeroDaConta);
	}
	public String getSaldoDaConta(){
		action.waitVisibilityOf(menuPrincipalPage.saldoDaConta,10);
		return	action.getText(menuPrincipalPage.saldoDaConta);
	}
	public void clicaBtnTransferencia(){
		action.waitVisibilityOf(menuPrincipalPage.btnTransferencia,10);
		action.click(menuPrincipalPage.btnTransferencia);

	}

	public void clicaBtnSair(){
		action.waitVisibilityOf(menuPrincipalPage.btnSair,10);
		action.click(menuPrincipalPage.btnSair);

	}


}
