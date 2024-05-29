package br.comteste.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CadastroPage {

	@FindBy(how = How.XPATH, using = "(//input[@type='email'])[2]")
	public WebElement campoEmail;

	@FindBy(how = How.XPATH, using = "//input[@type='name']")
	public WebElement campoNome;

	@FindBy(how = How.XPATH, using = "(//input[@name='password'])[2]")
	public WebElement campoSenha;

	@FindBy(how = How.XPATH, using = "//input[@name='passwordConfirmation']")
	public WebElement campoConfirmarSenha;

	@FindBy(how = How.ID, using = "toggleAddBalance")
	public WebElement btnCriarContaComSaldo;

	@FindBy(how = How.XPATH, using = "//button[@type='submit'][text() = 'Cadastrar']")
	public WebElement btnCadastrar;

	@FindBy(how = How.XPATH, using = "//p[@id='modalText'][contains(text(), 'foi criada com sucesso')]")
	public WebElement popUpTextoContaCriadaComSucesso;

	@FindBy(how = How.XPATH, using = "//a[@id='btnCloseModal'][text() = 'Fechar']")
	public WebElement popUpBtnFechar;



}