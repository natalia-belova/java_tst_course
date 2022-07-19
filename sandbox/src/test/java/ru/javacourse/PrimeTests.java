package ru.javacourse;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {
    @Test
    public void testPrime1() {
        Assert.assertTrue(Primes.isPrime(3));
    }

    @Test
    public void testPrime2() {
        Assert.assertFalse(Primes.isPrime(4));
    }

    @Test
    public void testPrime3() {
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

        @Test
        public void testPrimeW1() {
            Assert.assertTrue(Primes.isPrimeWhile(3));
        }

        @Test
        public void testPrimeW2() {
            Assert.assertFalse(Primes.isPrimeWhile(4));
        }

        @Test
        public void testPrimeW3() {
            Assert.assertTrue(Primes.isPrimeWhile(Integer.MAX_VALUE));
        }
}
