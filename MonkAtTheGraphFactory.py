n = int(input())
degVal = (map(int, input().split()))
degSum = sum(degVal)

if (degSum // 2) == (n - 1):
	print("Yes")
else:
	print("No")	
