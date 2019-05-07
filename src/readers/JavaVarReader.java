package readers;

import baseReader.BaseReader;
import token.Token;

public class JavaVarReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		if (initialText.charAt(index) == ';')
			this.state = this.states[0];
		return initialText.charAt(index) == ';';
	}

	protected boolean canStart(String initialText, int index) {
		int i = index;
		if (initialText.length() < 5)
			return false;
		while (initialText.charAt(i) != '=') {
			if (initialText.charAt(i) == ';' || (Character.isWhitespace(initialText.charAt(i)) && initialText.charAt(i) != ' '))
				return false;
			i++;		
		}
		this.state = this.states[1];
		return true;
	}

	protected Token correctType(String string) {
		return new Token("var", string);
	}
}
