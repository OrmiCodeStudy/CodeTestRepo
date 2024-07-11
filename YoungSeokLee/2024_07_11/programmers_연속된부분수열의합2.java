//시간 초과때문에 58.8점이 나옴

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,0,Integer.MAX_VALUE};

        for(int i=0;i<sequence.length;i++){
            int sumVal = 0;
            int seqLength = sequence.length;
            for(int j = i; j<seqLength;j++){
                sumVal += sequence[j];
                if(k == sumVal){
                    seqLength = j-i;
                    if(seqLength < answer[2]){
                        answer = new int[]{i,j,seqLength};
                        break;
                    }
                } else if (sumVal>k){
                    break;
                }
            }
        }
        answer = new int[]{answer[0],answer[1]};
        return answer;
    }
}