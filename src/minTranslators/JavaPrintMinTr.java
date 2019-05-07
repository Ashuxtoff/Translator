package minTranslators;

import iMinTranslator.IMinTranslator;
import token.Token;

public class JavaPrintMinTr implements IMinTranslator{

	public String key = "print";
	
	public Token toGeneral(Token current) {
		int i = current.getText().indexOf('(') + 1;
		StringBuilder sb = new StringBuilder();
		sb.append("print ");
		while (current.getText().charAt(i) != ')') {
			sb.append(current.getText().charAt(i));
			i++;
		}
		return new Token("print", sb.toString());	
	}

	public Token toCurrent(Token general) {
		StringBuilder sb = new StringBuilder();
		sb.append("System.out.println(");
		sb.append(general.getText());
		sb.append(");");
		return new Token("print", sb.toString());
	}
	
	public String getKey() {
		return this.key;
	}
}
