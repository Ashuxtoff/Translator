package minTranslators;

import iMinTranslator.IMinTranslator;
import token.Token;

public class PascalMainEndMinTr implements IMinTranslator{

	private String key = "mainend";
	
	public String getKey() {
		return this.key;
	}

	public Token toGeneral(Token current) {
		return new Token ("mainend", "");
	}

	public Token toCurrent(Token general) {
		return new Token ("mainend", "end.");
	}
}
