import org.jsoup.nodes.DataNode;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;


public class NewsProcessor implements PageProcessor {

    private Site site = Site.me()//.setHttpProxy(new HttpHost("127.0.0.1",8888))
            .setRetryTimes(3).setSleepTime(1000).setUseGzip(true);

    private static String milNews = "https://mil.news.sina.com.cn/";

    @Override
    public void process(Page page) {
        List<String> urls= page.getHtml().links().all();
        for (int i = 0 ; i < urls.size() ; i ++) {
            System.out.println(urls.get(i));
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider spider = Spider
                .create(new NewsProcessor())
                .addUrl(milNews)
                .addPipeline(new ConsoleNewsPipeline())
                .thread(2);

        spider.run();
        spider.close();
    }
}
