package readers;

import baseReader.BaseReader;
import token.Token;

public class PascalMainEndReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		if (initialText.length()-1 == index && initialText.charAt(index) == '.')
			this.state = this.states[0];
	return initialText.length()-1 == index && initialText.charAt(index) == '.';
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.length() == index + 4 && initialText.substring(index, index+4).equals("end."))
			this.state = this.states[1];
		return initialText.length() == index + 4 && initialText.substring(index, index+4).equals("end.");
	}

	protected Token correctType(String string) {
		return new Token ("mainend", string);
	}
}
