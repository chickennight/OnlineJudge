for test_case in range(1, 11):
    n = int(input().strip())
    arr = list(map(int, input().split()))
    
    for _ in range(n):
        max_idx = arr.index(max(arr))
        arr[max_idx] -= 1
        min_idx = arr.index(min(arr))
        arr[min_idx] += 1
        ans = max(arr) - min(arr)
    print(f'#{test_case} {ans}')