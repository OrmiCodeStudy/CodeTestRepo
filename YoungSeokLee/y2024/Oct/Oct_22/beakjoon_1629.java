package y2024.Oct.Oct_22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
곱셈 - 실버1

자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.

고속 거듭제곱 알고리즘 사용 (Divide & Conquer)
네, 이 코드는 고속 거듭제곱 알고리즘의 재귀적 구현입니다. 각 부분을 자세히 설명해 드리겠습니다.

## 함수 구조

```java
private static long fastExponentiation(long a, long b, long c) {
    // 함수 내용
}
```

- `a`: 밑수 (base)
- `b`: 지수 (exponent)
- `c`: 모듈러 값 (modulus)

이 함수는 (a^b) % c를 계산합니다.

## 기저 조건

```java
if (b == 0) return 1;
```

지수가 0일 경우, 어떤 수의 0승은 1이므로 1을 반환합니다.

## 재귀 호출

```java
long half = fastExponentiation(a, b / 2, c);
```

지수를 절반으로 나누어 재귀적으로 계산합니다. 이는 a^b를 (a^(b/2))^2로 변환하는 핵심 아이디어입니다.

## 중간 결과 계산

```java
long result = (half * half) % c;
```

재귀 호출의 결과를 제곱하고 모듈러 연산을 수행합니다. 이는 (a^(b/2))^2 % c를 계산하는 과정입니다.

## 홀수 지수 처리

```java
if (b % 2 == 1) result = (result * a) % c;
```

지수 b가 홀수일 경우, 추가로 a를 한 번 더 곱해줍니다. 이는 홀수 지수의 경우 a^b = a * a^(b-1)이기 때문입니다.

## 결과 반환

```java
return result;
```

최종 계산된 결과를 반환합니다.

## 동작 원리

1. 지수를 계속 2로 나누면서 재귀 호출을 합니다.
2. 지수가 0이 되면 1을 반환하며 재귀를 종료합니다.
3. 재귀에서 돌아오면서 결과를 제곱하고, 필요한 경우 추가 곱셈을 수행합니다.
4. 모든 과정에서 모듈러 연산을 적용하여 큰 수의 계산을 방지합니다.

이 알고리즘의 시간 복잡도는 O(log b)입니다. 지수 b를 계속 2로 나누기 때문에 로그 시간에 계산이 완료됩니다. 이는 일반적인 거듭제곱 방식(O(b))보다 훨씬 효율적입니다.

이 방식은 큰 수의 거듭제곱을 빠르게 계산해야 하는 상황, 특히 모듈러 연산이 필요한 경우(예: 암호학, 정수론 문제 등)에 매우 유용합니다.
 */
public class beakjoon_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        long answer = fastExponentiation(a, b, c);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    private static long fastExponentiation(long a, long b, long c) {
        if (b == 0) return 1;
        long half = fastExponentiation(a, b / 2, c);
        long result = (half * half) % c;
        if (b % 2 == 1) result = (result * a) % c;
        return result;
    }
}
