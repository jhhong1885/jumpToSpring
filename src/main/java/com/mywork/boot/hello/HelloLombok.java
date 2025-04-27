package com.mywork.boot.hello;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class HelloLombok {
    private String Hello;
    private int lombok;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("hello", 5);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
