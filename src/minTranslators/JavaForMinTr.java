package minTranslators;

import iMinTranslator.IMinTranslator;
import token.Token;

public class JavaForMinTr implements IMinTranslator{

	public String key = "for";
	
	public Token toGeneral(Token current) {
		String string = current.getText();
		String brackets = string.substring(string.indexOf('('));
		int i = 1;
		while (!Character.isLetter(brackets.charAt(i)))
			i++;
		String type = brackets.substring(i, i+3);
		StringBuilder sb = new StringBuilder();
		if (type.equals("int"))
			sb.append("integer ");
		while (brackets.charAt(i) != ' ')
			i++;
		while (!Character.isLetter(brackets.charAt(i))) {
			i++;
		}
		while (Character.isLetter(brackets.charAt(i))) {
			sb.append(brackets.charAt(i));
			i++;
		}
		String startVariable = sb.toString();
		sb.setLength(0);
		while (!Character.isDigit(brackets.charAt(i)) && !Character.isLetter(brackets.charAt(i))) 
			i++;
		while (Character.isDigit(brackets.charAt(i)) || Character.isLetter(brackets.charAt(i))) {
			sb.append(brackets.charAt(i));
			i++;
		}
		String startValue = sb.toString();
		sb.setLength(0);
		while (Character.isDigit(brackets.charAt(i))) {
			sb.append(brackets.charAt(i));
			i++;
		}
		i = brackets.indexOf(';');
		String sign = "<";
		while(brackets.charAt(i) != '<')
			i++;
		if (brackets.charAt(i+1) == '=')
			sign = "<=";
		i += 2;
		while (brackets.charAt(i) != ';') {
			sb.append(brackets.charAt(i));
			i++;
		}
		String finishVariable = sb.toString();
		sb.setLength(0);
		sb.append(startVariable);
		sb.append(' ');
		sb.append(startValue);		
		sb.append(' ');
		sb.append(sign);
		sb.append(' ');
		sb.append(finishVariable);
		return new Token("for", sb.toString());	
	}

	public Token toCurrent(Token general) {
		StringBuilder sb = new StringBuilder();
		sb.append("for (");
		String[] items = general.getText().split(" ");
		sb.append(items[0]);
		sb.append(" = ");
		sb.append(items[1]);
		sb.append("; ");
		sb.append(items[0]);
		sb.append(" <");
		if (items[2].charAt(1) == '=')
			sb.append("=");
		sb.append(" ");
		sb.append(items[3]);
		sb.append("; ");
		sb.append(items[0]);
		sb.append("++)");
		return new Token("for", sb.toString(), general.getVarType());
	}
	
	public String getKey() {
		return this.key;
	}
}
