package test.skillcheck.evenoddanswerer;

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
	public void testAnswer() throws Exception {
		assertEquals("Odd", this.get("1"));
		assertEquals("Even", this.get("2"));
		assertEquals("Odd", this.get("11"));
		assertEquals("Even", this.get("12"));
	}
	
	private String get(String number) throws Exception {
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		HtmlPage indexPage = null;

		String url = this.getBaseUrl() + "/skillcheck/evenoddanswerer/index.html";		
		WebRequest request = new WebRequest(new URL(url));
		indexPage = webClient.getPage(request);
	    ((HtmlInput) indexPage.getElementById("number")).setValueAttribute(number);
	    ((HtmlButton) indexPage.getElementById("execute_button")).click();
		for (int i = 0; i < 10; i++) {
            if (!indexPage.getElementById("answer").asText().isEmpty()) {
                break;
            }
            synchronized (indexPage) {
                indexPage.wait(500);
            }
        }		
		String answer = indexPage.getElementById("answer").asText();
		
		webClient.close();
		
		return answer;
	}


	protected String getBaseUrl() {
		return "http://localhost:8080/isp2";
	}

}
