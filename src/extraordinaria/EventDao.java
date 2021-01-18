/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraordinaria;

import java.util.List;


public interface EventDao {
    
    boolean create(Event event) throws Exception;
    boolean create(String nom, String descripcio) throws Exception;
    List<Event> readAll() throws Exception;
    boolean update(Event event) throws Exception;
    Event find(int id) throws Exception;
    boolean delete(Event event) throws Exception;
    boolean delete(int id) throws Exception;
    List<Event> readAllSystemEvents() throws Exception;
    
    
}
