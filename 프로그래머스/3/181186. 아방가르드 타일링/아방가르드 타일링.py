def solution(n):
    A = [0, 1, 3, 10, 23, 62, 170] + [0] * n
    for i in range(7, n+1):
        A[i] = (A[i-1] + 2*A[i-2] + 6*A[i-3] + A[i-4] - A[i-6]) % 1000000007
    return A[n]