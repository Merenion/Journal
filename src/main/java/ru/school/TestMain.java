package ru.school;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(get0().isPresent());
    }

    static Optional<String> get0() {
        Map<Integer,List<Integer>> map = Stream.of(1,3,5,2,1,3,-3).collect(groupingBy(x -> x));
    }
}

class Peerson {
    String name;

    public Peerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}