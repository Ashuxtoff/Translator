package readers;

import baseReader.BaseReader;
import token.Token;

public class JavaPrintReader extends BaseReader{

	protected boolean checkTokenEnd(String initialText, int index) {
		if (index >= 22 && initialText.substring(index-22, index).equals("System.out.println(a);"))
			this.state = this.states[0];
		return index >= 22 && initialText.substring(index-22, index).equals("System.out.println(a);");
	}

	protected boolean canStart(String initialText, int index) {
		if (initialText.length() >= index + 22 && initialText.substring(index, index+22).equals("System.out.println(a);"))
			this.state = this.states[1];
		return initialText.length() >= index + 22 && initialText.substring(index, index+22).equals("System.out.println(a);");
	}

	protected Token correctType(String string) {
		return new Token("print", string);
	}
}
