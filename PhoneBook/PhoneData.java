package PhoneBook;

public class PhoneData {
    String[] recordList = {
        "223322;Иван;Иванов;Иванович",
        "333444;Владимир;Иванов;Иванович",
        "112345;Петр;Иванов;Иванович",
        "55443322;Сергей;Иванов;Иванович",
        "117745;Петр;Иванов;Иванович",
        "99887766;Иван;Иванов;Иванович",
        "44556677;Сергей;Иванов",
    };
    public PhoneRecord[] getData() {
        PhoneRecord[] list = new PhoneRecord[recordList.length];
        for(int i=0; i < recordList.length; i++) {
            String[] s = recordList[i].split(";");
            String phone = s.length > 0 ? s[0] : null;
            String name = s.length > 1 ? s[1] : null;
            String surname = s.length > 2 ? s[2] : null;
            String secondname = s.length > 3 ? s[3] : null;
            list[i] = new PhoneRecord(phone, name, surname, secondname);
        }
        return list;
    }
}
