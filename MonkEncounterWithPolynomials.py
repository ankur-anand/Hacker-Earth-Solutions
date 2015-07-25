__author__ = 'ankur'

def get_lowest_x(a, b, c, k):
    answer = -1
    low = 0
    high = 100000
    if c >= k:
        return 0

    while low <= high:
        mid = low + (high - low) / 2
        left_side = (a * (mid * mid)) + (b * mid) + c
        if left_side >= k:
            answer = mid;
            high = mid - 1
        else:
            low = mid + 1
    return answer

t = int(raw_input())
while t >= 0:
    t -= 1
    a, b, c, k = map(int, raw_input().strip().split())
    print get_lowest_x(a, b, c, k)