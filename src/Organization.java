

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Organization {

    private int id;
    private String code;
    private String nameFull;
    private String nameShort;
    private String inn;
    private CompanyType companyType;
    private String ogrn;
    private LocalDate egrulDate;
    private Country country;
    private String fioHead;
    private String address;
    private String phone;
    private String eMail;
    private String www;
    private boolean isResident;
    private ArrayList<SecuritiDoc> securities = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public LocalDate getEgrulDate() {
        return egrulDate;
    }

    public void setEgrulDate(String egrulDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        this.egrulDate = LocalDate.parse(egrulDate, formatter);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getFioHead() {
        return fioHead;
    }

    public void setFioHead(String fioHead) {
        this.fioHead = fioHead;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public boolean isResident() {
        return isResident;
    }

    public void setResident(boolean resident) {
        isResident = resident;
    }

    public ArrayList<SecuritiDoc> getSecurities() {
        return securities;
    }

    public void setSecurities(ArrayList<SecuritiDoc> securities) {
        this.securities = securities;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nameFull='" + nameFull + '\'' +
                ", nameShort='" + nameShort + '\'' +
                ", inn='" + inn + '\'' +
                ", companyType=" + companyType +
                ", ogrn='" + ogrn + '\'' +
                ", egrulDate='" + egrulDate + '\'' +
                ", country=" + country +
                ", fioHead='" + fioHead + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", eMail='" + eMail + '\'' +
                ", www='" + www + '\'' +
                ", isResident=" + isResident +
                ", securities=" + securities +
                '}';
    }

    public String info(){
        return "\"" + getNameShort() + "\" - " + getEgrulDate();
    }
}
