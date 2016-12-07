#### Solution One using Graph
#### Total Time 1.03335

test = int(input())
 
for t in range(test):
	e = int(input())
	visited =[False] * 10001
	for xy in range(e):
		x, y = map(int, input().split())
		visited[x] = True
		visited[y] = True
	
	count = 0
	for i in range(10001):
		if(visited[i]):
			visited[i] = False
			count += 1
	print(count)


#### Solution 2 - Using Set
#### Time - 0.91461

test = int(input())

for t in range(test):
	e = int(input())
	resis = set()
	for xy in range(e):
		x, y = map(int, input().split())
		resis.update([x,y])
	
	result = len(resis)	
	print(result)
