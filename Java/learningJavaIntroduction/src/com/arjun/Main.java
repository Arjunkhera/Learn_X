package com.arjun;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

    }

    public static void testing()  {
        String abc = "abc";

    }

    Set<String> result = new HashSet<>();
    Character middle = null;

    public List<String> generatePalindromes(String s) {

        Map<Character, Integer> store = new HashMap<>();
        for(Character ch : s.toCharArray()) {
            store.put(ch, store.getOrDefault(ch, 0) + 1);
        }

        boolean isOdd = s.length() % 2 != 0;
        List<Character> characters = new ArrayList<>();

        for(Map.Entry<Character, Integer> entry : store.entrySet()) {
            if(entry.getValue() % 2 == 1) {
                if(!isOdd) {
                    return new ArrayList<>();
                } else {
                    isOdd = false;
                    middle = entry.getKey();
                }
            }

            for(int i = 0; i < entry.getValue()/2; i++) {
                characters.add(entry.getKey());
            }
        }

        solve(characters, 0);
        return new ArrayList<>(result);
    }

    public void solve(List<Character> str, int index) {
        if(index == str.size()) {
            String left = str.toString();
            if(middle != null) left += middle;
            left += new StringBuilder(left).reverse().toString();
            result.add(left);
        }

        for(int i = index; i < str.size(); i++) {
            Collections.swap(str, index, i);
            solve(str, index + 1);
            Collections.swap(str, index, i);
        }
    }


    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        // TODO: Write your code here
        if(str.isEmpty() || pattern.isEmpty() || pattern.length() > str.length()) return resultIndices;

        Map<Character, Integer> store = new HashMap<>();
        for(char ch : pattern.toCharArray()) {
            store.put(ch, store.getOrDefault(ch, 0) + 1);
        }

        int startIndex = 0;
        int matched = 0;
        for(int i = 0; i < str.length(); i++) {
            char rightChar = str.charAt(i);

            if(store.containsKey(rightChar)) {
                store.put(rightChar, store.get(rightChar) - 1);
                if(store.get(rightChar).equals(0)) matched += 1;
            }

            if(matched == store.size()) {
                resultIndices.add(startIndex);
            }

            if(i >= pattern.length() - 1) {
                char leftChar = str.charAt(startIndex++);
                if(store.containsKey(leftChar)) {
                    if(store.get(leftChar).equals(0)) matched -= 1;
                    store.put(leftChar, store.get(leftChar) + 1);
                }
            }
        }

        return resultIndices;
    }

    public static void getProductNames() {
        File file = new File("C:\\Users\\arkhera\\Desktop\\stageProductPaths.txt");
        File writeFile = new File("productNames.txt");

        try(Scanner scanner = new Scanner(file)){
            PrintWriter printWriter = new PrintWriter(writeFile);

            while(scanner.hasNextLine()) {
                String productName = "";
                String line = scanner.nextLine();
                int matchIndex = line.lastIndexOf("/en/") + "/en/".length();
                int secondMatch = line.indexOf(",", matchIndex);
                System.out.println(line.substring(matchIndex,secondMatch));
                printWriter.println(line.substring(matchIndex,secondMatch));
            }

            printWriter.close();
        } catch (Exception exception) {
                System.out.println("Error reading the file");
        }
    }

    public static int[] sort(int[] inputArray) {
        int i = 1;
        while(i < inputArray.length) {
            int j = i;
            while(j > 0) {
                if(inputArray[j] < inputArray[j-1]) {
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j-1];
                    inputArray[j-1] = temp;
                }

                j--;
            }

            i++;
        }

        return inputArray;


    }

    public static int search(int[] inputArray, int element) {
        int start = 0;
        int end = inputArray.length;
        // to prevent overflow in case of very large values
        int mid = start + (end - start)/2;
        boolean found = false;

        while(start <= end) {
            // The element has been found
            if(inputArray[mid] == element) {
                found = true;
                break;
            }

            // Reset the variables
            if(inputArray[mid] >= element) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end-start)/2;
        }

        // element not found in the array
        if(!found) {
            mid = -1;
        }

        // return the index
        return mid;
    }

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder sb = new StringBuilder("");
        Arrays.stream(strings).
                forEach(s -> {
                    s.chars().forEach(c -> {
                        if (c > '9' || c < '0') {
                            sb.append((char) c);
                        }
                    });
                });

        return sb.toString();
    }
}
