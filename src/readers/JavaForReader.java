package readers;

import baseReader.BaseReader;
import token.Token;

public class JavaForReader extends BaseReader{

	private int bracketsIndex = 0;
	
	protected boolean checkTokenEnd(String initialText, int index) {
		int i = bracketsIndex;
		int bracketsCounter = 0;
		if (initialText.charAt(index-1) == ')') {
			while (i < index) {
				if (initialText.charAt(i) == '(')
					bracketsCounter++;
				if (initialText.charAt(i) == ')')
					bracketsCounter--;
				i++;
			}
			if (bracketsCounter == 0) {
				this.state = this.states[0];
				return true;
			}
		}		
		return false;
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.length() >= index + 4 && initialText.substring(index, index+4).equals("for(")) {
			this.state = this.states[1];
		}
		return initialText.length() >= index + 4 && initialText.substring(index, index+4).equals("for(");
	}

	protected Token correctType(String string) {
		return new Token("for", string);
	}
}
