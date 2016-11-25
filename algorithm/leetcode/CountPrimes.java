public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i * i < n; i++) {
            if(!isPrime[i]) continue;
            for(int j = i * i; j < n ; j += i) {
                isPrime[j] = false;
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 47;

        CountPrimes solution = new CountPrimes();
        System.out.printf("Primes count[1, %d]: %d\n", n, solution.countPrimes(n));
    }
}