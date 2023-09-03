package com.github.shannonbay.waterwheel;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.function.Predicate;

import static com.github.shannonbay.waterwheel.SequenceDSL.*;

public class TestWaterWheel {
    StringReader r = new StringReader("This is a test\r\n");

    @Test
    public void hello() throws IOException {
        Sequence<Character> cat = (match('c').then('a').then('t')).or('d').then('o').then('g');
        cat.test('c').test('a').test('t');
        System.out.println("Cat is a " + cat);
        cat.test('d').test('o').test('g');

    }

    private static class CharMatcher implements Predicate<Character> {
        private final char c;
        CharMatcher(char c) {
            this.c = c;
        }
        @Override
        public boolean test(Character character) {
            return c == character;
        }
    }
}
