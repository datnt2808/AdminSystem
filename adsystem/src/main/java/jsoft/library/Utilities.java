package jsoft.library;

import net.htmlparser.jericho.*;
import javax.servlet.*;

public class Utilities {

	/**
	 * Phương thức tách thông tin tên tác giả từ notes của các đối tượng<br>
	 * Thông tin tên tác giả được ghép trong Model tương ứng<br >
	 * 
	 * @param notes
	 * @param index
	 * @return
	 */
	public static String getInfo(String notes, byte index) {
		String tmp = "";
		if (notes != null && !notes.equalsIgnoreCase("")) {
			String[] note_name = notes.split("###");

			if (note_name != null && note_name.length > 0 && index < note_name.length) {
				tmp = note_name[index];
			}
		}

		return tmp;
	}

	public static String encodeToHtml(String uni) {
		return CharacterReference.encode(uni);
	}

	public static String decodeFromHtml(String html) {
		return CharacterReference.decode(html);
	}

	/**
	 * Phương thức lấy giá trị int của tham số trên URL<br >
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public static int getIntParam(ServletRequest request, String name) {
		int value = 0;

		String strValue = request.getParameter(name);
		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Integer.parseInt(strValue);
		}

		return value;
	}
	
	public static byte getBytearam(ServletRequest request, String name) {
		byte value = 0;

		String strValue = request.getParameter(name);
		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Byte.parseByte(strValue);
		}

		return value;
	}

}
