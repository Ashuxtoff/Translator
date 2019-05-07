package minTranslators;

import javax.security.auth.Subject;

import iMinTranslator.IMinTranslator;
import token.Token;

public class PascalVarMinTr implements IMinTranslator{

	public String key = "var";
	
	public Token toGeneral(Token current) {
		String string = current.getText();
		StringBuilder sb = new StringBuilder();
		if (string.substring(0, 4).equals("var ")){
			String firstStr = string.substring(0, string.indexOf(';'));
			String[] items = firstStr.split(" ");
			sb.append(items[3]);
			sb.append(" ");
			sb.append(items[1]);
			sb.append(" = ");
			sb.append("0");
		}
		else {
			sb.append(string.substring(0, string.indexOf(":")));
			sb.append(string.substring(string.indexOf(":")+1));
		}
		return new Token ("var", sb.toString());
	}

	public Token toCurrent(Token general) {
		StringBuilder sb = new StringBuilder();
		String string = general.getText();
		int indexEq = string.indexOf('=');
		String[] firstItems = string.substring(0, indexEq).split(" ");
		String varType = "";
		if (firstItems.length == 2) {		
			varType = firstItems[0];
			sb.append("var ");
			sb.append(firstItems[1]);
			sb.append(" : ");
			sb.append(varType);
			sb.append(";");
			string = string.substring(string.indexOf(" "));
		}
		else varType = general.getVarType();
		String[] items = string.split(" ");
		for (String item : items) {
			if (item.equals("="))
				sb.append(":=");
			else sb.append(item);
			sb.append(" ");
		}
		sb.append(';');
		return new Token("var", sb.toString(), varType);		
	}
	
	public String getKey() {
		return this.key;
	}
}
