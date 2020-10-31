import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {


    public static void main(String[] args) throws Exception {

        Cities.createSetOfCities();
        System.out.println("Напишите название города ");
        Scanner scanner = new Scanner(System.in);
       String city0 = scanner.nextLine();
       try {
           if (!Cities.cities.contains(city0))
               throw new Exception("Нет такого города");
       }
       catch (Exception e){
           e.printStackTrace();
       }
      String city2 = Cities.getCityByLastLetterOfCity(city0);
        System.out.println(city2);

         char lastLetter=city2.charAt(city2.length()-1);

        for (int i = 0; i < 5; i++) {
            System.out.println("Ваша очередь написать название города");
            Scanner in = new Scanner(System.in);
            String city1 = in.nextLine();
            try {
                if (city1.charAt(0) != Character.toUpperCase(lastLetter))
                    throw new Exception("Название города должно начинаться с '" + Character.toUpperCase(lastLetter) + "'");
            } catch (Exception e) {
                e.printStackTrace();

                String city = Cities.getCityByLastLetterOfCity(city1);
                System.out.println(city);
                lastLetter = city.charAt(city.length() -1);
            }
        }

    }

    }






