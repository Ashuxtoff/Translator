package readers;

import baseReader.BaseReader;
import token.Token;

public class JavaMainEndReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		this.state = this.states[0];
		return true;
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.length()-1 == index && initialText.charAt(index) == '}')
			this.state = this.states[1];		
		return initialText.length()-1 == index && initialText.charAt(index) == '}';
	}

	protected Token correctType(String string) {
		return new Token ("mainend", string);
	}
}
