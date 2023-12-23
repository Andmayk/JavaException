public class View {
    public static void ShowStartMessage(){
        System.out.println("Введите данные \n" +
                "фамилия, имя, отчество, дата рождения, номер телефона, пол - символ латиницей f или m. \n"+
                "Пример \n"+
                "Иванов Иван Иванович 09.08.1967 9012345678 m                   Для выхода просто Enter  (пустая строка)");
    }

    public static void ShowString(String stringToShow){
        System.out.println(stringToShow);
    }

}
