package pablogtzgileta.com.sesion5.beans;

/**
 * Created by PabloPC on 9/1/2017.
 */

public class Alumno {

    private String name;
    private String phone;
    private String scholarship;
    private String sex;
    private String favoriteBook;
    private boolean practiceSport;

    public Alumno(String name, String phone, String scholarship,
                  String sex, String favoriteBook, boolean practiceSport) {
        setName(name);
        setPhone(phone);
        setScholarship(scholarship);
        setSex(sex);
        setFavoriteBook(favoriteBook);
        setPracticeSport(practiceSport);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getScholarship() {
        return scholarship;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFavoriteBook() {
        return favoriteBook;
    }

    public void setFavoriteBook(String favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    public boolean isPracticeSport() {
        return practiceSport;
    }

    public void setPracticeSport(boolean practiceSport) {
        this.practiceSport = practiceSport;
    }

    @Override
    public String toString() {
        return "Nombre: " + getName() +
                "\nTelefono: " + getPhone() +
                "\nEscolaridad: " + getScholarship() +
                "\nGénero: " + getSex() +
                ((!getFavoriteBook().equals("")) ? "\nLibro Favorito: " + getFavoriteBook() : "") +
                "\nPractica Deporte: " + ((isPracticeSport()) ? "Si" : "No");
    }


}
