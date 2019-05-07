package main;

import iLanguage.ILanguage;
import languages.JavaLang;
import languages.PascalLang;
import minTranslators.JavaBeginMinTr;
import minTranslators.JavaEndMinTr;
import minTranslators.JavaForMinTr;
import minTranslators.JavaMainEndMinTr;
import minTranslators.JavaMainMinTr;
import minTranslators.JavaPrintMinTr;
import minTranslators.JavaVarMinTr;
import minTranslators.PascalBeginMinTr;
import minTranslators.PascalEndMinTr;
import minTranslators.PascalForMinTr;
import minTranslators.PascalMainEndMinTr;
import minTranslators.PascalMainMinTr;
import minTranslators.PascalPrintMinTr;
import minTranslators.PascalVarMinTr;
import token.Token;
import translator.Translator;


public class Main {

	public static void main(String[] args) {
		Translator tr = new Translator();
		ILanguage pascal = new PascalLang();
		ILanguage java = new JavaLang();
		tr.register("java", java);
		tr.register("pascal", pascal);
		java.register(new JavaBeginMinTr());
		java.register(new JavaEndMinTr());
		java.register(new JavaForMinTr());
		java.register(new JavaMainMinTr());
		java.register(new JavaPrintMinTr());
		java.register(new JavaVarMinTr());
		java.register(new JavaMainEndMinTr());
		pascal.register(new PascalBeginMinTr());
		pascal.register(new PascalEndMinTr());
		pascal.register(new PascalForMinTr());
		pascal.register(new PascalMainMinTr());
		pascal.register(new PascalPrintMinTr());
		pascal.register(new PascalVarMinTr());
		pascal.register(new PascalMainEndMinTr());
		String source = "public static void main(String[] args)\r\n" + 
				"	{\r\n" + 
				"	  int a = 0;\r\n" + 
				"	  for(int i = 0; i < 10; ++i)\r\n" + 
				"          \r\n" + 
				"		a = a + 1;\r\n" + 
				"		for(int j = 0; j < 10; j++)\r\n" + 
				"				for(int k = 0; k < 10; k++)\r\n" + 
				"				k = 5;\r\n" + 
				"	  }\r\n" + 
				"	  System.out.println(a);\r\n" + 
				"	}";
		String result = tr.translate("java", "pascal", source);
		System.out.println(result);
	}

}
