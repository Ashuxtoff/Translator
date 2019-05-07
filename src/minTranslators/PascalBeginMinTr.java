package minTranslators;

import iMinTranslator.IMinTranslator;
import token.Token;

public class PascalBeginMinTr implements IMinTranslator{

	public String key = "begin";
	
	public Token toGeneral(Token current) {
		return new Token(current.getType(), "b");
	}

	public Token toCurrent(Token general) {
		return new Token(general.getType(), "begin\n");
	}
	
	public String getKey() {
		return this.key;
	}
}
