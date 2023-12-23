import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParsingData extends Throwable {
    public static MyData stringParser(String stringToParsing) throws IllegalArgumentException {
        DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String[] parts = stringToParsing.split(" ");
        //System.out.println(partPart.length);
        int countParts = parts.length;
        if (countParts < 6) {
            throw new IllegalArgumentException("Недостаточно данных");
        } else if (countParts > 6)
        {
            throw new IllegalArgumentException("\"Лишние\" данные или разделители в строке");
        }

        boolean[] isValidData = {false, false, false, false, false, false} ;

        String lastName = "", name = "", patronymic = "", birthDate = "";
        long phone = 0;
        char sex =' ';
        int dataFillingCounter = 0;

        for(String part : parts) {
            String stringFIO = part.toUpperCase();
            if (stringFIO.matches("[А-ЯЁ]+")){
                if (lastName.isEmpty()){
                    lastName = part;
                    isValidData[0] = true;
                    dataFillingCounter++;
                    continue;
                }
                else if (name.isEmpty()) {
                    name = part;
                    isValidData[1] = true;
                    dataFillingCounter++;
                    continue;
                } else if (patronymic.isEmpty()) {
                    patronymic = part;
                    isValidData[2] = true;
                    dataFillingCounter++;
                    continue;
                }
            }
            if (part.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                birthDate = part;
                isValidData[3] = true;
                dataFillingCounter++;
                continue;
            }
            if (part.matches("\\d{10}")) {
                phone = Long.parseLong(part);
                isValidData[4] = true;
                dataFillingCounter++;
                continue;

            }
            if ((part.length()==1) && (part.matches("[mf]"))) {
                sex = part.charAt(0);
                isValidData[5] = true;
                dataFillingCounter++;
            }
        }
        System.out.println(dataFillingCounter);

        if (dataFillingCounter < 6) {
            throw new IllegalArgumentException(erorDataString(isValidData));
        }

        try {

            Date date = sdf.parse(birthDate);
            String formattedDate = sdf.format(date);


            if (!isValidDate(date)) {
                throw new IllegalArgumentException("Неверная дата");
            }
//
//
        } catch (ParseException e) {

            throw new IllegalArgumentException("Неверный формат даты");

        } catch (Exception e) {

            throw new IllegalArgumentException("Неверный формат данных");
        }
        return new MyData(lastName, name, patronymic,birthDate,phone, sex);
    }
    public static String erorDataString(boolean[] arrayValidData){
        String erorMessage = "";
        String[] myErorMessages = {
                "Не корректно введена фамилия",
                "Не корректно введено имя",
                "Не корректно введено отчество",
                "Не корректно введена дата рождения",
                "Не корректно введен номер телефона",
                "Не корректно введен пол должен быть символ f - женский или m - мужской",
        };

        for (int i = 0; i < 6; i++) {
            if (!arrayValidData[i]) {
                erorMessage = erorMessage + myErorMessages[i] +"; ";
            }
        }
        return erorMessage;
    }

    private static boolean isValidDate(Date date) {
        Date current = new Date();
        return (date.before(current));
    }
}
