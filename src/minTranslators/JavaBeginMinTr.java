package minTranslators;

import iMinTranslator.IMinTranslator;
import token.Token;

public class JavaBeginMinTr implements IMinTranslator{
	
	public String key = "begin";
	
	public Token toGeneral(Token current) {
		return new Token(current.getType(), "b");
	}

	public Token toCurrent(Token general) {
		return new Token(general.getType(), "{");
	}

	public String getKey() {
		return this.key;
	}
}