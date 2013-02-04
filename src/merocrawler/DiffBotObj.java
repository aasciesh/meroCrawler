/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package merocrawler;

import java.util.List;




/**
 *
 * @author asish
 */
public class DiffBotObj {
    private int id;
    private String tagName;
    private List<Child> childNodes;

    public int getId() {return id;}
    public String getTagName() {return tagName;}
    public List<Child> getChildNodes() {return childNodes;}

    public void setId(int id) {this.id = id;}
    public void setTagName(String tagName) {this.tagName = tagName;}
    public void setChildNodes(List<Child> childNodes) {this.childNodes = childNodes;}
    
    
    
}
class Child
{
    private int id;
    private String tagName;
    private List<GrandChild> childNodes;
    
    public int getId() {return id;}
    public String getTagName() {return tagName;}
    public List<GrandChild> getChildNodes() {return childNodes;}
    
    public void setId(int id) {this.id = id;}
    public void setTagName(String tagName) {this.tagName = tagName;}
    public void setChildNodes(List<GrandChild> childNodes) {this.childNodes = childNodes;}
}
class GrandChild
{

    private String tagName;
    private List<String> childNodes;
    
    
    public String getTagName() {return tagName;}
    public List<String> getChildNodes() {return childNodes;}
    
    
    public void setTagName(String tagName) {this.tagName = tagName;}
    public void setChildNodes(List<String> childNodes) {this.childNodes = childNodes;}
}