class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans = ans << 1;      // Make space for next bit
            ans |= (n & 1);      // Copy last bit of n
            n = n >>> 1;         // Unsigned right shift
        }

        return ans;
    }
}