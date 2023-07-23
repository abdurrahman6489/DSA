import java.util.*;

class overlap {
    static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int i, first = 0, last = 0;
        int prevKey = 0;
        TreeMap<Integer, Integer> checkIntervalMap = new TreeMap<>();
        TreeMap<Integer, Integer> addIntervalMap = new TreeMap<>();
        for (i = 0; i < n; i++) {
            first = intervals[i][0];
            last = intervals[i][1];
            checkIntervalMap.put(first, Math.max(last, checkIntervalMap.getOrDefault(first, -1)));
        }

        for (Map.Entry<Integer, Integer> entry : checkIntervalMap.entrySet()) {
            first = entry.getKey();
            last = entry.getValue();
            System.out.println("line no 15 " + first + " " + last);
            if (addIntervalMap.containsKey(first)) {
                addIntervalMap.put(first, Math.max(last, addIntervalMap.get(first)));
                System.out.println("line no 18 " + first + " " + addIntervalMap.get(first));
            } else if (addIntervalMap.floorKey(first - 1) != null) {
                prevKey = addIntervalMap.floorKey(first - 1);
                System.out.println("line 21 " + prevKey);
                if (addIntervalMap.get(prevKey) >= first) {
                    addIntervalMap.put(prevKey, Math.max(last, addIntervalMap.get(prevKey)));
                    System.out.println("line 24 " + prevKey + " " + addIntervalMap.get(prevKey));
                } else {
                    addIntervalMap.put(first, last);
                    System.out.println("line 27 " + first + " " + addIntervalMap.get(first));
                }
            } else {
                addIntervalMap.put(first, last);
                System.out.println("line 31 " + first + " " + addIntervalMap.get(first));
            }
        }
        int result[][] = new int[addIntervalMap.size()][2];
        i = 0;
        for (Map.Entry<Integer, Integer> entry : addIntervalMap.entrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                { 2, 3 }, { 5, 5 }, { 2, 2 }, { 3, 4 }, { 3, 4 }
        };
        // int[][] intervals = {
        // { 1, 4 }, { 4, 5 }
        // };
        int[][] resultIntervals = merge(intervals);
        for (int k = 0; k < resultIntervals.length; k++) {
            System.out.println(resultIntervals[k][0] + " " + resultIntervals[k][1]);
        }

    }
}