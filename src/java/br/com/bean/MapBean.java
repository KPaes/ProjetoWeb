/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

/**
 *
 * @author Karina
 */
import java.io.Serializable;  
  
import org.primefaces.model.map.DefaultMapModel;  
import org.primefaces.model.map.LatLng;  
import org.primefaces.model.map.MapModel;  
import org.primefaces.model.map.Marker;  
  
public class MapBean implements Serializable {  
  
    private MapModel simpleModel;  
  
    public MapBean() {  
        simpleModel = new DefaultMapModel();  
          
        //Shared coordinates  
        LatLng coord1 = new LatLng(323.52438, -46.83671);  
         
        //Basic marker  
        simpleModel.addOverlay(new Marker(coord1, "CEPRODEO"));  
          
    }  
  
    public MapModel getSimpleModel() {  
        return simpleModel;  
    }  
}