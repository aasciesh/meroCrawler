/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package merocrawler;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asish
 */
public class RssParser {

     
    public static List<WebPageObj> getPages(URL url) throws IOException, FeedException {

        HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
        // Reading the feed  
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(httpcon));
        List entries = feed.getEntries();
        Iterator itEntries = entries.iterator();
        List<WebPageObj> myList = new ArrayList<>();
        while (itEntries.hasNext()) {
            SyndEntry entry = (SyndEntry) itEntries.next();
            WebPageObj webPage = new WebPageObj();
            webPage.setPageTitle(entry.getTitle());
            webPage.setPageRealURL(entry.getLink());
            webPage.setPageTitleText(entry.getDescription().getValue());
            webPage.setDate(entry.getPublishedDate());
            myList.add(webPage);
        }

        return myList;
    }
}
