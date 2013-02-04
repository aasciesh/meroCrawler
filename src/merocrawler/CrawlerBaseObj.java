/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package merocrawler;

/**
 *
 * @author asish
 */
public class CrawlerBaseObj {

    private String URL;
    private int publisherId;
    private String sourceType;

    public CrawlerBaseObj() {
        
    }

    public String getURL() {
        return URL;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }
}
