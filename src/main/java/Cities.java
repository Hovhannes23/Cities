import java.io.*;
import java.util.*;

public class Cities {

    static Set <String> cities = new TreeSet<>();

   public static Set<String> createSetOfCities() throws IOException {
       File file = new File("src\\main\\resources\\Cities");
      FileReader reader = new FileReader(file);
       Scanner scanner = new Scanner(reader);
      while(scanner.hasNext())
         cities.add(scanner.nextLine());
        return cities;
    }


    public static String getCityByLastLetterOfCity(String city) throws Exception {
      try {
          if(!cities.contains(city))
              throw new Exception("Такого города нет, или он уже был использован");
      }
      catch (Exception e){
          e.printStackTrace();
      }
       cities.remove(city); // удаляем введенный клиентом город из списка городов, чтобы его не использовать повторно
        char lastChar;
     String city1=city.toUpperCase();
     char i;
        final String s = String.valueOf(city1.charAt(city1.length() - 1));
        if(s.equals("Ы") || s.equals("Ь"))
         i = city1.charAt(city1.length()-2);
     else
        i = city1.charAt(city1.length()-1);

        List<String> citiesOnI = new ArrayList<>();

        for(String c:cities){
            if (i==c.charAt(0))
                citiesOnI.add(c);
        }
        String city2 = citiesOnI.get((int)(Math.random()*citiesOnI.size()));
        cities.remove(city2);
        lastChar = city2.charAt(city2.length()-1);
        return city2;

    }



}
