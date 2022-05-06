package me.choi.doubledispatch.remind.step04;

/**
 * Project : IntoJAVA
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:56 오전
 */
public interface BookStore {
    void sales(BookStore bookStore);
    void delegationBandi(Bandi bandi);
    void delegationKyobo(Kyobo kyobo);
}
