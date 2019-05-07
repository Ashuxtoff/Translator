package readers;

import baseReader.BaseReader;
import token.Token;

public class JavaEndReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		if (initialText.charAt(index-1) == '}')
			this.state = this.states[0];
		return initialText.charAt(index-1) == '}';
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.charAt(index) == '}' && initialText.length() != 1) 
			this.state = this.states[1];
		return initialText.charAt(index) == '}' && initialText.length() != 1;
	}

	protected Token correctType(String string) {
		return new Token("end", string);
	}
}
