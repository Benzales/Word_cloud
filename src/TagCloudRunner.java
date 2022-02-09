import java.util.*;
import javax.swing.JFrame;

/*
 * URLs:
 * http://www.script-o-rama.com/movie_scripts/s/shrek-script-transcript-mike-myers.html
 * http://www.script-o-rama.com/movie_scripts/a1/bee-movie-script-transcript-seinfeld.html
 * https://www.internationalstudent.com/study-computer-science/what-is-computer-science
 * http://html.net/
 * https://www.english-grammar-revolution.com/list-of-pronouns.html
 * https://cywoods.cfisd.net/en/
 */

public class TagCloudRunner extends JFrame{
	private static final int WIDTH = 1400;
	private static final int HEIGHT = 1000;
	public TagCloudRunner() throws Exception {
		super("Da Runner");
		setSize(WIDTH,HEIGHT);
		MapMaker luke=new MapMaker();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter link:");
		String url = sc.nextLine();
		WebPageScanner ben=new WebPageScanner(url);
		ben.scrape();
		Map<String,Integer> m=luke.makeMap(ben.getList(), ben.getWorths());
		getContentPane().add(new TagCloudDisplay(m));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) throws Exception {
		TagCloudRunner run=new TagCloudRunner();
	}
}

	