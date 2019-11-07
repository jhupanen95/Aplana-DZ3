import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        MyParser parser = new MyParser();


        String json = readUsingFiles("C:\\Users\\jhupanen\\IdeaProjects\\Aplana\\Aplana-DZ3\\test.json");
        List<String> orgJson = parser.splitOrg(json); //Список json-ов (разделены по организациям)
        List<Organization> organizations = parser.parse(orgJson); //парсинг разделенных огранизаций

        System.out.println("Организации: ");
        for (Organization o:organizations) {
            System.out.println(o.info());
        }

        System.out.println("Просроченные документы: ");
        int num = 0;
        for (Organization o:organizations) {
            for (SecuritiDoc sd: o.getSecurities()){
                String info = sd.info();
                if (info != null) {
                    System.out.println(info);
                    num++;
                }
            }
        }
        System.out.println("Всего: " + num);


        System.out.print("Введите запрос: ");
        Scanner in = new Scanner(System.in);
        String req = in.nextLine();


        if (req.length() > 4) {
            LocalDate date = reDate(req);
            for (Organization o : organizations) {
                if (o.getEgrulDate().isAfter(date)) {
                    System.out.println(o.getNameFull() + " " + o.getEgrulDate());
                }
            }
        }
        else {
            for (Organization o : organizations) {
                for (SecuritiDoc sd: o.getSecurities()){
                    if (sd.getCurrency().getCode().equals(req)){
                        System.out.println(sd.getId() + " " + sd.getCode());
                    }
                }
            }
        }


    }

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static LocalDate reDate (String vvod){

        String[] dt = Arrays.asList(vvod.split("[./]"))
                .stream()
                .toArray(String[]::new);

        String strDate = "";
        if (dt[2].length() == 2) dt[2] = "19" + dt[2];
        strDate += dt[2] + "-" + dt[1] + "-" + dt[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        return LocalDate.parse(strDate, formatter);

    }


}
