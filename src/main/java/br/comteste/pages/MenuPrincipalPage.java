package br.comteste.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuPrincipalPage {

	@FindBy(how = How.XPATH, using = "//p[@id='textAccountNumber']//span")
	public WebElement numeroDaConta;
	
	@FindBy(how = How.XPATH, using = "//p[@id='textBalance']//span")
	public WebElement saldoDaConta;

	@FindBy(how = How.ID, using = "btn-TRANSFERÊNCIA")
	public WebElement btnTransferencia;

	@FindBy(how = How.ID, using = "btnExit")
	public WebElement btnSair;
}