import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Ptt_Spider {
    public static void main(String[] args) throws IOException {
        try {
            Document doc = Jsoup.connect("https://www.ptt.cc/bbs/index.html").get();
            Elements hotClasses = doc.select("#main-container .b-ent a");
            for (Element hotClass : hotClasses) {
                String pttTitle = hotClass.select(".board-name").text();
                String articleSortDoc = hotClass.absUrl("href").toString();
                Document hotBoardDoc = Jsoup.connect(articleSortDoc).get();
                Elements articleSortClasses = hotBoardDoc.select("#main-container .r-ent .title a");
                for (Element articleSortClass  : articleSortClasses){
                    String articleTitle = articleSortClass.text();
                    String articleDoc = articleSortClass.absUrl("href").toString();
                    Document articleClasses = Jsoup.connect(articleDoc).get();

                    if (!articleClasses.select(".push").isEmpty()){
                        Element firstPush = articleClasses.select("#main-container #main-content .push").get(0);
                        String commitName = firstPush.select("span.f3.h1.push-userid ").text();
                        String firstCommit = firstPush.select("span.f3.push-content ").text();
                        System.out.println("Board: "+ pttTitle);
                        System.out.println("Article Title:"+ articleTitle);
                        System.out.println("Commit"+ commitName + firstCommit);
                    }
                    else {
                        System.out.println("Board: "+ pttTitle);
                        System.out.println("Article Title:"+ articleTitle);
                        System.out.println("Commit"+ null);
                    }
                }

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
