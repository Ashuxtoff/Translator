package minTranslators;

import iMinTranslator.IMinTranslator;
import token.Token;

public class JavaVarMinTr implements IMinTranslator{

	public String key = "var";
	
	public Token toGeneral(Token current) {
		StringBuilder sb = new StringBuilder();
		String string = current.getText();
		int i = 0;
		String beforeEq = string.substring(0, string.indexOf('='));
		if (beforeEq.split(" ").length == 2) {
			String type = beforeEq.split(" ")[0];
			if (type.equals("int"))
				sb.append("integer ");
				sb.append(beforeEq.split(" ")[1]);
		}
		else 
			sb.append(beforeEq.split(" ")[0]);
		i = string.indexOf('=');
		while (!Character.isDigit(string.charAt(i)) && !Character.isLetter(string.charAt(i)))
			i++;
		sb.append(" = ");
		while (i < string.length()) {
			sb.append(string.charAt(i));
			i++;
		}
		return new Token("var", sb.toString());			
	}

	public Token toCurrent(Token general) {
		String string = general.getText();
		StringBuilder sb = new StringBuilder();
		String[] items = string.split(" ");
		if (items[0].equals("integer")) {
			sb.append("int ");
			int patternPartIndex = string.indexOf(items[1]+" ");
			sb.append(string.substring(patternPartIndex));
			sb.append(';');
		}
		else {
			int i = 0;
			while (Character.isWhitespace(string.charAt(i)))
				i++;
			sb.append(string.substring(i));
		}
		return new Token("var", sb.toString());
	}
	
	public String getKey() {
		return this.key;
	}

}
