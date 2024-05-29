package br.com.teste.logic;

import br.com.teste.driver.StoredActions;
import br.comteste.pages.HomePage;
import br.comteste.pages.TransferenciaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TransferenciaLogic {

	private TransferenciaPage transferenciaPage;
	private StoredActions action;

	public TransferenciaLogic(WebDriver driver) {
		transferenciaPage = PageFactory.initElements(driver, TransferenciaPage.class);
		action = new StoredActions(driver);

	}

	public void insereNumeroDaConta(String texto) throws Exception {
		action.waitVisibilityOf(transferenciaPage.campoNumeroDaConta, 5);
		action.insertText(transferenciaPage.campoNumeroDaConta, texto);
	}
	public void insereDigitoVerificadorDaConta(String texto) {
		action.waitVisibilityOf(transferenciaPage.campoDigitoVerificadorDaConta,5);
		action.insertText(transferenciaPage.campoDigitoVerificadorDaConta, texto);
	}

	public void insereValorDaTransferencia(String texto) {
		action.waitVisibilityOf(transferenciaPage.campoValorDaTransferencia,5);
		action.insertText(transferenciaPage.campoValorDaTransferencia, texto);
	}

	public void insereDescricao(String texto) throws Exception {
		action.waitVisibilityOf(transferenciaPage.campoDescricao, 5);
		action.insertText(transferenciaPage.campoDescricao, texto);
	}

	public void clicaBtnTransferirAgora() throws Exception {
		action.waitElementToBeClickable(transferenciaPage.btnTransferirAgora, 5);
		action.click(transferenciaPage.btnTransferirAgora);

	}
	public boolean validaTransferenciaRealizadaComSucesso() {
		try {
			action.waitVisibilityOf(transferenciaPage.popUpTextoTransferenciaRealizadaComSucesso, 5);
			return true;
		}
		catch ( Exception e) {
			return false;
		}

	}
	public void clicaBtnFechar() throws Exception {
		action.waitElementToBeClickable(transferenciaPage.btnFechar, 5);
		action.click(transferenciaPage.btnFechar);
	}
	public void clicaBtnVoltar() throws Exception {
		action.waitElementToBeClickable(transferenciaPage.btnVoltar, 5);
		action.click(transferenciaPage.btnVoltar);
	}

}
