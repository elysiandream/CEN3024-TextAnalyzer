import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TextAnalyzer {

	public static void main(String[] args) throws IOException {

		Document doc = Jsoup.connect("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm").get();
		Elements paragraphs = doc.select("p");
		Map<String, Integer> frequency = new HashMap<>();
		
		for (Element p : paragraphs) {
			String[] words = p.text().split(" ");
			
			for (String word: words) {
				String lowecaseWords = word.toLowerCase();
				String sanitizedWords = lowecaseWords.replaceAll("[^a-zA-Z]", ""); 

				if(frequency.containsKey(sanitizedWords)) {
					frequency.put(sanitizedWords, frequency.get(sanitizedWords) + 1);
				} else {
					frequency.put(sanitizedWords, 1);
				}
			}
		}
		
		ArrayList<WordStat> stats = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : frequency.entrySet()) {
			WordStat ws = new WordStat();
			ws.word = entry.getKey();
			ws.count = entry.getValue();
			stats.add(ws);
		}
		
		Collections.sort(stats, Collections.reverseOrder());
		
		for (int i = 0; i < 20; i++) {
			WordStat ws = stats.get(i);
			ws.print();
		}
		
	}
}
