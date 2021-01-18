/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraordinaria;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExtraordinariaMain {

    public static Event event1;
    public static Event event2;
    public static Event actualitzarEvent;
    public static Event find;
    public static int id = 27;
    public static List<Event> events = new ArrayList();
    public static List<Event> systemTrue = new ArrayList();

    public static void main(String[] args) throws Exception {

        EventDaoImpl edi = new EventDaoImpl();

        event1 = new Event("event1", "aaahdjwehi", Date.valueOf("2000-09-20"), false);
        event2 = new Event("event2","swswsw",Date.valueOf("1990-04-20"), true);
        actualitzarEvent = new Event("ACTUALIZADO","DESCRIPCION ACT",Date.valueOf("1990-08-30"),false);
//        boolean create = edi.create(event1);
//        boolean create2 = edi.create(event2);
        
       edi.delete(id);
        
//        events = edi.readAll();
//        for (Iterator i = events.iterator(); i.hasNext();) {
//            System.out.println(i.next());
//        }
//        
//        System.out.println("SYSTEM = TRUE");
//        System.out.println("============================");
//        systemTrue = edi.readAllSystemEvents();
//        for (Iterator i = systemTrue.iterator(); i.hasNext();) {
//            System.out.println(i.next());
//        }
//        
//        find = edi.find(id);
       // boolean a = edi.create("zzzz", "klk");
        //System.out.println(a);
    }

}
