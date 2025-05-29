package com.itakademija.paint.xml.dom.helper;

public interface DocumentProcessor<T, R> {

    R process(T input);

    default <V> DocumentProcessor<T, V> afterThat(DocumentProcessor<? super R, ? extends V> after) {
        return (T t) -> {
            R result = this.process(t);
            return after.process(result);
        };
    }
}
