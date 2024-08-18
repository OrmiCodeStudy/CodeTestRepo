class Solution {
	public int solution(int number, int limit, int power) {
		int answer = 0;

		for (int i = 1; i <= number; i++) {
			int divCount = 0;
			for (int j = 1; j * j <= i; j++) {
				if (i % j == 0) {
					if (j * j == i) {
						divCount++;
					} else {
						divCount += 2;
					}
				}
			}

			if (divCount > limit) {
				answer += power;
			} else {
				answer += divCount;
			}
		}

		return answer;
	}
}