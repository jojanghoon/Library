package org.book.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JsoupTest {
	@Test
	public void jstest()
	{
		Document doc;
		String tit="";
		try {
			doc = Jsoup.connect("https://www.nl.go.kr/NL/search/openApi/search.do?key=11d02e96170b0f22dcabf71d0443089a7b104ebc9ab04749291c3e659cb3111f&kwd=%ED%95%B4%EB%A6%AC%ED%8F%AC%ED%84%B0")
					.get();
			Elements title=doc.getElementsByTag("pub_info");
			if(title.size()>0)
			{
				tit=title.get(0).text();
			}
			log.info(tit);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
