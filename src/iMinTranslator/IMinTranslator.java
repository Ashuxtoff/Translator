package iMinTranslator;

import token.Token;

public interface IMinTranslator {
	public String getKey();
	public Token toGeneral(Token current);
	public Token toCurrent(Token general);
}
