/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraordinaria;

import java.sql.Date;


public class Event {
    
    private int id;
    private String nom;
    private String descripcio;
    private Date date;
    private boolean system;

    public Event(String nom, String descripcio, Date date, boolean system) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.date = date;
        this.system = system;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + ", date=" + date + ", system=" + system + '}';
    }
    
    
    
    
}
