class Fancy {

    List<Long> arr = new ArrayList<>();
    long mul = 1;
    long add = 0;
    long MOD = 1000000007;

    public Fancy() {}

    private long modPow(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    private long modInv(long x) {
        return modPow(x, MOD - 2);
    }

    public void append(int val) {
        long normalized = (val - add + MOD) % MOD;
        normalized = (normalized * modInv(mul)) % MOD; // ❌ fails when mul = 0
        arr.add(normalized);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;

        long v = arr.get(idx);
        v = (v * mul + add) % MOD;
        return (int) v;
    }
}