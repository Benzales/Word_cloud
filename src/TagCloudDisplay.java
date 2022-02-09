import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Map;

public class TagCloudDisplay extends Canvas
{
	Map<String,Integer> map;
	public TagCloudDisplay(Map<String,Integer> m)
	{
		map=m;
		setBackground(Color.WHITE);
	}

	public void paint( Graphics window )
	{
		int count=75;
		int space=30;
		int y=100;
		int lineNum=1;
		int h=0;
		for(String x:map.keySet()) {
			int freq=map.get(x);
			int size=freq*2;
//			if(size<20) size=20;
			Font nFont = new Font("Arial", Font.BOLD, size);
			window.setFont( nFont );
			FontMetrics g=window.getFontMetrics();
			int sum=0;
			for(int j=0; j<x.length(); j++) {
				sum+=g.charWidth(x.charAt(j));
			}
			if(lineNum%2==0) {
				h=0;
			}
			else {
				h=300;
			}
			if(count>1200-sum-h) {
				count =h+50;
				y+=100;
				lineNum++;
			}
			window.drawString(x, count, y);
			count+=space+sum;
		}
		
		
	}
}