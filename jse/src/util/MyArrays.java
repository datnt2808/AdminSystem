package util;

import java.util.*;

import objects.Person;

public class MyArrays {

	/**
	 * Phương thức sinh ngẫu nhiên giá trị cho mảng 1 chiều, các phần tử mảng có giá
	 * trị trong phạm vi [0-100)
	 * 
	 * @param n - Kích thước của mảng
	 * @return
	 */
	public static int[] generateArray(int n) {
		int[] arrInt = new int[n];

		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = (int) (Math.random() * 100);
		}

		return arrInt;
	}

	/**
	 * 
	 * @param rows - số dòng
	 * @param cols - số cột
	 * @return
	 */
	public static int[][] generateArray(int rows, int cols) {
		int[][] arrInt = new int[rows][cols];

		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = MyArrays.generateArray(cols);
		}

		return arrInt;
	}

	/**
	 * Sinh ngẫn nhiên một danh sách n thành phần
	 * 
	 * @param n - Số người cần sinh ngẫu nhiên
	 * @return - Trả về 1 danh sách Person
	 */
	public static Person[] generatePerson(int n) {
		//Danh sách tên
		String[] firstNames = {
			"Anh","Tuấn Anh","Anh Tuấn","Minh","Chinh","Trang","Yến","Yến Anh",
			"Hùng","Hải","Phương","Thủy","Linh","Minh Châu","Châu Anh","Anh Kiệt",
			"Hương","Hân","Ngọc Hân","Ngọc Anh", "Huyền Anh", "Minh Anh"
		};
		
		//Danh sách họ
		String[] lastNames = {
				"Hoàng","Lê","Nguyễn","Trần","Trầm","Ban","Bùi","Đào",
				"Đoàn","Dự","Dương","Vương","Ngô","Vũ","Lưu","Ma",
				"Quách","Võ","Tôn Nữ","Lý","Huỳnh","Hồ","Hồng","Trương"
		};
		
		//Khai báo danh sách
		Person[] list = new Person[n];
		int index;
		
		//Sinh giá trị
		for(int i=0; i<list.length; i++) {
			//Khởi tạo bộ nhớ cho phần tử mảng
			list[i] = new Person();
			
			//Sinh ngẫu nhiên tên
			index = (int)(Math.random()*firstNames.length);
			list[i].setFirstName(firstNames[index]);
			
			//Sinh họ
			index = (int)(Math.random()*lastNames.length);
			list[i].setLastName(lastNames[index]);
			
			//Sinh tuổi
			index = 18 + (int)(Math.random()*5);
			list[i].setAge((byte)index);
			
		}
		
		return list;
	}
	
	
	
	/**
	 * Phương thức sắp xếp mảng theo một thứ tự được xác định bởi isINC
	 * 
	 * @param arrInt
	 * @param isINC  - true là tăng dần, false là không tăng
	 * @return
	 */
	public static int[] sortedArrays(int[] arrInt, boolean isINC) {

		// Xác định hướng sắp xếp
		byte ori = (byte) (isINC ? 1 : -1);

		int tmp;
		for (int i = 0; i < arrInt.length - 1; i++) {
			for (int j = i + 1; j < arrInt.length; j++) {
				if (arrInt[i] * ori > arrInt[j] * ori) {
					tmp = arrInt[i];
					arrInt[i] = arrInt[j];
					arrInt[j] = tmp;
				}
			}
		}

		return arrInt;

	}

	public static int[][] sortedArrays(int[][] arrInt, boolean isINC) {
		// Lấy kích thước của mảng
		int rows = arrInt.length;
		int cols = arrInt[0].length;

		// Mảng trung gian 1 chiều
		int[] tmp = new int[rows * cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				tmp[i * cols + j] = arrInt[i][j];
			}
		}

		// Sắp xếp
		tmp = MyArrays.sortedArrays(tmp, isINC);

		// Trả về giá trị đã sắp xếp cho mảng ban đầu
		int row = 0, col = 0;
		for (int i = 0; i < tmp.length; i++) {
			arrInt[row][col++] = tmp[i];

			if (i > 0 && (i+1) % cols == 0) {
				row++;
				col = 0;
			}

		}

		return arrInt;
	}

	/**
	 * Lọc các số nguyên tố trong mảng và để ở sau, sau đó sắp xếp theo thứ tự
	 * 
	 * @param arrInt
	 * @param isINC
	 * @return
	 */
	public static int[] filterPrime(int[] arrInt, boolean isINC) {
		// Sắp xếp
		arrInt = MyArrays.sortedArrays(arrInt, isINC);

		// Tách nguyên tố
		int[] temp1 = new int[arrInt.length];// Lưu Nguyên tố
		int[] temp2 = new int[arrInt.length];// Lưu KHÔNG Nguyên tố
		int t1 = 0, t2 = 0;// Biến chỉ số chạy theo 2 mảng trên để ghi nhận giá trị dần dần

		for (int value : arrInt) {
			if (core.Ex2.checkPrime(value)) {
				temp1[t1++] = value;
			} else {
				temp2[t2++] = value;
			}
		}

		// Ghép mảng temp1 vào đuôi temp2
		for (int i = t2; i < temp2.length; i++) {
			temp2[i] = temp1[i - t2];
		}

		return temp2;
	}

	/**
	 * Tìm kiếm danh sách Person được xác định bởi tên (name)
	 * 
	 * @param list
	 * @param name
	 * @return
	 */
	public static Person[] searchPerson(Person[] list, String name) {
		//Khai báo mảng kết quả
		Person[] results = null;
		
		//Đếm số kết quả để khởi tạo mảng
		int count = 0;
		for(Person p: list) {
			if(p.getFirstName().contains(name)) {
				count++;
			}
		}
		
		//Khởi tạo
		results = new Person[count];
		
		//Ghi nhận kết quả
		count = 0;
		for(Person p: list) {
			if(p.getFirstName().contains(name)) {
				results[count++] = p;
			}
		}
		
		return results;
	}
	
	public static ArrayList<Person> searchPersonV2(Person[] list, String name){
		//Khởi tạo mảng kết quả
		ArrayList<Person> results = new ArrayList<>();
		
		//Ghi nhận kết quả
		for(Person p: list) {
			if(p.getFirstName().contains(name)) {
				results.add(p);
			}
		}
		
		return results;
	}
	
	
	public static ArrayList<Person> sortedByAge(Person[] list, boolean isASC){
		//Khai báo một tập hợp trung gian
		ArrayList<Person> tmp = new ArrayList<>();
		
		//Chuyển list sang tmp
		Collections.addAll(tmp, list);
		
		//Sắp xếp trên tmp
		if(isASC) {
			Collections.sort(tmp);
		}else {
			Collections.sort(tmp, Collections.reverseOrder());//Giảm dần
		}
		
		return tmp;
	}
	
	
	public static ArrayList<Person> sortedByName(Person[] list, boolean isASC){
		//Khai báo một tập hợp trung gian
		ArrayList<Person> tmp = new ArrayList<>();
		
		//Chuyển list sang tmp
		Collections.addAll(tmp, list);
		
		//Xác định điều kiện sắp xếp
		//ByName bn = new ByName();
		
		//Sắp xếp trên tmp
		if(isASC) {
			Collections.sort(tmp, new ByName());
		}else {
			Collections.sort(tmp, Collections.reverseOrder(new ByName()));//Giảm dần
		}
		
		return tmp;
	}
	
	
	/**
	 * Phương thức in giá trị các phần tử mảng 1 chiều, theo JDK5
	 * 
	 * @param arrInt
	 */
	public static void printArray(int[] arrInt) {
		for (int value : arrInt) {
			System.out.print(value + " ");
		}

		System.out.println();
	}

	/**
	 * In mảng 2 chiều ra màn hình
	 * 
	 * @param arrInt
	 */
	public static void printArray(int[][] arrInt) {
		for (int[] row : arrInt) {
			MyArrays.printArray(row);
		}
	}
	
	public static void printPerson(Person[] list) {
		for(Person p: list) {
			System.out.println(p);
		}
	}
	
	public static void printPerson(ArrayList<Person> list) {
		//Sử dụng java 8
		list.forEach(p -> System.out.println(p));
	}
	

	public static void main(String[] args) {
		// Sinh mảng
		Person[] list = MyArrays.generatePerson(200);
		
		//In danh sách
		MyArrays.printPerson(list);
		
		System.out.println("-------------------------");
		
		//Tìm kiếm
		ArrayList<Person> results = MyArrays.sortedByName(list, true);
		
		MyArrays.printPerson(results);
		

	}

}


class ByName implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
		
		String name1 = p1.getFirstName();
		String name2 = p2.getFirstName();
		
		//Xác định vị trí để cắt ra tên (chỉ tên - 1 từ)
		int at = name1.lastIndexOf(' ');
		if(at!=-1) {
			name1 = name1.substring(at+1);
		}
		
		at = name2.lastIndexOf(' ');
		if(at!=-1) {
			name2 = name2.substring(at+1);
		}
		
		
		return name1.compareToIgnoreCase(name2);
	}
	
}




