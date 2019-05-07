package readers;

import baseReader.BaseReader;
import token.Token;

public class JavaBeginReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		if (initialText.charAt(index-1) == '{')
			this.state = this.states[0];
		return initialText.charAt(index-1) == '{';
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.charAt(index) == '{') 
			this.state = this.states[1];
		return initialText.charAt(index) == '{';
	}

	protected Token correctType(String string) {
		return new Token("begin", string);
	}
}
