/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package merocrawler;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Diffbotparser {

    public static void main(String[] args) throws Exception {
        String jsonResponse = null;
        List<WebPageObj> myList = new ArrayList<>();
        try {
            System.out.println("Hello World!"); // Display the string.
            try {
                URLConnection connection = new URL("http://www.diffbot.com/api/frontpage?token=ef8e31dc96ea32fcd487a1b0135f2a6e&url=nagariknews.com/politics.html&format=json").openConnection();
                InputStream response = connection.getInputStream();
                java.util.Scanner s = new java.util.Scanner(response).useDelimiter("\\A");
                jsonResponse = s.hasNext() ? s.next() : "";

            } catch (MalformedURLException rex) {
                System.out.println("Oops my url isn't right");
            }
        } catch (IOException ex) {
        }

        String json = jsonResponse;

        // Now do the magic.
        DiffBotObj data = new Gson().fromJson(json, DiffBotObj.class);

        List<Child> childArray = data.getChildNodes();
System.out.println(data);
        for (Iterator<Child> i = childArray.iterator(); i.hasNext();) {
            Child item = i.next();
            
            if ("item".equals(item.getTagName())) {
                List<GrandChild> GrandchildArray = item.getChildNodes();
                WebPageObj webpage= new WebPageObj();
                for (Iterator<GrandChild> j = GrandchildArray.iterator(); j.hasNext();) {
                    SimpleDateFormat date = new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss zzz", Locale.ENGLISH);
                    GrandChild Gitem = j.next();
                        if ("title".equals(Gitem.getTagName()))
                        {
                            webpage.setPageTitle(Gitem.getChildNodes().get(0));
                        }
                        if ("link".equals(Gitem.getTagName()))
                        {
                            webpage.setPageRealURL(Gitem.getChildNodes().get(0));
                        }
                        if ("pubDate".equals(Gitem.getTagName()))
                        {
                            webpage.setDate(date.parse(Gitem.getChildNodes().get(0)));
                        }
                        if ("textSummary".equals(Gitem.getTagName()))
                        {
                            webpage.setPageTitleText(Gitem.getChildNodes().get(0));
                        }
                        
                        
                }
                myList.add(webpage);
            }
        }

       System.out.println(); // Show it.
        
    }
}
