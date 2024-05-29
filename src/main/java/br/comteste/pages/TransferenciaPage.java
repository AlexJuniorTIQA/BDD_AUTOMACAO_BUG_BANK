package br.comteste.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TransferenciaPage {

	@FindBy(how = How.XPATH, using = "//input[@type='accountNumber']")
	public WebElement campoNumeroDaConta;

	@FindBy(how = How.XPATH, using = "//input[@type='digit']")
	public WebElement campoDigitoVerificadorDaConta;
	
	@FindBy(how = How.XPATH, using = "//input[@type='transferValue']")
	public WebElement campoValorDaTransferencia;

	@FindBy(how = How.XPATH, using = "//input[@type='description']")
	public WebElement campoDescricao;

	@FindBy(how = How.XPATH, using = "//button[@type='submit'][text() = 'Transferir agora']")
	public WebElement btnTransferirAgora;

	@FindBy(how = How.XPATH, using = "//p[@id='modalText'][contains(text(), 'Transferencia realizada com sucesso')]")
	public WebElement popUpTextoTransferenciaRealizadaComSucesso;

	@FindBy(how = How.ID, using = "btnCloseModal")
	public WebElement btnFechar;

	@FindBy(how = How.ID, using = "btnBack")
	public WebElement btnVoltar;





}
