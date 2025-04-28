package com.mywork.boot.hello;

import lombok.*;

//@AllArgsConstructor => final 없어도 됌 setter 기능 수행 가능
@RequiredArgsConstructor
@Getter
@Setter
public class HelloLombok {
    private final String Hello;
    private final int lombok;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("hello", 5);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
