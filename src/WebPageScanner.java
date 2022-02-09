import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WebPageScanner {
	private URL myURL;
	private String stream;
	private ArrayList<Integer> worth;
	private ArrayList<String> list;
	
	public WebPageScanner(String s) {
		stream="";
		worth = new ArrayList<>();
		list = new ArrayList<>();
        try { 
        	myURL=new URL(s); 
        	URLConnection site=myURL.openConnection();
        	site.connect();
        	Scanner reader=new Scanner(site.getInputStream());
        	stream=reader.useDelimiter("\b").next();
        }
        catch(MalformedURLException e) {}
        catch(IOException e) {}
	}
	public void scrape() throws Exception {
		ArrayList<String> stands=new ArrayList<String>();
		Scanner pro=new Scanner(new File("pronouns.dat"));
		while(pro.hasNext()) stands.add(pro.nextLine().toUpperCase());
//		System.out.println(stream);
        Scanner file=new Scanner(stream);
        Map<String,Integer> head=new HashMap<>();  
        head.put(".*<h1>.*</h1>.*",10);
        head.put(".*<h2>.*</h2>.*",8);
        head.put(".*<h3>.*</h3>.*",6);
        head.put(".*<h4>.*</h4>.*",4);
        head.put(".*<h5>.*</h5>.*",2);
        head.put(".*<h6>.*</h6>.*",1);
        while(file.hasNext()){
        	boolean p=false;
        	int w=1;
        	String line=file.nextLine();
        	if(line.matches(".*<pre>.*")||line.matches(".*<p>.*")) {	
        		while(!line.matches(".*</pre>.*")&&!line.matches(".*</p>.*")) {
        			line=replace(line);
        			String[] words=line.split(" ");
            		for(String x:words) {
            			if(x.matches(".*[a-zA-Z]+.*")&&!stands.contains(x.toUpperCase())) {
            				worth.add(1);
            				System.out.println(x);
            				list.add(x);
            			}
            		}
            		line=file.nextLine();
        		}
        		line=replace(line);
        		String[] wors=line.split(" ");
        		for(String x:wors) {
        			if(x.matches(".*[a-zA-Z]+.*")) {
        				worth.add(1);
	        			list.add(x);
	        			System.out.println(x);
        			}
        		}
        	}
        	for(String x:head.keySet()) {
        		if(line.matches(x)) {
        			p=true;
        			switch(x.charAt(5)){
        			case '1': w=10;
        			break;
        			case '2': w=8;
        			break;
        			case '3': w=6;
        			break;
        			case '4': w=4;
        			break;
        			case '5': w=2;
        			break;
        			case '6': w=1;
        			break;
        			default: w=1;
        			}
        			line=line.replaceAll(x.substring(0,6),""); line=line.replaceAll(x.substring(8), "");
        		}
        	}
        	if(line.matches(".*<title>.*</title>.*")) {
        		line=line.replaceAll(".*<title>", ""); line=line.replaceAll("</title>.*", "");
        		p=true;
        		w=10;
        	}
        	if(line.matches(".*<a.*")||line.matches(".*</a>.*")||line.matches(".*<p.*")) {
        		p=true;
        		line=line.replaceAll(".*","");
        	}
        	if(p) {
        		replace(line);
        		String[] words=line.split(" ");
        		for(String x:words) {
        			if(x.matches(".*[a-zA-Z]+.*")) {
        				worth.add(w);
        				list.add(x);
        			}
        		}
        	}
        	p=false;
        }
	}
	public String replace(String s) {
		String replace="[-?.|:;,!]";
		String ps="<pre>";
		String pe="</pre>";
		String p="<p>";
		String e="</p>";
		s=s.replaceAll(replace,"");
		s=s.replaceAll(ps,"");
		s=s.replaceAll(pe,"");
		s=s.replaceAll(p,"");
		s=s.replaceAll(e,"");
		return s;
	}
	public ArrayList<String> getList(){
		return list;
	}
	public ArrayList<Integer> getWorths(){
		return worth;
	}
}
