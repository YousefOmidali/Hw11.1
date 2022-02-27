import java.security.KeyStore;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<String> words = new ArrayList();
        words.add("Amir");
        words.add("Hatef");
        words.add("Mehran");
        words.add("Mojtaba");
        words.add("Mohammad");
        words.add("Davood");
        words.add("Reza");
        words.add("Mohsen");
        words.add("Yousef");
        //-----------------------------------------------------------------------------------
        //a
        Map<Integer, List<String>> wordLength =
                words.stream()
                        .collect(Collectors.groupingBy(String::length));
        System.out.println(wordLength);
        //------------------------------------------------------------------------------------
        //b
        for (Map.Entry<Integer, List<String>> a : wordLength.entrySet()) {
            System.out.print(a + " " + a.getValue().stream().count()+" , ");
        }


//        Map<Integer, List<String>> charFrequency1 =
//                words.stream()
//                        .collect(Collectors.groupingBy(String::length)).entrySet()
//                        .stream().collect(Collectors.toMap(Map.Entry::getKey, e : Collectors.toMap(e.getValue().size(), e.getValue())));
//        System.out.println(charFrequency1);
        //------------------------------------------------------------------------------------
        //Additional
        Map<Character, Long> charFrequency2 = words.stream()
                .flatMapToInt(String::chars) //IntStream
                .mapToObj(c -> (char) c)     //Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charFrequency2);
        ;//-----------------------------------------------------------------------------------
        //For Tests
//        Map<Integer, Map<Integer, List<String>>> result = words.stream()
//                .collect(Collectors.groupingBy(String::length))
//                .entrySet().stream()
//                .collect(Collectors.toMap(Map.Entry::getKey,e -> Collectors.toMap(e.getValue().size(),e.getValue())));
//        System.out.println(result);

//
//        System.out.println(words.stream()
//                .collect(
//                        Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

}

//.collect(Collectors.toMap(Map.Entry::getKey, e -> Map.of(e.getValue().size(), e.getValue())));