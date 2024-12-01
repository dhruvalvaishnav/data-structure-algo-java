package com.demo.arrays;

import java.util.*;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 * <p>
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= val <= 231 - 1
 * At most 2 * 105 calls will be made to insert, remove, and getRandom.
 * There will be at least one element in the data structure when getRandom is called.
 */
// https://leetcode.com/problems/insert-delete-getrandom-o1/
public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        obj.insert(1);
        obj.remove(2);
        obj.insert(1);
        obj.getRandom();
        obj.remove(1);
        obj.insert(2);
        obj.getRandom();
        System.out.println(obj);
        // ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
    }
}

class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;  // Value already exists
        }
        map.put(val, list.size());  // Add value and store its index in the map
        list.add(val);  // Add value to the list
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;  // Value does not exist
        }

        // Get the index of the element to remove
        int index = map.get(val);
        int lastValue = list.get(list.size() - 1);  // Last value in the list

        // Swap the last value with the one to be removed
        list.set(index, lastValue);
        map.put(lastValue, index);  // Update the map with the new index of the last value

        // Remove the last element from the list
        list.remove(list.size() - 1);
        map.remove(val);  // Remove the value from the map
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));  // Get a random index
    }

    @Override
    public String toString() {
        return "RandomizedSet{" +
                "map=" + map +
                ", list=" + list +
                ", rand=" + rand +
                '}';
    }
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */