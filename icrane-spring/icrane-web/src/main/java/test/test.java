package test;

import java.text.SimpleDateFormat;
import java.util.*;

public class test {

	public static void main(String[] args) {
		Random random=new Random();
		Set<String> set = new HashSet<>();
		for (int i=0;i<=500;i++){
			int result=random.nextInt(99999);
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String da = format.format(new Date());
			set.add(da+result);
		}
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String str = it.next();
			//System.out.println(str);
		}

	}
}
