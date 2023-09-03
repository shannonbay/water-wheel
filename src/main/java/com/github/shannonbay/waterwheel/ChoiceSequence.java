package com.github.shannonbay.waterwheel;

public class ChoiceSequence<T> extends Sequence<T> {
    Sequence choice1, choice2;

    public ChoiceSequence(Sequence choice1, Sequence choice2, Sequence next) {
        super(choice1.predicate.or(choice2.predicate), next);
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public Sequence then(Sequence newNext){
        System.out.println("Choice Appending " + newNext);
        return new ChoiceSequence(choice1, choice2.then(newNext), null);
    }

    public Sequence test(T c){
        Sequence c1 = choice1.test(c);
        Sequence c2 = choice2.test(c);
        if(c1 == null) {
            return c2;
        } else if(c2 == null) {
            return c1;
        }
        return new ChoiceSequence(c1, c2, next);
    }

    @Override
    public String toString() {
        return "Choice(" + choice1.toString() + "|" + choice2.toString() + ")";
    }
}
