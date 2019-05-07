package readers;

import baseReader.BaseReader;
import token.Token;

public class PascalEndReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		if (index >= 4 && initialText.substring(index-4, index-1).equals("end"))
			this.state = this.states[0];
		return index >= 4 && initialText.substring(index-4, index-1).equals("end");
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.length() > index + 4 && initialText.substring(index, index+3).equals("end") && initialText.charAt(index+4) != '.')
			this.state = this.states[1];
		return initialText.length() > index + 4 && initialText.substring(index, index+3).equals("end") && initialText.charAt(index+4) != '.';
	}

	protected Token correctType(String string) {
		return new Token("end", string);
	}
}
