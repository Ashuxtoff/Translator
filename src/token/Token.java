package token;

public class Token {
	private final String varType;
	private final String text;
	private final String type;

	public Token(String type, String text, String varType) {
		super();
		this.type = type;
		this.text = text;
		this.varType = varType;
	}

	public Token(String type, String text) {
		this(type, text, "");
	}

	public String getVarType() {
		return varType;
	}

	public String getType() {
		return type;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return type + "[" + text + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Token other = (Token) obj;
		return type.equals(other.type) && varType.equals(other.varType)
				&& text.equals(other.text);
	}
}