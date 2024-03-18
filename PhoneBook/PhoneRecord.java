package PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class PhoneRecord implements Comparable<PhoneRecord> {
    private String name;
    private String surname;
    private String secondname;
    private List<String> phone;
    public PhoneRecord(String phone,String name, String surname, String secondname) {
        this.phone = new ArrayList<String>();
        this.phone.add(phone);
        this.name = name;
        this.surname = surname;
        this.secondname = secondname;
    }
    public PhoneRecord(String name, String surname, String secondname) {
        this.name = name;
        this.surname = surname;
        this.secondname = secondname;
        this.phone = new ArrayList<String>();
    }
    public String getTitle() {
        String secondname = this.secondname == null ? "" : " " + this.secondname;
        return this.surname + " " + this.name + secondname;
    }
    public void addPhone(String phone) {
        this.phone.add(phone);
    }
    public List<String> getPhoneList() {
        return this.phone;
    }
    public void addPhone(List<String> phoneList) {
        if(phoneList != null) {
            this.phone.addAll(phoneList);
        }
    }
    @Override
    public String toString()
    {
        return "{ name " + this.name +
            " surname: " + this.surname +
            " secondname: " + this.secondname +
            " phone: " + this.phone.toString() +
            " }";
    }
    @Override
    public int compareTo(PhoneRecord other) {
        return other.getPhoneList().size() - this.phone.size();
    }
}
