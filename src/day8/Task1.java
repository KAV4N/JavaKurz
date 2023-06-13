package day8;

import java.util.Arrays;

public class Task1 {
	public static void main(String[] args) {
		int len = 5;
//		String cars[] = new String[len];
		String cars[] = {"Peugeot", "Volvo", "Citroen", "Mazda"};
		for (String car:cars){
			System.out.println(car);
		}
		for (int i = 0; i <cars.length;i++){
			System.out.println(cars[i]);
		}

		Arrays.stream(cars).forEach(System.out::println);
	}



}
