package br.com.teste.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

public class GenericLogic {

	public GenericLogic(WebDriver driver) {

	}

	public static String getTimeStamp() {
		return new SimpleDateFormat("dd_MM_yyyy HH.mm.ss").format(Calendar.getInstance().getTime());
	}

	public  int converteValorStringParaInt(String valorStr){

		valorStr = valorStr.replace("R$", "").trim();

		// Remover pontos de separação de milhares
		valorStr = valorStr.replace(".", "");

		// Substituir vírgula decimal por ponto
		valorStr = valorStr.replace(",", ".");

		// Converter string para double
		double valorDouble = Double.parseDouble(valorStr);

		// Multiplicar por 100 para converter para centavos e arredondar para inteiro
		int valorCentavos = (int) Math.round(valorDouble * 100);

		return valorCentavos;

	}
}
