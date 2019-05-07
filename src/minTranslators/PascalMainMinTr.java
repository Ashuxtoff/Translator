package minTranslators;

import iMinTranslator.IMinTranslator;
import token.Token;

public class PascalMainMinTr implements IMinTranslator{

	public String key = "main";
	
	public Token toGeneral(Token current) {
		return new Token("main", "main");
	}

	public Token toCurrent(Token general) {
		return new Token("main", "begin\n");
	}
	
	public String getKey() {
		return this.key;
	}
}
