package com.gmail.carbit3333333;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class Translator {
	private Map<String, String> dictionary = new HashMap<>();

	public Translator() {
		super();
		addWords();
	}

	public Map<String, String> getDictionaty() {
		return dictionary;
	}

	public void setDictionaty(Map<String, String> dictionaty) {
		this.dictionary = dictionaty;
	}
	private void addWords() {
		 dictionary.put("Our","����");
	        dictionary.put("Earth","�����");
	        dictionary.put("so","���");
	        dictionary.put("beautiful","����������");
	        dictionary.put("There","�����");
	        dictionary.put("lot","�����");
	        dictionary.put("blue","�������");
	        dictionary.put("rivers","�����");
	        dictionary.put("lakes","�����");
	        dictionary.put("oceans","�����");
	        dictionary.put("full","�����");
	        dictionary.put("wonders","�����");
	        dictionary.put("high","������");
	        dictionary.put("mountains","����");
	        dictionary.put("covered","�������");
	        dictionary.put("with","�");
	        dictionary.put("snow","����");
	        dictionary.put("wonderful","���������");
	        dictionary.put("fields","����");
	        dictionary.put("forests","����");
	        dictionary.put("and","�");
	        dictionary.put("different","������");
	        dictionary.put("plants","��������");
	        dictionary.put("animals","��������");
	}
	public void interactivAdd() {
		String wordEng = "";
		String wordTrans = "";
		
		
		try {
			wordEng = String.valueOf(JOptionPane.showInputDialog("������� ����� �� ����������"));
			wordTrans = String.valueOf(JOptionPane.showInputDialog("�������:"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"NumberFormatException");
		}catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null,"NullPointerException");
		}
		dictionary.put(wordEng, wordTrans);
	}
	
	public void translete(File textInEnglish, File clearFile) {
		if(textInEnglish == null || clearFile == null) {
			System.out.println("NOT GO");
			throw new IllegalArgumentException();
			
		}
		System.out.println("GO");
		StringBuilder builder = new StringBuilder();
		String englishWords = getWordsOnText(textInEnglish);
		String[] englishArray = getArrayWords(englishWords);
		Set<String> keys = dictionary.keySet();
		for (String string : englishArray) {
			for (String key : keys) {
				if(string.equals(key)) {
					builder.append(dictionary.get(key) +  " ");
				}
			}
		}
		
		saveTranslate(builder.toString(), clearFile);
	}

	private void saveTranslate(String string, File clearFile) {
		try (PrintWriter writer = new PrintWriter(clearFile)){
			writer.print(string);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private String[] getArrayWords(String englishWords) {
		String[] wordsArray = englishWords.split("[,:;.!?\\s]+");
		return wordsArray;
	}

	private String getWordsOnText(File textInEnglish) {
		if(textInEnglish == null) {
			System.out.println("getWordsOnText");
			throw new IllegalArgumentException();
		}
		StringBuilder builder = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(textInEnglish))){
			String text = "";
			for(;(text = reader.readLine())!= null;) {
				builder.append(text);
				builder.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(builder.toString());
		return builder.toString();
	}
	
	public void saveTranslatorOnDisk(File fileDictionary) {
		if(dictionary == null) {
			throw new IllegalArgumentException();
		}
		StringBuilder builder = new StringBuilder();
		Set<String> keys = dictionary.keySet();
		for (String key : keys) {
			builder.append(key + " - " + dictionary.get(key));
			builder.append(System.lineSeparator());
		}
		saveTranslate(builder.toString(), fileDictionary);
	}
	
	
	
}
