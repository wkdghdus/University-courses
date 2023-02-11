# Prelab question 4
# D C B
# A: False
# B: 21
# C: True
# D: -1
# E: False
# F: 0


def factorial(n):
    result = 1
    for i in range(n, 0, -1):
        result *= i
    return result


def helloWorld():
    print("Hello World")

def helloWorldNTimes(n):
    for i in range(n):
        helloWorld()

def main():
    print(factorial(3))
    helloWorld()
    print()
    helloWorldNTimes(4)

main()