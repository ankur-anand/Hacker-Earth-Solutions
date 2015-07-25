__author__ = 'ankur'


def binary_search_iterative(listi, x):
    low = 0
    high = len(listi) - 1
    while low <= high:
        mid = low + (high - low) / 2
        if listi[mid] == x:
            return True
        elif listi[mid] < x:
            low = mid + 1
        else:
            high = mid - 1
    return False

def binary_search_recursive(listi, low, high, x):
    mid = low + (high - low) / 2
    if low <= high:
        if listi[mid] == x:
            return True
        elif listi[mid] < x:
            return binary_search_recursive(listi, mid + 1, high, x)
        else:
            return binary_search_recursive(listi, low, mid - 1, x)
    return False


inp = [int(i) for i in raw_input().split()]
N = inp[0]
Q = inp[1]
A = [int(i) for i in raw_input().split()]
A.sort()
output = list()
for i in range(Q):
    x = input()
    if binary_search_iterative(A, x):
        output.append("YES")
    else:
        output.append("NO")

for ele in output:
    print ele
