package readers;

import baseReader.BaseReader;
import token.Token;

public class PascalMainReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		if (initialText.substring(index-5, index) == "begin")
			this.state = this.states[0];
		return initialText.substring(index-5, index) == "begin";
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.indexOf("begin") == index)
			this.state = this.states[1];	
		return initialText.indexOf("begin") == index;
	}

	protected Token correctType(String string) {
		return new Token("main", string);
	}
}
