import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class RadixSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1000);
        arr.add(4);
        arr.add(25);
        arr.add(319);
        arr.add(88);
        arr.add(51);
        arr.add(3430);
        arr.add(8471);
        arr.add(701);
        arr.add(1);
        arr.add(0);
        arr.add(2989);
        arr.add(657);
        arr.add(713);
        //radixSort(arr);
        descendingRadixSort(arr);
    }

    public static Queue<String> radixSort(ArrayList<Integer> arr) {
        Queue<String> numbersList = new ArrayDeque<>();
        Queue<String> zero = new ArrayDeque<>();
        Queue<String> one = new ArrayDeque<>();
        Queue<String> two = new ArrayDeque<>();
        Queue<String> three = new ArrayDeque<>();
        Queue<String> four = new ArrayDeque<>();
        Queue<String> five = new ArrayDeque<>();
        Queue<String> six = new ArrayDeque<>();
        Queue<String> seven = new ArrayDeque<>();
        Queue<String> eight = new ArrayDeque<>();
        Queue<String> nine = new ArrayDeque<>();

        int maxNumber = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > maxNumber) {
                maxNumber = arr.get(i);
            }
        }

        int digitsOfMaxNr = numberOfDigits(maxNumber);
        for (Integer integer : arr) {
            String sbAddToList = "";
            int digits = numberOfDigits(integer);
            if (digits != digitsOfMaxNr) {
                for (int j = digits; j < digitsOfMaxNr; j++) {
                    sbAddToList += "0";
                }
            }
            sbAddToList += integer;
            numbersList.offer(sbAddToList);
        }

        for (int i = digitsOfMaxNr - 1; i >= 0; i--) {
            while (!numbersList.isEmpty()) {
                String nr = numbersList.poll();
                char c = nr.charAt(i);
                switch (c) {
                    case '0' -> zero.add(nr);
                    case '1' -> one.add(nr);
                    case '2' -> two.add(nr);
                    case '3' -> three.add(nr);
                    case '4' -> four.add(nr);
                    case '5' -> five.add(nr);
                    case '6' -> six.add(nr);
                    case '7' -> seven.add(nr);
                    case '8' -> eight.add(nr);
                    case '9' -> nine.add(nr);
                }
            }
            addToList(zero, numbersList);
            addToList(one, numbersList);
            addToList(two, numbersList);
            addToList(three, numbersList);
            addToList(four, numbersList);
            addToList(five, numbersList);
            addToList(six, numbersList);
            addToList(seven, numbersList);
            addToList(eight, numbersList);
            addToList(nine, numbersList);
        }
        System.out.println(numbersList);
        return numbersList;
    }

    public static int numberOfDigits(int nr) {
        int digits = 0;
        while (nr != 0) {
            digits++;
            nr /= 10;
        }
        return digits;
    }

    public static Queue<String> addToList(Queue<String> toBeAdded, Queue<String> originalList) {
        while (!toBeAdded.isEmpty()) {
            originalList.add(toBeAdded.poll());
        }
        return originalList;
    }

    public static Queue<String> descendingRadixSort(ArrayList<Integer> arr) {
        Queue<String> numbersList = new ArrayDeque<>();
        Queue<String> zero = new ArrayDeque<>();
        Queue<String> one = new ArrayDeque<>();
        Queue<String> two = new ArrayDeque<>();
        Queue<String> three = new ArrayDeque<>();
        Queue<String> four = new ArrayDeque<>();
        Queue<String> five = new ArrayDeque<>();
        Queue<String> six = new ArrayDeque<>();
        Queue<String> seven = new ArrayDeque<>();
        Queue<String> eight = new ArrayDeque<>();
        Queue<String> nine = new ArrayDeque<>();

        int maxNumber = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > maxNumber) {
                maxNumber = arr.get(i);
            }
        }

        int digitsOfMaxNr = numberOfDigits(maxNumber);
        for (Integer integer : arr) {
            String sbAddToList = "";
            int digits = numberOfDigits(integer);
            if (digits != digitsOfMaxNr) {
                for (int j = digits; j < digitsOfMaxNr; j++) {
                    sbAddToList += "0";
                }
            }
            sbAddToList += integer;
            numbersList.offer(sbAddToList);
        }

        for (int i = digitsOfMaxNr-1; i >=0; i--) {
            while (!numbersList.isEmpty()) {
                String nr = numbersList.poll();
                char c = nr.charAt(i);
                switch (c) {
                    case '0' -> zero.add(nr);
                    case '1' -> one.add(nr);
                    case '2' -> two.add(nr);
                    case '3' -> three.add(nr);
                    case '4' -> four.add(nr);
                    case '5' -> five.add(nr);
                    case '6' -> six.add(nr);
                    case '7' -> seven.add(nr);
                    case '8' -> eight.add(nr);
                    case '9' -> nine.add(nr);
                }
            }
            addToList(nine, numbersList);
            addToList(eight, numbersList);
            addToList(seven, numbersList);
            addToList(six, numbersList);
            addToList(five, numbersList);
            addToList(four, numbersList);
            addToList(three, numbersList);
            addToList(two, numbersList);
            addToList(one, numbersList);
            addToList(zero, numbersList);
        }

        System.out.println(numbersList);
        return numbersList;
    }
}
