package readers;

import baseReader.BaseReader;
import token.Token;

public class JavaMainReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		if (index >= 42 && initialText.substring(index-42, index-4).equals("public static void main(String[] args)") && initialText.charAt(index-1) == '{')
			this.state = this.states[0];
		return index >= 42 && initialText.substring(index-42, index-4).equals("public static void main(String[] args)") && initialText.charAt(index-1) == '{';
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.length() >= 38 && initialText.substring(index, index+38).equals("public static void main(String[] args)"))
			this.state = this.states[1];
		return initialText.length() >= 38 && initialText.substring(index, index+38).equals("public static void main(String[] args)");
	}

	protected Token correctType(String string) {
		return new Token("main", string);
	}
}
