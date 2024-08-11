import sys
input = sys.stdin.readline

N = int(input())
countDict = dict()

for i in range(N) :
    bookTitle = str(input())[:-1] # 개행문자 제거

    if bookTitle not in countDict : # 딕셔너리에 저장되어있지 않은 제목이라면
        countDict[bookTitle] = 1 # 초기값 1로 세팅
    else : # 이미 저장된 값이라면
        countDict[bookTitle] += 1 # 기존 value값에 1 추가 

maxValue = max(countDict.values()) # 가장 많이 팔린 책의 갯수 확인
ansDict = dict()

# 많이 팔린 책의 갯수가 같은 요소를 ansDict에 저장
for key, value in countDict.items() :
    if value == maxValue :
        ansDict[key] = value

# 저장된 요소들 중에서 key값이 가장 작은 (= 유니코드 기준)
# key값 출력
print(min(ansDict.keys()))
