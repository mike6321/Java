package me.choi.doubledispatch.remind.step04;

/**
 * Project : IntoJAVA
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:57 오전
 */
public class Bandi implements BookStore {
    @Override
    public void sales(BookStore bookStore) {
        bookStore.delegationBandi(this);
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
