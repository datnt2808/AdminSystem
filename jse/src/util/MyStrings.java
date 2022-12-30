package util;

import java.util.*;

public class MyStrings {
	
	/**
	 * Đếm số ký tự trong chuỗi, có tùy chọn kiểu chữ khi đếm
	 * 
	 * @param str
	 * @param ch
	 * @param isIgnoreCase
	 * @return
	 */
	public static int countChar(String str, char ch, boolean isIgnoreCase) {
		int count = 0;
		
		//Nếu bỏ qua kiểu chữ HOA
		if(isIgnoreCase) {
			str = str.toLowerCase();
			ch = Character.toLowerCase(ch);
		}
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==ch) {
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * Phương thức chuẩn hóa một chuỗi ký tự
	 * 
	 * @param str
	 * @return
	 */
	public static String formatString(String str) {
		//Những ký tự đặc biệt cần loại bỏ khỏi chuỗi
		char[] chs = {
			'`','~','!','@','#','$','%','^',
			'&','*','(',')','-','_','=','+',
			'<','>','/','?',';',':','\'','"',
			'[',']','{','}','\\','|'
		};
		
		//Thực hiện loại bỏ
		for(char ch: chs) {
			str = str.replace(ch, ' ');
		}
		
		//Loại bỏ dấu cách thừa
		str = str.trim();
		while(str.indexOf("  ")!=-1) {
			str = str.replace("  ", " ");
		}
		
		str = str.replace(" . ", ". ");
		str = str.replace(" , ", ", ");
		
		return str;
	}
	
	/**
	 * Phương thức đếm số từ có trong chuỗi
	 * 
	 * @param str
	 * @return
	 */
	public static int countWords(String str) {
		//CHuẩn hóa
		str = MyStrings.formatString(str);
		
		return MyStrings.countChar(str, ' ', false) + 1;
	}
	
	
	public static String getWords(String str, byte nWords) {
		//CHuẩn hóa chuỗi
		str = MyStrings.formatString(str);
		
		//Xác định vị trí cần cắt
		int i;
		//Duyệt để xác định vị trí
		int count = 0;//Đếm dấu cách
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' && ++count >= nWords) break;
		}
		
		//Cắt và trả về chuỗi con
		if(i<str.length()-1) {
			return str.substring(0,i)+"...";
		}else {
			return str;
		}
		
	}
	
	
	public static HashMap<String, Integer> statisticWords(String str, String ch_split){
		HashMap<String, Integer> results = new HashMap<>();
		
		//Tạo mảng chuỗi từ trung gian
		String[] tmp_words = str.split(ch_split);
	
		for(String word: tmp_words) {
			if(word!=null && !word.equalsIgnoreCase("")) {
				word = word.toLowerCase().trim();
				
				if(results.containsKey(word)) {
					results.replace(word, results.get(word)+1);
				}else {
					results.put(word, 1);
				}
			}
		}
		
		
		return results;
	}
	
	public static void printStatisticWords(HashMap<String, Integer> words) {
		
		TreeMap<String, Integer> sorted_words = new TreeMap<>(words);
		
		for(Map.Entry<String, Integer> en: sorted_words.entrySet()) {
			System.out.println(en.getKey()+" - "+en.getValue());
		}
	}
	
	

	public static void main(String[] args) {
		//String str = "#anc###omh#anc#derf##mki#anc#anc##omh#mki";
		
		//MyStrings.printStatisticWords(MyStrings.statisticWords(str, "#"));
		
		String str = "Hàn Quốc bất ngờ mở tỷ số ngay giây thứ 22. Từ quả đá phạt góc của đồng đội, Shin Jong-hoo bắt vô lê chìm đưa bóng xuyên qua hai chân Châu Đoàn Phá vào cột xa hạ thủ thành Hồ Văn Ý.";
		
		System.out.print(MyStrings.getWords(str, (byte)20));
		
	}
	
}
