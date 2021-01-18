/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraordinaria;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventDaoImpl extends Conexion implements EventDao {

    public static String accion;
    public static boolean isRealizado = false;
    public static List<Event> listaEventos = new ArrayList();

    @Override
    public boolean create(Event event) throws Exception {
        Connection c = conn();
        PreparedStatement ps = null;
        accion = "insert into event values(?,?,?,?,?)";
        try {
            ps = c.prepareStatement(accion);
            ps.setInt(1, event.getId());
            ps.setString(2, event.getNom());
            ps.setString(3, event.getDescripcio());
            ps.setDate(4, event.getDate());
            ps.setBoolean(5, event.isSystem());
            ps.execute();
            isRealizado = true;
        } catch (SQLException ex) {
            Logger.getLogger(EventDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isRealizado;
    }

    @Override
    public boolean create(String nom, String descripcio) throws Exception {
        Connection c = conn();
        PreparedStatement ps = null;
        Calendar data = new GregorianCalendar();
        int yyyy = data.get(Calendar.YEAR);
        int mm = data.get(Calendar.MONTH);
        int dd = data.get(Calendar.DAY_OF_MONTH);
        accion = "insert into event(nom,descripcio,data,system) values('" + nom + "','" + descripcio + "','" + yyyy + "-" + mm + "-" + dd + "',false)";
        ps = c.prepareStatement(accion);
        ps.execute();

        isRealizado = true;

        return isRealizado;
    }

    @Override
    public List<Event> readAll() throws Exception {
        Statement st = null;
        ResultSet r = null;
        Connection c = conn();

        String query = "SELECT * FROM event";

        try {
            st = c.createStatement();
            r = st.executeQuery(query);

            Event event;

            while (r.next()) {
                event = new Event(r.getString("nom"), r.getString("descripcio"),
                        r.getDate("data"), r.getBoolean("system"));
                event.setId(r.getInt("id"));
                listaEventos.add(event);
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        return listaEventos;
    }

    @Override
    public boolean update(Event event) throws Exception {
        PreparedStatement ps = null;
        Connection c = conn();

        accion = "UPDATE event SET nom=?, descripcio=? WHERE id=?";

        try {
            ps = c.prepareStatement(accion);
            ps.setString(1, event.getNom());
            ps.setString(2, event.getDescripcio());
            ps.setInt(3, event.getId());
            ps.execute();

            isRealizado = true;

        } catch (SQLException ex) {
            Logger.getLogger(EventDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isRealizado;
    }

    @Override
    public Event find(int id) throws Exception {

        Statement st = null;
        ResultSet r = null;
        Connection c = conn();
        accion = "select * from event where id = " + id;

        st = c.createStatement();
        r = st.executeQuery(accion);

        Event event;

        while (r.next()) {
            event = new Event(r.getString("nom"), r.getString("descripcio"),
                    r.getDate("data"), r.getBoolean("system"));
            event.setId(r.getInt("id"));
            listaEventos.add(event);

        }

        for (Iterator i = listaEventos.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
        return null;
    }

    @Override
    public boolean delete(Event event) throws Exception {
        PreparedStatement ps = null;
        Connection c = conn();

        String accion = "DELETE FROM event WHERE id=?";

        try {
            ps = c.prepareStatement(accion);
            ps.setInt(1, event.getId());
            ps.execute();

            isRealizado = true;

        } catch (SQLException ex) {
            Logger.getLogger(EventDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isRealizado;
    }

    @Override
    public boolean delete(int id) throws Exception {
        PreparedStatement ps = null;
        Connection c = conn();

        String accion = "DELETE FROM event WHERE id=?";

        try {
            ps = c.prepareStatement(accion);
            ps.setInt(1, id);
            ps.execute();

            isRealizado = true;

        } catch (SQLException ex) {
            Logger.getLogger(EventDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isRealizado;
    }

    @Override
    public List<Event> readAllSystemEvents() throws Exception {
        Statement st = null;
        ResultSet r = null;
        Connection c = conn();

        String query = "SELECT * FROM event where system = true";

        try {
            st = c.createStatement();
            r = st.executeQuery(query);

            Event event;

            while (r.next()) {
                event = new Event(r.getString("nom"), r.getString("descripcio"),
                        r.getDate("data"), r.getBoolean("system"));
                event.setId(r.getInt("id"));
                listaEventos.add(event);
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        return listaEventos;
    }

}
