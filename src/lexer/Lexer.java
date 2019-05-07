package lexer;

import java.util.ArrayList;
import baseReader.BaseReader;
import token.Token;

public class Lexer {
	private ArrayList<BaseReader> readersList;
	
	public Lexer(ArrayList<BaseReader> readers) {
		this.readersList = new ArrayList<BaseReader>();
		for (BaseReader reader : readers)
			this.readersList.add(reader);
	}

	public Token[] tokenize(String input) {
		ArrayList<Token> resultList = new ArrayList<Token>();
		int index = 0;
		while (index < input.length()) {
			Token t = null;
		    for (int i = 0; i < readersList.size(); i++) {
		    	BaseReader temp = readersList.get(i);
		    	t = temp.readToken(input, index);
		    	if (t != null) {
		    		resultList.add(t);
		    		break;
		    	}		    		  	
		    }		    
		    if (t == null) return resultList.toArray(new Token[resultList.size()]);
		    else
		    	index += resultList.get(resultList.size() - 1).getText().length();
		}
		return resultList.toArray(new Token[resultList.size()]);
	}
	
	public void register(BaseReader reader) {
		this.readersList.add(reader);
	}	
}
