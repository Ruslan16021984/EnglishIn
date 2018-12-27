package com.gmail.carbit3333333;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Translator translator = new Translator();
		File fileEnglishIn = new File("E:\\Prog.Kiev.ua.Java\\jakioop\\Java нно-1\\English.txt");
		File ukrainionOut = new File("Ukrainian.out");
		translator.interactivAdd();
		try {
			ukrainionOut.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File("Save Dictionary.txt");
		try {
			file.createNewFile();
			translator.saveTranslatorOnDisk(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		translator.translete(fileEnglishIn, ukrainionOut);
	}
}
