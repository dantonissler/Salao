package main.java.tools;

import javax.swing.text.MaskFormatter;

public class MaskFormatterNew {

	/**
	 * @author Danton Issler
	 * @author Sara Jovanice
	 */

	public MaskFormatter Mascara(String Mascara) {
		MaskFormatter F_Mascara = new MaskFormatter();
		try {
			F_Mascara.setMask(Mascara);
			F_Mascara.setPlaceholderCharacter(' ');
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return F_Mascara;
	}
}
