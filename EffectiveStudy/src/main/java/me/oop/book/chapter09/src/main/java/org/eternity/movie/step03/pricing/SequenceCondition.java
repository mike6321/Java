package me.oop.book.chapter09.src.main.java.org.eternity.movie.step03.pricing;

import org.eternity.movie.step03.DiscountCondition;
import org.eternity.movie.step03.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
