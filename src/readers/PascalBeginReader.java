package readers;

import baseReader.BaseReader;
import token.Token;

public class PascalBeginReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		if (index >= 5 && initialText.substring(index-5, index).equals("begin"))
			this.state = this.states[0];
		return index >= 5 && initialText.substring(index-5, index).equals("begin");
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.length() >= index+5 && initialText.substring(index, index+5).equals("begin"))
			this.state = this.states[1];
		return initialText.length() >= index+5 && initialText.substring(index, index+5).equals("begin");
	}

	protected Token correctType(String string) {
		return new Token("begin", string);
	}
}
