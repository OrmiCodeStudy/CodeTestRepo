class Solution {
    // LRU 알고리즘 : 가장 오랫동안 참조되지 않은 페이지를 교체하는 기법

    // cache miss : 해야할 작업이 캐시에 없는 상태
    // 새로운 작업인 n번 작업을 cpu가 사용한다면 cache miss가 되고 모든 작업이 뒤로 밀림
    // 5번 작업은 캐시의 맨 앞에 위치함

    // cache hit : 해야할 작업이 캐시에 있는 상태
    // n번 작업이 캐시에 있는 상태에서 cpu가 사용한다면 cache hit이 된다
    // n번 작업 앞에 이미 캐시에 있는 작업은 한 칸 뒤로 밀리고 n번 작업이 맨 앞에 위치함.

    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return 5 * cities.length;
        }
        int answer = 0;
        String[] cache = new String[cacheSize];

        for(String city : cities) {
            city = city.toLowerCase();
            int pos = -1;
            for(int i = 0; i < cacheSize; i++) {
                if(city.equals(cache[i])) {
                    pos = i;
                }

            }
            if(pos == -1) { // cache miss
                answer += 5;
                for(int i = cacheSize - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }

            } else { // cache hit
                answer += 1;
                for(int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }

            }
            cache[0] = city;

        }

        return answer;
    }
}