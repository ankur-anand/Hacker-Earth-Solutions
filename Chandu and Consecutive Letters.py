def return_string(input_string1):
	listString = list(input_string1)
	return_list = [listString[0]]
	for x in xrange(len(listString) - 1):
		if listString[x] != listString[x + 1]:
			return_list.append(listString[x + 1])
	
	retur_string = "".join(return_list)
	return retur_string
 
 
total_input =int(raw_input())
 
while total_input > 0:
	total_input -= 1
	input_string1 = raw_input()
	print return_string(input_string1)
