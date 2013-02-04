/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package merocrawler;

import java.util.Date;

/**
 *
 * @author asish
 */
public class WebPageObj {
    private String pageTitle;
    private String pageTitleText;
    private String pageLocalLocation;
    private String pageS3LocationURL;
    private String pageRealURL;
    private boolean pageUploadedToS3= false;
    private boolean pageDetailUpdatedToPostgre= false;
    private Date date= new Date();
    private int publisherId;

    public WebPageObj() {
        
    }
    
    
    

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public void setPageTitleText(String pageTitleText) {
        this.pageTitleText = pageTitleText;
    }

    public void setPageLocalLocation(String pageLocalLocation) {
        this.pageLocalLocation = pageLocalLocation;
    }

    public void setPageS3LocationURL(String pageS3LocationURL) {
        this.pageS3LocationURL = pageS3LocationURL;
    }

    public void setPageRealURL(String pageRealURL) {
        this.pageRealURL = pageRealURL;
    }

    public void setPageUploadedToS3(boolean pageUploadedToS3) {
        this.pageUploadedToS3 = pageUploadedToS3;
    }

    public void setPageDetailUpdatedToPostgre(boolean pageDetailUpdatedToPostgre) {
        this.pageDetailUpdatedToPostgre = pageDetailUpdatedToPostgre;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getPageTitleText() {
        return pageTitleText;
    }

    public String getPageLocalLocation() {
        return pageLocalLocation;
    }

    public String getPageS3LocationURL() {
        return pageS3LocationURL;
    }

    public String getPageRealURL() {
        return pageRealURL;
    }

    public boolean isPageUploadedToS3() {
        return pageUploadedToS3;
    }

    public boolean isPageDetailUpdatedToPostgre() {
        return pageDetailUpdatedToPostgre;
    }

    public Date getDate() {
        return date;
    }

    public int getPublisherId() {
        return publisherId;
    }
    
    
}
