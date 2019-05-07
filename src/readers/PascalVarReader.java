package readers;

import baseReader.BaseReader;
import token.Token;

public class PascalVarReader extends BaseReader{
	
	private boolean isAssigment = false;

	protected boolean checkTokenEnd(String initialText, int index) {		
		if (initialText.charAt(index-1) == ';')
			this.state = this.states[0];
		return initialText.charAt(index-1) == ';';
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.length() > index + 4 && initialText.substring(index, index+4).equals("var ")) {
			this.state = this.states[1];
			this.isAssigment = true;
		}
		else {
			String sub = initialText.substring(index);
			int indexEq = sub.indexOf(":=");
			if (indexEq == -1) return false; 
			String beforeEq = initialText.substring(0, indexEq);
			if (beforeEq.split(" ").length > 1)
				return false;
			int i = index;
			while (i < initialText.length() && initialText.charAt(i) != '=') {
				if (initialText.charAt(i) == ';')
					return false;
				i++;		
			}
			this.state = this.states[1];
			return !(i == initialText.length());
		}
		return initialText.length() >= 4 && initialText.substring(index, index+4).equals("var ");
		
	}

	protected Token correctType(String string) {
		return new Token("var", string);
	}
}
