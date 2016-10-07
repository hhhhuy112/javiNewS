package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.News;
import bo.NewsBO;

public class Test {

	public static void main(String[] args) {
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date)); 
		NewsBO news=new NewsBO();
		int sotin =news.numberAllNews2("9");
		ArrayList<News> news1=news.getListNewsByPage2(0, 3, "9");
		System.out.println(sotin+" "+news1.size()+" "+news1.get(0).getIdNews());
	}

}
