package taskTwoVerTwo;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LetterCounter {

	private String text;

	public LetterCounter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your text: ");
		this.text = sc.nextLine();
		if (this.text.trim().length() == 0) {
			throw new IllegalArgumentException(
					"Please enter correct text contatining letters from the English alphabet");
		}
	}

	void run() {
		
		HashMap<Character, Integer> letterMap = this.initalMap(this.text);
		TreeMap<Character, Integer> newLeeterList = reArrangeMap(letterMap);
		this.printResult(newLeeterList);
	}

	private HashMap<Character, Integer> initalMap(String text) {
	
		char[] chars = text.toLowerCase().toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < text.length(); i++) {
			if (chars[i] >= 'a' && chars[i] <= 'z') {
				if (map.containsKey(chars[i])) {
					Integer newIntValue = map.get(chars[i]) + 1;
					map.put(chars[i], newIntValue);
				} else {
					map.put(chars[i], 1);
				}
			}
		}
		return map;
	}

	private TreeMap<Character, Integer> reArrangeMap(HashMap<Character, Integer> map) {

		TreeMap<Character, Integer> reArranged = new TreeMap<>((o1,o2) -> map.get(o1).compareTo(map.get(o2)) != 0
			    ? -map.get(o1).compareTo(map.get(o2)) : o1.compareTo(o2));
		
		reArranged.putAll(map);
		return reArranged;

	}

	private void printResult(TreeMap<Character, Integer> finalMap) {
		
		for (Entry<Character, Integer> e : finalMap.entrySet()) {
			System.out.println(Character.toUpperCase(e.getKey()) + ": " + e.getValue() + " "
					+ new String(new char[((20/finalMap.firstEntry().getValue()) * e.getValue())]).replace("\0", "#"));
		}

	}

}
