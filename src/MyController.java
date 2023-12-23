import java.io.IOException;
import java.util.Scanner;

public class MyController {
    public static void StringProcessing(){

        boolean inputTerminate = false;

        String StrToProc = "";


        View.ShowStartMessage();

        while (!inputTerminate){
            StrToProc = StringRead();
            if (StrToProc.length() == 0) {
                inputTerminate = true;   ;
            } else {
                StrToProc = StrToProc.replaceAll("[,;]"," ");
                StrToProc = StrToProc.replaceAll("\\s+", " ");
                StrToProc = StrToProc.trim();

                MyData myData = ParsingData.stringParser(StrToProc);

                View.ShowString(myData.toString());
                try {
                    TxtFileWriter.writeToCsvFile(myData.getLastName(), myData.stringForFile());
                } catch (IOException e){
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }




        }
    }


    private static String StringRead(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
