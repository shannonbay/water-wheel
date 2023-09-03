package com.github.shannonbay.waterwheel;

import java.util.function.Predicate;

public class SequenceDSL {

    public static <T> Sequence<T> match(Object c){
        return new Sequence<T>(new Predicate<T>() {
            @Override
            public boolean test(T character) {
                return c == character;
            }

            @Override
            public String toString(){
                return "" + c;
            }
        });
    }

}
