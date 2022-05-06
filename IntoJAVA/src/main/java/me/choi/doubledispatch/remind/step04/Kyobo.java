package me.choi.doubledispatch.remind.step04;

/**
 * Project : IntoJAVA
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:57 오전
 */
public class Kyobo implements BookStore {
    @Override
    public void sales(BookStore bookStore) {
        bookStore.delegationKyobo(this);
    }

    @Override
    public void delegationBandi(Bandi bandi) {
        System.out.println("반디에서 산 책");
    }

    @Override
    public void delegationKyobo(Kyobo kyobo) {
        System.out.println("교보에서 산 책");
    }
}
