import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MyParser {

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public List<Organization> parse (List<String> orgJson){ // метод прохидится по всем огранизациям в листе и расставляет данные
        List<Organization> organizations = new ArrayList<>();

        for (int i = 0; i < orgJson.size(); i++){
            organizations.add(new Organization());

            Optional<String> optional;

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"id\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setId(parsInt(optional.get())); //установка id организации

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"code\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setCode(parsString(optional.get())); //установка code организации


            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"name_full\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setNameFull(parsString(optional.get())); //установка name_full организации

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"name_short\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setNameShort(parsString(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"inn\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setInn(parsString(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"id\""))
                    .skip(1)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setCompanyType(new CompanyType());
            organizations.get(i).getCompanyType().setId(parsInt(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"name_short\""))
                    .skip(1)
                    .limit(1)
                    .findFirst();

            organizations.get(i).getCompanyType().setNameShort(parsString(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"name_full\""))
                    .skip(1)
                    .limit(1)
                    .findFirst();

            organizations.get(i).getCompanyType().setNameFull(parsString(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"ogrn\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setOgrn(parsString(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"egrul_date\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setEgrulDate(parsString(optional.get()));
            organizations.get(i).setEgrulDate(parsString(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"id\""))
                    .skip(2)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setCountry(new Country());
            organizations.get(i).getCountry().setId(parsInt(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"code\""))
                    .skip(1)
                    .limit(1)
                    .findFirst();

            organizations.get(i).getCountry().setCode(parsString(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"name\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).getCountry().setName(parsString(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"fio_head\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setFioHead(parsString(optional.get()));


            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"address\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setAddress(parsString(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"phone\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setPhone(parsString(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"e_mail\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).seteMail(parsString(optional.get()));

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"www\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setWww(parsString(optional.get()));

            //"is_resident"  orgJson

            optional = Arrays.asList(orgJson.get(i).split("\\n"))
                    .stream()
                    .filter(s -> s.contains("\"is_resident\""))
                    .skip(0)
                    .limit(1)
                    .findFirst();

            organizations.get(i).setResident(parsBoolean(optional.get()));

            List<String> listSecur = splitOrg(splitSecuriti(orgJson.get(i)));
            for(int j = 0; j < listSecur.size(); j++){

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"id\""))
                        .skip(0)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().add(new SecuritiDoc());
                organizations.get(i).getSecurities().get(j).setId(parsInt(optional.get()));

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"code\""))
                        .skip(0)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().get(j).setCode(parsString(optional.get()));

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"name_full\""))
                        .skip(0)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().get(j).setNameFull(parsString(optional.get()));

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"cfi\""))
                        .skip(0)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().get(j).setCfi(parsString(optional.get()));

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"date_to\""))
                        .skip(0)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().get(j).setDateTo(parsString(optional.get()));

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"state_reg_date\""))
                        .skip(0)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().get(j).setStateRegDate(parsString(optional.get()));

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"id\""))
                        .skip(1)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().get(j).setState(new State());
                organizations.get(i).getSecurities().get(j).getState().setId(parsInt(optional.get()));

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"name\""))
                        .skip(0)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().get(j).getState().setName(parsString(optional.get()));

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"id\""))
                        .skip(2)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().get(j).setCurrency(new Currency());
                organizations.get(i).getSecurities().get(j).getCurrency().setId(parsInt(optional.get()));

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"code\""))
                        .skip(1)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().get(j).getCurrency().setCode(parsString(optional.get()));

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"name_short\""))
                        .skip(0)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().get(j).getCurrency().setNameShort(parsString(optional.get()));

                optional = Arrays.asList(listSecur.get(j).split("\\n"))
                        .stream()
                        .filter(s -> s.contains("\"name_full\""))
                        .skip(0)
                        .limit(1)
                        .findFirst();

                organizations.get(i).getSecurities().get(j).getCurrency().setNameFull(parsString(optional.get()));

            }
        }



        return organizations;
    }

    private static String splitSecuriti(String str){ //метод разделяет json на части по документам
        List<String> list = Arrays.asList(str.split("\n"));


        boolean flag = false;
        StringBuilder securities = new StringBuilder();

        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).contains("\"securities\"")){
                flag = true;
            }
            if (flag){
                securities.append(list.get(i) + "\n");
            }
        }
        return securities.toString();
    }

    public List<String> splitOrg(String json){ //метод разделяет json на части по организациям
        List<String> list = new ArrayList<>();
        int count = 0;
        StringBuilder org = new StringBuilder("");
        for (char a: json.toCharArray()) {
            if (a == '{') count++;
            if (a == '}') {
                count--;
                if (count == 0) {
                    org.append(a);
                    list.add(org.toString());
                    org.delete(0,org.length());
                }
            }
            if (count != 0){
                org.append(a);
            }
        }
        return list;
    }


    private static boolean parsBoolean(String str){
        if (str.contains("true")) return true;
        else return false;
    }

    private static int parsInt(String str){ //метод выделяет int здачение параметра в строке

        StringBuilder newStr = new StringBuilder();

        for (char a:str.toCharArray()) {
            if (a == '0' || a == '1' ||
                    a == '2' || a == '3' ||
                    a == '4' || a == '5' ||
                    a == '6' || a == '7' ||
                    a == '8' || a == '9'){
                newStr.append(a);
            }
        }
        return  Integer.parseInt(newStr.toString());
    }

    private static String parsString(String str){ //метод выделяет String здачение параметра в json-строке

        StringBuilder newStr = new StringBuilder();
        char[] strf = str.toCharArray();
        boolean flag = false;
        int t=2;
        if (strf[strf.length-2] == ',') t = 3;
        for (int i = 0; i < strf.length-t; i++) {
            if(strf[i] == ':'){
                flag = true;
                i = i + 3;
            }
            if(flag){

                newStr.append(strf[i]);
            }
        }
        return newStr.toString();
    }


}
