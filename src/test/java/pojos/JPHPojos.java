package pojos;

public class JPHPojos {

    //1- Tum veriable'lar private olarak olusturulur

    private String title;
    private String body;
    private int userId;
    private int id;

    //2-Getter() ve Setter()


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //3-parametreli constructor olustur

    public JPHPojos(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    //4- Olen default gorevini yapacak bir parametresiz constructor olusturduk
    public JPHPojos() {
    }

    @Override
    public String toString() {
        return "JPHPojos{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }

}
