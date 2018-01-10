package test.skillcheck.datesplitter;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class AppTest {

	@Test
	public void testExecute() throws Exception {
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		HtmlPage indexPage = null;

		String url = this.getBaseUrl() + "/skillcheck/datesplitter/index.html";
		WebRequest request = new WebRequest(new URL(url));
		indexPage = webClient.getPage(request);
	    ((HtmlInput) indexPage.getElementById("date")).setValueAttribute("2002-04-01");
	    ((HtmlButton) indexPage.getElementById("execute_button")).click();
		for (int i = 0; i < 10; i++) {
            if (!indexPage.getElementById("year").asText().isEmpty()) {
                break;
            }
            synchronized (indexPage) {
                indexPage.wait(500);
            }
        }		
		assertEquals("2002", indexPage.getElementById("year").asText());
		assertEquals("4", indexPage.getElementById("month").asText());
		assertEquals("1", indexPage.getElementById("day").asText());
		
		webClient.close();
	}

	protected String getBaseUrl() {
		return "http://localhost:8080/isp2";
	}

}