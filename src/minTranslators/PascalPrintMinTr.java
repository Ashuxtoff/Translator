package minTranslators;

import iMinTranslator.IMinTranslator;
import token.Token;

public class PascalPrintMinTr implements IMinTranslator{

	public String key = "print";
	
	public Token toGeneral(Token current) {
		return new Token("print", String.valueOf(current.getText().charAt(current.getText().length()-3)));
	}

	public Token toCurrent(Token general) {
		return new Token("print", "writeln(" + general.getText().charAt(general.getText().length()-1) + ");");
	}

	public String getKey() {
		return this.key;
	}
}
