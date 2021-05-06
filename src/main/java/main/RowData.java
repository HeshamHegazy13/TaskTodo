/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author ali
 */
class RowData {
    private int id;
    private String minD;
    private String maxD;
    private float speed;
    private String code;
    
    
    public int getId(){return this.id;}
    public String getMinD(){return this.minD;}
    public String getMaxD() {return this.maxD;}
    public float getSpeed() {return this.speed;}
    public String getCode() {return this.code;}
   
    public void setId(int id){this.id = id;}
    public void setMinD(String minD){this.minD = minD;}
    public void setMaxD(String maxD){this.maxD = maxD;}
    public void setSpeed(float speed){this.speed = speed;}
    public void setCode(String code){this.code = code;}
    
}
