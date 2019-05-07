package minTranslators;

import iMinTranslator.IMinTranslator;
import token.Token;

public class PascalEndMinTr implements IMinTranslator{

	public String key = "end";
	
	public Token toGeneral(Token current) {
		return new Token(current.getType(), "e");
	}

	public Token toCurrent(Token general) {
		return new Token(general.getType(), "end;");
	}
	
	public String getKey() {
		return this.key;
	}
}
