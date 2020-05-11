import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class IOHandler {

	public static void writeScore(String s, int n) {
		try {
			Writer writer = new FileWriter("text/AllScores.txt", true);
			writer.write(s);
			writer.write("$");
			writer.write(Integer.toString(n));
			writer.write("\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Map<String, Integer> readScore() {
		Map<String, Integer> A = new TreeMap<String, Integer>();
		Reader reader;
		try {
			reader = new FileReader("text/AllScores.txt");
			BufferedReader reader1 = new BufferedReader(reader);
			String line;
			try {
				line = reader1.readLine();
				while(line != null) {
					int x = line.indexOf("$");
					String s1 = line.substring(0,x);
					String s2 = line.substring(x+1, line.length());
					if (A.containsKey(s1)) {
						if (Integer.parseInt(s2) > A.get(s1)) {
							A.put(s1, Integer.parseInt(s2));
						}
					} else {
						A.put(s1, Integer.parseInt(s2));
					}
					line = reader1.readLine();
				}
				reader1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return A;
	}
	
	
	public static String[] bestPlayers(Map<String, Integer> A) {
		Map<String, Integer> B = copyMap(A);
		if (B.isEmpty()) {
			String[] output = {"","",""};
			return output;
		}
		List<String> players = new ArrayList<String>();
		int highScore = Collections.max(B.values());
		while (players.size() < 3) {
			for (Map.Entry<String, Integer> entry : B.entrySet()) {
				if(entry.getValue() == highScore && players.size() < 3) {
					players.add(entry.getKey());
				}
			}
			Collection<Integer> x = B.values();
			while (x.contains(highScore)) {
				x.remove(highScore);
			}
			if (!x.isEmpty()) {
				highScore = Collections.max(x);
			} else break;
		}
		String[] output = new String[3];
		String[] bestplayers = players.toArray(new String[players.size()]);
		if (bestplayers.length < 3) {
			for (int i = 0; i < 3; i++) {
				if (i < bestplayers.length) {
					output[i] = bestplayers[i];
				} else {
					output[i] = "";
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				output[i] = bestplayers[i];
			}
		}
		return output;
	}
	
	
	public static Map<String, Integer> copyMap(Map<String, Integer> A) {
		Map<String, Integer> B = new TreeMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : A.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			B.put(key, value);
		}
		return B;
	}

}
