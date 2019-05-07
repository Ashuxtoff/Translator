package languages;

import java.util.ArrayList;
import java.util.HashMap;

import baseReader.BaseReader;
import iLanguage.ILanguage;
import iMinTranslator.IMinTranslator;
import lexer.Lexer;
import readers.JavaBeginReader;
import readers.JavaEndReader;
import readers.JavaForReader;
import readers.JavaMainEndReader;
import readers.JavaMainReader;
import readers.JavaPrintReader;
import readers.JavaVarReader;
import token.Token;


public class JavaLang implements ILanguage{
	
	public String type = "java";
	public HashMap<String, IMinTranslator> keyMinTranslators;
	public Lexer lexer;	
	
	public JavaLang() {
		ArrayList<BaseReader> readers = new ArrayList<BaseReader>();
		readers.add(new JavaBeginReader());
		readers.add(new JavaEndReader());
		readers.add(new JavaForReader());
		readers.add(new JavaMainReader());
		readers.add(new JavaPrintReader());
		readers.add(new JavaVarReader());
		readers.add(new JavaMainEndReader());
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
			if (tokens == null)
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
		sb.append("public class Main\r\n" + 
				"{");
		for (Token item : tokens)
			sb.append(item.getText());
		sb.append('}');		
		return sb.toString();
	}
}