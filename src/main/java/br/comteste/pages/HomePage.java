package br.comteste.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	@FindBy(how = How.XPATH, using = "//button[text() = 'Registrar']")
	public WebElement btnRegistrar;

	@FindBy(how = How.XPATH, using = "(//input[@type='email'])[1]")
	public WebElement campoEmail;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='password'])[1]")
	public WebElement campoSenha;

	@FindBy(how = How.XPATH, using = "//button[@type='submit'][text() = 'Acessar']")
	public WebElement btnAcessar;
	
	
}
