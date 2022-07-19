package ru.javacourse;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {
    @Test(enabled = false)
//    3 - простое число
    public void testPrime1() {
        Assert.assertTrue(Primes.isPrime(3));
    }

    @Test(enabled = false)
    public void testPrime2() {
        Assert.assertFalse(Primes.isPrime(4));
    }

    @Test
//    2147483647 - простое число
    public void testPrime3() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test(enabled = false)
//    performance of such test is several times lower coz of 'long' data type
    public void testPrimeLong() {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }

    @Test(enabled = false)
    public void testPrimeW1() {
        Assert.assertTrue(Primes.isPrimeWhile(3));
    }

    @Test(enabled = false)
    public void testPrimeW2() {
        Assert.assertFalse(Primes.isPrimeWhile(4));
    }

    @Test
    public void testPrimeW3() {
        Assert.assertTrue(Primes.isPrimeWhile(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimeFast() {
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimeFastest() {
        Assert.assertTrue(Primes.isPrimeFastest(Integer.MAX_VALUE));
    }

}
