package pojos;

public class RestfulBookingdatesPOJO {

    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public RestfulBookingdatesPOJO(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public RestfulBookingdatesPOJO() {
    }

    @Override
    public String toString() {
        return "RestfulBookingdatesPOJO{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
