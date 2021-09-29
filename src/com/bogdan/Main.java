package com.bogdan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Car audiB = new Car("1", "audi", "black");
        Car audiW = new Car("2", "audi", "white");
        Car audiR = new Car("3", "audi", "red");
        Car fordB = new Car("4", "ford", "black");
        Car fordW = new Car("5", "ford", "white");
        Car fordR= new Car("6", "ford", "red");
        Car bmwB = new Car("7", "bmw", "black");
        Car bmwW = new Car("8", "bmw", "white");

        List<Car> cars = new ArrayList<>();
        cars.add(audiB);
        cars.add(audiW);
        cars.add(audiR);
        cars.add(fordB);
        cars.add(fordW);
        cars.add(fordR);
        cars.add(bmwB);
        cars.add(bmwW);

        //pastreaza doar obiectele Car care au color 'red'
        List<Car> secondCarList = cars.stream()
                .filter(car -> car.getColor().equals("black"))
                .collect(Collectors.toList());

        for(Car c : secondCarList) {
            System.out.println(c);
        }

        System.out.println("-----------------");

        //gaseste primul obiect Car din lista care are color "red"
        Car car = cars.stream()
                .filter(c -> c.getColor().equals("red"))
                .findFirst()
                .get();

        System.out.println(car);

        System.out.println("-----------------");

        //true daca sunt culori "red" , altfel false
        boolean anyRedCar = cars.stream()
                .anyMatch(c -> c.getColor().equals("red"));

        System.out.println(anyRedCar);

        System.out.println("----------------");

        //returneaza culorile Car intr-o alta lista
        List<String> carColors = cars.stream()
                .map(Car::getColor)
                .collect(Collectors.toList());

        for(String c : carColors) {
            System.out.println(c);
        }

        System.out.println("----------------");
        //Intr-un Map, aduna toate obiectele Car, cheia fiind id-ul fiecareia (key=id, value=Car)
        Map<String, String> map = cars
                .stream()
                .collect(
                        Collectors
                        .toMap(Car::getId,
                                Car::getBrand,
                                (x,y) -> x + ", " + y)
                );

        map.forEach(
                (x, y) -> System.out.println(x + ": " + y)
        );
        System.out.println("----------------");

        // Intr-un Map, aduna cate obiecte Car exista pentru fiecare culoare (key=color, value=count by color)
        Map<String, Long> countByColor = cars
                .stream()
                .collect(
                        Collectors
                        .groupingBy(Car::getColor,
                                Collectors.counting())
                );

        countByColor.forEach(
                (x, y) -> System.out.println(x + ": " + y)
        );

        //Intr-o alta lista, returneaza fix aceleasi obiecte Car, dar sortate dupa color
        System.out.println("----------------");

        List<Car> sortedCars = cars
                .stream()
                .sorted(Comparator.comparing(Car::getColor))
                .collect(Collectors.toList());

        sortedCars.forEach(System.out::println);

        //Acelasi exercitiu ca mai sus, dar sortate in sens invers
        System.out.println("-----------------");

        List<Car> reverseSortedCars = cars
                .stream()
                .sorted(Comparator.comparing(Car::getColor)
                .reversed())
                .collect(Collectors.toList());

        reverseSortedCars.forEach(System.out::println);
    }



}
