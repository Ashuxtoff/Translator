package minTranslators;

import iMinTranslator.IMinTranslator;
import token.Token;

public class PascalForMinTr implements IMinTranslator{

	public String key = "for";
	
	public Token toGeneral(Token current) {
		String string = current.getText();
		int i = 3;
		StringBuilder sb = new StringBuilder();
		while (Character.isWhitespace(string.charAt(i)))
			i++;
		while (string.charAt(i) != ':' && string.charAt(i) != ' ') {
			sb.append(string.charAt(i));
			i++;
		}
		String startVar = sb.toString();
		sb.setLength(0);
		i += 4;
		while (string.charAt(i) != ' ') {
			sb.append(string.charAt(i));
			i++;
		}
		String startValue = sb.toString();
		sb.setLength(0);
		while (string.charAt(i) == ' ' || string.charAt(i) == 't' || string.charAt(i) == 'o')
			i++;
		while (string.charAt(i) != ' ') {
			sb.append(string.charAt(i));
			i++;
		}
		String finishVar = sb.toString();
		sb.setLength(0);
		sb.append(startVar);
		sb.append(' ');
		sb.append(startValue);
		sb.append(" <= ");
		sb.append(finishVar);
		return new Token("for", sb.toString(), current.getVarType());
	}

	public Token toCurrent(Token general) {
		String string = general.getText();
		String[] items = string.split(" ");
		StringBuilder sb = new StringBuilder();
		sb.append("var ");
		sb.append(items[1]);
		sb.append(" : integer;\n");
		sb.append("for ");
		sb.append(items[1]);
		sb.append(" := ");
		sb.append(items[2]);
		sb.append(" to ");
		sb.append(items[4]);
		if (items[3].equals("<"))
			sb.append("-1");
		sb.append(" do ");
		return new Token("for", sb.toString(),"integer");		
	}
	
	public String getKey() {
		return this.key;
	}
}
