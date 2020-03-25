package net.javaguides.springboot.gym.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_identity")
@SuppressWarnings("serial")
public class gymModel implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="adi")
    private String adi;
    @Column(name="soyadi")
    private String soyadi;
    @Column(name="telefon")
    private String telefon;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAdi() {
        return adi;
    }
    public void setAdi(String adi) {
        this.adi = adi;
    }
    public String getSoyadi() {
        return soyadi;
    }
    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
