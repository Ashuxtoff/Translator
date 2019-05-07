package iLanguage;

import java.util.HashMap;
import iMinTranslator.IMinTranslator;
import token.Token;

public interface ILanguage {
	public String type = "";
	public void register(IMinTranslator minTr);
	public Token[] tokenize(String input);
	public IMinTranslator getMinTr(String key);
	public String gatherItems(Token[] tokens); 
}
