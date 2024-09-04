# 재귀를 사용하여 재귀 횟수에 따른 챗봇의 응답을 출력하는 문제

import sys
input = sys.stdin.readline

n = int(input())
repeat = n

def recursion(n) :
    global repeat
    if n == 0 :
        print(underDash * abs(n - repeat) + str2)
        print(underDash * abs(n - repeat) + str4)
        print(underDash * abs(n - repeat) + str5)
    else :
        repeatDash = abs(n - repeat)
        print(underDash * repeatDash + str2)
        print(underDash * repeatDash + str3_1)
        print(underDash * repeatDash + str3_2)
        print(underDash * repeatDash + str3_3)
        recursion(n - 1)
        print(underDash * repeatDash + str5)
        repeat -= 1

str1 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다."
str2 = "\"재귀함수가 뭔가요?\""
str3_1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어."
str3_2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."
str3_3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
str4 = "\"재귀함수는 자기 자신을 호출하는 함수라네\""
str5 = "라고 답변하였지."
underDash = "____"

print(str1)
recursion(n)
