public class MyData {
    private String lastName;
    private String name;
    private String patronymic;
    private String birthDate;
    private long phone;
    private char sex;

    @Override
    public String toString() {
        return
                "Фамилия='" + lastName + '\'' +
                ", Имя='" + name + '\'' +
                ", Отчество='" + patronymic + '\'' +
                ", Дата рождения='" + birthDate + '\'' +
                ", Номер телефона=" + phone +
                ", Пол=" + sex
               ;
    }
    public String stringForFile() {
        return
                "<" + lastName + '>' +
                        "<" + name + '>' +
                        "<" + patronymic + '>' +
                        "<" + birthDate + '>' +
                        "<" + phone +'>'+
                        "<" + sex +'>'
                ;
    }
    public MyData(String lastName, String name, String patronymic, String birthDate, long phone, char sex) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phone = phone;
        this.sex = sex;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
