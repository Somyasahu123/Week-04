package annotations.practiceproblems.advanced.cacheresult;

class ExpensiveComputation {

    @CacheResult
    public int computeFactorial(int n) {
        System.out.println("Computing factorial of " + n);
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * computeFactorial(n - 1);
    }
}

