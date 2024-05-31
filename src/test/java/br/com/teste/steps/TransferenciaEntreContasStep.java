package br.com.teste.steps;

import br.com.teste.driver.DriverFactory;
import br.com.teste.excel.MassaDeDados;
import br.com.teste.logic.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;


public class TransferenciaEntreContasStep {

	private WebDriver driver;
	private CadastroLogic cadastroLogic;
	private HomeLogic homeLogic;
	private MenuPrincipalLogic menuPrincipalLogic;
	private TransferenciaLogic transferenciaLogic;
	private MassaDeDados massaDeDados;
	private GenericLogic genericLogic;
	int primeiraConta = 1;
	int segundaConta = 2;

	@Before

	public void Driver() throws Exception {
		driver = DriverFactory.getDriver();
		cadastroLogic = new CadastroLogic(driver);
		homeLogic = new HomeLogic(driver);
		menuPrincipalLogic = new MenuPrincipalLogic(driver);
		transferenciaLogic = new TransferenciaLogic(driver);
		genericLogic = new GenericLogic(driver);
		massaDeDados = new MassaDeDados();




	}
	@Dado("que eu esteja na HomePage do site bugbank e clico no btnRegistar")
	public void que_eu_esteja_na_HomePage_do_site_bugbank_e_clico_no_btnRegistar() throws Exception {
		homeLogic.clicaBtnRegistrar();
	}

	@Quando("crio uma conta sem saldo guardando as informacoes")
	public void crio_uma_conta_sem_saldo_guardando_as_informacoes()throws Exception {
		cadastroLogic.insereEmail(massaDeDados.getEmail(primeiraConta));
		cadastroLogic.insereNome(massaDeDados.getNome(primeiraConta));
		cadastroLogic.insereSenha(massaDeDados.getSenha(primeiraConta));
		cadastroLogic.insereConfirmaSenha(massaDeDados.getConfirmarSenha(primeiraConta));
		cadastroLogic.clicaBtnCadastrar();

		Assertions.assertTrue(cadastroLogic.validaContaCriadaComSucesso());
		massaDeDados.setNumeroDaConta(primeiraConta,cadastroLogic.getNumeroContaCriada(), cadastroLogic.getDvContaCriada());

		cadastroLogic.clicaBtnFechar();

	}

	@E("crio uma segunda conta com saldo guardando as informacoes")
	public void crio_uma_segunda_conta_com_saldo_guardando_as_informacoes() throws Exception {

		homeLogic.clicaBtnRegistrar();
		cadastroLogic.insereEmail(massaDeDados.getEmail(segundaConta));
		cadastroLogic.insereNome(massaDeDados.getNome(segundaConta));
		cadastroLogic.insereSenha(massaDeDados.getSenha(segundaConta));
		cadastroLogic.insereConfirmaSenha(massaDeDados.getConfirmarSenha(segundaConta));
		cadastroLogic.clicaBtnCriarContaComSaldo();
		cadastroLogic.clicaBtnCadastrar();

		Assertions.assertTrue(cadastroLogic.validaContaCriadaComSucesso());
		massaDeDados.setNumeroDaConta(segundaConta,cadastroLogic.getNumeroContaCriada(), cadastroLogic.getDvContaCriada());

		cadastroLogic.clicaBtnFechar();


	}
	@E("efetuo o login transferindo saldo para primeira conta")
	public void efetuo_o_login_transferindo_saldo_para_primeira_conta() throws Exception {
		int primeiraConta = 1;
		int segundaConta = 2;

		homeLogic.insereCampoEmail(massaDeDados.getEmail(segundaConta));
		homeLogic.insereCampoSenha(massaDeDados.getSenha(segundaConta));
		homeLogic.clicaBtnAcessar();

		Assertions.assertEquals(massaDeDados.getNumeroDaContaCompleto(segundaConta),menuPrincipalLogic.getNumeroDaConta());
		massaDeDados.setSaldoDaConta(segundaConta, menuPrincipalLogic.getSaldoDaConta());

		menuPrincipalLogic.clicaBtnTransferencia();

		transferenciaLogic.insereNumeroDaConta(massaDeDados.getNumeroDaConta(primeiraConta));
		transferenciaLogic.insereDigitoVerificadorDaConta(massaDeDados.getDvDaConta(primeiraConta));
		transferenciaLogic.insereValorDaTransferencia(massaDeDados.getValorDaTransferencia(segundaConta));
		transferenciaLogic.insereDescricao(massaDeDados.getDescDaTransferencia(segundaConta));
		transferenciaLogic.clicaBtnTransferirAgora();

		Assertions.assertTrue(transferenciaLogic.validaTransferenciaRealizadaComSucesso());

		transferenciaLogic.clicaBtnFechar();
		transferenciaLogic.clicaBtnVoltar();

		int saldoAnterior = genericLogic.converteValorStringParaInt(massaDeDados.getSaldo(segundaConta));
		int saldoTransferencia = genericLogic.converteValorStringParaInt(massaDeDados.getValorDaTransferencia(segundaConta));
		int saldoVigente = genericLogic.converteValorStringParaInt(menuPrincipalLogic.getSaldoDaConta());

		Assertions.assertEquals(saldoVigente,saldoAnterior - saldoTransferencia);

		menuPrincipalLogic.clicaBtnSair();

	}

	@Entao("valido o resultado de uma transferencia entre ambas as contas")
	public void valido_o_resultado_de_uma_transferencia_entre_ambas_as_contas() throws Exception {

		homeLogic.insereCampoEmail(massaDeDados.getEmail(primeiraConta));
		homeLogic.insereCampoSenha(massaDeDados.getSenha(primeiraConta));
		homeLogic.clicaBtnAcessar();

		int saldoVigente = genericLogic.converteValorStringParaInt(menuPrincipalLogic.getSaldoDaConta());
		int saldoTransferencia = genericLogic.converteValorStringParaInt(massaDeDados.getValorDaTransferencia(segundaConta));

		Assertions.assertEquals(saldoVigente,saldoTransferencia);
	}

	@After
	public void closeDriver() {

		DriverFactory.quit();
	}

}
