__author__ = 'ankur'

def monkiness(list_one, list_two, size):
    answer = -1
    position = 0
    for i in xrange(size):
        low = 0
        high = size - 1
        while low <= high:
            mid = low + (high - low) / 2
            if list_two[mid] >= list_one[i]:
                position = mid
                low = mid + 1
            else:
                high = mid - 1
            answer = max(answer, position)
    return answer

tc = int(raw_input())
while tc > 0:
    tc -= 1
    size_array = int(raw_input())
    list_a = map(long, raw_input().strip().split())
    list_b = map(long, raw_input().strip().split())
    print(monkiness(list_a, list_b, size_array))