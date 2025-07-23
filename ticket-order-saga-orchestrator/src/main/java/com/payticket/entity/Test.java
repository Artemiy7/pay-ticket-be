package com.payticket.entity;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



class StringConsumer implements Consumer<String> {
    public void accept(String s) {
        System.out.println(s);
    }
}

public class Test {
    public static void main(String[] args) {
        StringConsumer consumer = s -> System.out.println(s);

        List<String> list = Arrays.asList("Dr", "Mr", "Miss", "Mrs");
        list.forEach(consumer);
    }
}
