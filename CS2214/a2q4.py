
import math

def isPrime(pn):
    #use the fact that all primes numbers (that are not 2 and 3) can be represented in the form 6k+1 or 6k-1
    #also since function is always greater than 41, we don't have to worry about 2 and 3

    if pn%6!=1 and pn%6!=5:
        return False

    #loop from 2 to sqrt(pn) to check if pn is prime
    for i in range(2, int(math.sqrt(pn))+1):
        if pn%i==0:
            return False
    
    return True

#let p(n) = n^2 + n + 41, find the smallest positive integer n such that p(n) is not a prime number
def partA():
    n = 1

    #loop to test out all values of n
    while True:
        #equation given
        pn = n**2 + n + 41

        #if p(n) is not a prime number, print the value of n and break out of the loop
        if not isPrime(pn):
            print("part A: ", n)
            break

        #increment n value if the value is not a prime number
        n += 1

#let p(n) = n^2 - 79n + 1601, find the smallest positive integer n such that p(n) is not a prime number
def partB():
    n = 1

    #loop to test out all values of n
    while True:
        #equation given
        pn = n**2 - 79*n + 1601

        #if p(n) is not a prime number, print the value of n and break out of the loop
        if not isPrime(pn):
            print("part B: ", n)
            break
        
        #increment n value if the value is not a prime number
        n += 1
        

partA()
partB()