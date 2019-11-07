import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SecuritiDoc {
    private int id;
    private String code;
    private String nameFull;
    private String cfi;
    private LocalDate dateTo;
    private LocalDate stateRegDate;
    private State state;
    private Currency currency;


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

    public String getCfi() {
        return cfi;
    }

    public void setCfi(String cfi) {
        this.cfi = cfi;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        this.dateTo = LocalDate.parse(dateTo, formatter);
    }

    public LocalDate getStateRegDate() {
        return stateRegDate;
    }

    public void setStateRegDate(String stateRegDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        this.stateRegDate = LocalDate.parse(stateRegDate, formatter);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "SecuritiDoc{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nameFull='" + nameFull + '\'' +
                ", cfi='" + cfi + '\'' +
                ", dateTo='" + dateTo + '\'' +
                ", stateRegDate='" + stateRegDate + '\'' +
                ", state=" + state +
                ", currency=" + currency +
                '}';
    }

    public String info(){
        LocalDate today = LocalDate.now();
        if (dateTo.isBefore(today)) return " Код: " + this.code + " Дата истечения: " + this.dateTo + " Владелец: " + this.getNameFull();
        else return null;
    }
}
