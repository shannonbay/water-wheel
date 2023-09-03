package com.github.shannonbay.waterwheel;

import java.util.function.Predicate;

public class Sequence<T> {

    final Predicate<T> predicate;
    protected final Sequence<T> next;

    public Sequence(Predicate<T> predicate) {
        this.predicate = predicate;
        this.next = null;
    }

    public Sequence(Predicate<T> predicate, Sequence next) {
        this.predicate = predicate;
        this.next = next;
    }

    public Sequence test(T c){
        if(predicate.test(c))
            return next;
        return null;
    }

    public Sequence then(Sequence newNext){
        System.out.println("Seq " + this + " Appending " + newNext);
        if(next == null)
            return new Sequence(predicate, newNext);
        return new Sequence(predicate, next.then(newNext));
    }

    public Sequence then(T next){
        return then(SequenceDSL.match(next));
    }

    public Sequence or(Sequence that){
        return new ChoiceSequence(this, that, null);
    }

    public Sequence or(T alternative){
        Sequence alt = SequenceDSL.match(alternative);
        return new ChoiceSequence(this, alt, null);
    }

    @Override
    public String toString() {
        return "(" + this.predicate.toString() + (next != null? "," + next.toString(): "") + ")";
    }
}
