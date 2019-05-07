package readers;

import baseReader.BaseReader;
import token.Token;

public class PascalPrintReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		if (initialText.length() >= index && initialText.charAt(index-1) == ';')
			this.state = this.states[0];
		return initialText.length() >= index && initialText.charAt(index-1) == ';';
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.length() >= index + 7 && initialText.substring(index, index+7).equals("writeln"))
			this.state = this.states[1];
		return initialText.length() >= index + 7 && initialText.substring(index, index+7).equals("writeln");
	}

	protected Token correctType(String string) {
		return new Token("print", string);
	}
}
