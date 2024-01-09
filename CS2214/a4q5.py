
def lucas_lehmer(p):
    s = 4
    M = 2 ** p - 1
    for _ in range(2, p):
        s = (s * s - 2) % M
    return s == 0

def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def main():
    # Part a) Prime numbers not exceeding 62
    primes_up_to_62 = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61]

    print("Part a) primes for p not exceeding 62:")
    for p in primes_up_to_62:

        mp = 2 ** p - 1

        if is_prime(mp):
            print("M%d is prime." % p)
        else:
            print("M%d is not prime." % p)

    # Part b) Bonus: Prime numbers not exceeding 400
    primes_up_to_400 = [p for p in range(2, 401) if is_prime(p)]

    print("\nBonus Part b) Mersenne primes for p not exceeding 400:")
    for p in primes_up_to_400:
        if lucas_lehmer(p):
            print("M%d is prime." % p)
        else:
            print("M%d is not prime." % p)
            
main()
