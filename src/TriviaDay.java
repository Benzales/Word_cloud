import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class TriviaDay {
	public static void main(String[] args) throws Exception {
		byte b=127;
		b+=257;
		System.out.println(b);
		float f=Float.MAX_VALUE;
		f+=f;
		System.out.println(f);
		long l=200L;
		System.out.println(l);
		float d=2.7F;
		d/=0;
		System.out.println(d);
//		int i=50L; compile error
		int binary=0b1001;
		System.out.println(binary);
		int hex=0xC0C;
		System.out.println(hex);
		int z=100;
//		z/=0;
//		System.out.println(z); run time error
		char[] cs=new char[8];
		for(int j=0; j<cs.length; j++) {
			cs[j]=(char)(j+88);
		}
		int a=2;
		System.out.println(a>2?a<4?"3":"4+":"<=2");
//		System.out.printf(a==2?"%s","yeet":"ahh");
		int[] ar= {7,4,2>1?10:75,44};
		for(int in:ar) {
			System.out.println(in);
		}
		int[][] mat= {{5,3,6,5},{3,7,4,0}};
		System.out.println(Arrays.deepToString(mat));
	}
}