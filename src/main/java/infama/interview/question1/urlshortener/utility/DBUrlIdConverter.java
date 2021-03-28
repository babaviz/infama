package infama.interview.question1.urlshortener.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DBUrlIdConverter {

    private static DBUrlIdConverter instance;
    private static HashMap<Character, Integer> charToIndexTable;
    private static List<Character> indexToCharTable;

    private DBUrlIdConverter() {
        initializeCharToIndexTable();
        intCharMapper();
    }

    public static DBUrlIdConverter getInstance(){
        if(instance==null)
            instance=new DBUrlIdConverter();

        return instance;
    }

    private void initializeCharToIndexTable() {
        charToIndexTable = new HashMap<>();
        for (int i = 0; i < 26; ++i) {
            char c = 'a';
            c += i;
            charToIndexTable.put(c, i);
        }
        for (int i = 26; i < 52; ++i) {
            char c = 'A';
            c += (i-26);
            charToIndexTable.put(c, i);
        }
        for (int i = 52; i < 62; ++i) {
            char c = '0';
            c += (i - 52);
            charToIndexTable.put(c, i);
        }
    }

    private void intCharMapper() {
        indexToCharTable = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            char c = 'a';
            c += i;
            indexToCharTable.add(c);
        }
        for (int i = 26; i < 52; ++i) {
            char c = 'A';
            c += (i-26);
            indexToCharTable.add(c);
        }
        for (int i = 52; i < 62; ++i) {
            char c = '0';
            c += (i - 52);
            indexToCharTable.add(c);
        }
    }

    public String createUniqueID(Long id) {
        List<Integer> base62ID = convertBase10ToBase62ID(id);
        return base62ID.stream()
                .mapToInt(digit -> digit)
                .mapToObj(digit -> String.valueOf(indexToCharTable.get(digit)))
                .collect(Collectors.joining());
    }

    private List<Integer> convertBase10ToBase62ID(Long id) {
        LinkedList<Integer> digits = new LinkedList<>();
        while(id > 0) {
            int remainder = (int)(id % 62);
            digits.addFirst(remainder);
            id /= 62;
        }
        return digits;
    }

    public Long getDictionaryKeyFromUniqueID(String uniqueID) {
        List<Character> base62IDs = IntStream.range(0, uniqueID.length())
                .mapToObj(uniqueID::charAt)
                .collect(Collectors.toList());
        return convertBase62ToBase10ID(base62IDs);
    }

    private Long convertBase62ToBase10ID(List<Character> ids) {
        long id = 0L;
        for (int i = 0, exp = ids.size() - 1; i < ids.size(); ++i, --exp) {
            int base10 = charToIndexTable.get(ids.get(i));
            id += (base10 * Math.pow(62.0, exp));
        }
        return id;
    }
}
