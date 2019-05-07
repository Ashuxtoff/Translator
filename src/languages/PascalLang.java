package languages;

import java.util.ArrayList;
import java.util.HashMap;

import baseReader.BaseReader;
import iLanguage.ILanguage;
import iMinTranslator.IMinTranslator;
import lexer.Lexer;
import readers.PascalBeginReader;
import readers.PascalEndReader;
import readers.PascalForReader;
import readers.PascalMainEndReader;
import readers.PascalMainReader;
import readers.PascalPrintReader;
import readers.PascalVarReader;
import token.Token;

public class PascalLang implements ILanguage{
	
	public String type = "pascal";
	public HashMap<String, IMinTranslator> keyMinTranslators;
	private Lexer lexer;	
	
	public PascalLang() {
		ArrayList<BaseReader> readers = new ArrayList<BaseReader>();
		readers.add(new PascalBeginReader());
		readers.add(new PascalEndReader());
		readers.add(new PascalForReader());
		readers.add(new PascalMainReader());
		readers.add(new PascalPrintReader());
		readers.add(new PascalVarReader());
		readers.add(new PascalMainEndReader());
		this.lexer = new Lexer(readers);
		this.keyMinTranslators = new HashMap<String, IMinTranslator>();
	}
	
	public void register(IMinTranslator minTr) {
		this.keyMinTranslators.put(minTr.getKey(), minTr);
	}
	
	public Token[] tokenize(String input) {
		ArrayList<Token> result = new ArrayList<Token>();
		int index = 0;
		while (index < input.length()) {
			while (index < input.length() && (Character.isWhitespace(input.charAt(index)) || input.charAt(index) == ';')) {
				index++;
			}
			Token[] tokens = this.lexer.tokenize(input.substring(index));
			if (tokens.length == 0)
				index++;
			else
				for (Token token : tokens) {
					index += token.getText().length();
					result.add(token);
				}
		}
		return result.toArray(new Token[result.size()]);
	}
	
	public IMinTranslator getMinTr(String key) {
		return this.keyMinTranslators.get(key);
	}

	public String gatherItems(Token[] tokens) {
		StringBuilder sb = new StringBuilder();
		for (Token item : tokens)
			sb.append(item.getText());
		return sb.toString();
	}
}
