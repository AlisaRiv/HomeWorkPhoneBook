package PhoneBook;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {
    HashMap<String, PhoneRecord> recordList;
    public static void main(String[] args) {
        PhoneBook phoneBook1 = new PhoneBook();
        phoneBook1.initBook();
    }
    public void initBook() {
        this.recordList = new HashMap<>();
        PhoneData data = new PhoneData();
        PhoneRecord[] dataList = data.getData();
        for(int i=0;i<dataList.length; i++) {
            PhoneRecord item = dataList[i];
            if(recordList.containsKey(item.getTitle())) {
                recordList.get(item.getTitle()).addPhone(item.getPhoneList());
            } else {
                recordList.put(item.getTitle(), item);
            }
        }
        // System.out.println(this.recordList);
        TreeMap<String, PhoneRecord> sorted = new TreeMap<>();
        sorted.putAll(this.recordList);
        for(Map.Entry<String,PhoneRecord> item: entriesSortedByValues(sorted)) {
            PhoneRecord w = item.getValue();
            System.out.println(w.getTitle()+ ": "+ w.getPhoneList());
        }
    }
    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
            new Comparator<Map.Entry<K,V>>() {
                @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1;
                }
            }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
