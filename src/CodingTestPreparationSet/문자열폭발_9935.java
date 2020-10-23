package CodingTestPreparationSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		/*
		StringBuilder sb1 = new StringBuilder();
		sb1.append(s1);
		StringBuilder sb2 = new StringBuilder();
		sb2.append(s2);
		*/
		Stack<Character> st = new Stack<>();
		
		for (int i=0; i<s1.length(); i++) {
			st.add(s1.charAt(i));
			// 들어간게 s2의 마지막 글자고, 스택 사이즈가 s2 길이보다 크다면
			if (s1.charAt(i) == s2.charAt(s2.length()-1) && st.size() > s2.length()) {
				
			}
		}
		System.out.println(s1);
	}

}
