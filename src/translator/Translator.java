package translator;

import java.util.ArrayList;
import java.util.HashMap;

import iLanguage.ILanguage;
import iMinTranslator.IMinTranslator;
import token.Token;

public class Translator {
	
	private HashMap<String, ILanguage> keyLanguages = new HashMap<String, ILanguage>();
	
	public void register(String key, ILanguage language) {
		this.keyLanguages.put(key, language);
	}
	
	public String translate(String keyInitial, String keyTarget, String source) {
		ILanguage initialLanguage = keyLanguages.get(keyInitial);
		ILanguage targetLanguage = keyLanguages.get(keyTarget);
		Token[] sourceTokens = initialLanguage.tokenize(source);
		ArrayList<Token> generalLangTokens = new ArrayList<Token>();
		for (Token token : sourceTokens) {
			Token generalToken = initialLanguage.getMinTr(token.getType()).toGeneral(token);
			generalLangTokens.add(generalToken);
			}
		ArrayList<Token> targetLangTokens = new ArrayList<Token>();
		for (Token token : generalLangTokens) {
			Token targetToken = targetLanguage.getMinTr(token.getType()).toCurrent(token);
			targetLangTokens.add(targetToken);
		}
		Token[] result = targetLangTokens.toArray(new Token[targetLangTokens.size()]);
		return targetLanguage.gatherItems(result);
	}
}
