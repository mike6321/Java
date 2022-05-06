package me.choi.doubledispatch.remind.step04;

import java.util.Arrays;
import java.util.List;

/**
 * Project : IntoJAVA
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:56 오전
 */
public class App {
    public static void main(String[] args) {
        List<BookStore> bookStores = Arrays.asList(new Bandi(), new Kyobo());

        bookStores.forEach(bs -> {
            bs.sales(bs);
        });
    }
}
