package me.oop.book.chapter02.src.main.java.org.eternity.movie.step01;


import me.oop.book.chapter02.src.main.java.org.eternity.money.Money;

public class Reservation {
    private Customer customer;
    private Screening Screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening Screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.Screening = Screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
