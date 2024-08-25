class Solution {
	public String solution(String s) {
		String answer = "";
		String[] words = s.split(" ", -1);

		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				if (i % 2 == 0) {
					answer += Character.toUpperCase(word.charAt(i));
				} else {
					answer += Character.toLowerCase(word.charAt(i));
				}
			}
			answer += " ";
		}

		return answer.substring(0, answer.length() - 1);
	}
}