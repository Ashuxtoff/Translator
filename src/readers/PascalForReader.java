package readers;

import java.util.Arrays;

import baseReader.BaseReader;
import token.Token;

public class PascalForReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		if (initialText.length() >= 2 && index >= 2 && initialText.length() > index && initialText.substring(index-2, index).equals("do"))
			this.state = this.states[0];
		return initialText.length() >= 2 && index >= 2 && initialText.length() > index && initialText.substring(index-2, index).equals("do");
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.length() > index + 3 && initialText.substring(index, index+3).equals("for"))
			this.state = this.states[1];
		return initialText.length() > index + 3 && initialText.substring(index, index+3).equals("for");
	}

	protected Token correctType(String string) {
		return new Token("for", string);
	}
}
