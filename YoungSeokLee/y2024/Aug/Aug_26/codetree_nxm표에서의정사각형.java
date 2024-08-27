package y2024.Aug.Aug_26;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;
public class codetree_nxm표에서의정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stk.nextToken()), m = Integer.parseInt(stk.nextToken());

        int[][] chart = new int[n][m];
        int cnt = 0;

        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                chart[i][j] = Integer.parseInt(stk.nextToken());
            }
        }


        int minSide = Math.min(n, m);
        bw.write(minSide+"");
        bw.newLine();
        bw.flush();

        for(int i = 1;i<=minSide;i++){
            for(int j = 0;j<(n-i+1);j++){
                for(int k =0;k<(m-i+1);k++){
                    int tempCnt = 0;
                    for(int l = 0;l<i;l++){
                        for(int o = 0;o<i;o++){
                            if(chart[l][o]==1){
                                tempCnt++;
                            }
                        }
                    }
                    if(tempCnt==i*i)
                        cnt++;
                }
            }
        }

        bw.write(cnt+"");
        bw.close();
        br.close();
    }
}
