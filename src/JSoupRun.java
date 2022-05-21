import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupRun {

	public static void main(String[] args) throws IOException {

		Document doc = Jsoup.connect("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm").get();
		Elements paragraphs = doc.select("p");
//		for (Element p : paragraphs) {
		
//			//System.out.println(p.text());
//		}
		
	}
}
