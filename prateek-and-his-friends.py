# Don't use for loop in python for this algorithm

def is_invitation_possible(num_f, money, ith_list):
	ith_list = ith_list or [] # SafeGuarding
	sum_t = 0
	j = 0
	_le = len(ith_list)
	i = 0
	while i < _le:
		#print(i)
		if sum_t + ith_list[i] <= money:
			sum_t += ith_list[i]
		else:
			sum_t -= ith_list[j]
			j += 1
			i = i - 1
			#print("Loop",i)
		if sum_t == money:
			return True
		i += 1
		#print("sum",sum_t)
	return False


no_testCase = int(input())

for test_case in range(no_testCase):
	n_x = input().split()
	num_f = int(n_x[0])
	money = int(n_x[1])
	ith_list = []
	for i in range(num_f):
		ith_list.append(int(input()))
	flag = is_invitation_possible(num_f, money, ith_list)
	if flag:
		print("YES")
	else:
		print("NO")
