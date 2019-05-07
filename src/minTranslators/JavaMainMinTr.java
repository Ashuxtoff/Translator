package minTranslators;

import iMinTranslator.IMinTranslator;
import token.Token;

public class JavaMainMinTr implements IMinTranslator{

	public String key = "main";
	
	public Token toGeneral(Token current) {
		return new Token("main", "main");
	}

	public Token toCurrent(Token general) {
		String string = "public static void main(String[] args)";
		return new Token("main", string);
	}
	
	public String getKey() {
		return this.key;
	}

}
