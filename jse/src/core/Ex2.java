package core;

/**
 * Lớp đối tượng thực hiện xây dựng các <b>phương thức static</b> để xử lý một số kỹ thuật
 * <br >
 * <i>Cập nhật ngày 16/08/2022</i>
 * <br />
 * @author Huyfit JSOFT
 *
 */
public class Ex2 {

	/**
	 * Phương thức này được sử dụng để kiểm tra một giá n có phải <b>nguyên tố</b>?
	 * <br >
	 * <i>Cập nhật 16/08/2022</i>
	 * <br>
	 * @param n - Giá trị cần kiểm tra
	 * @return - trả về xác nhận true là nguyên, false là không nguyên tố
	 * @author Huyfit JP223-2
	 */
	public static boolean checkPrime(int n) {
		// Biến xác nhận có là nguyên tố hay không?
		boolean isPrime = true;

		// Kiểm tra
		if (n < 2) {
			isPrime = false;
		} else {
			for (int v = 2; v <= (int) (Math.sqrt(n)); v++) {
				if (n % v == 0) {
					isPrime = false;
					break;
				}
			}
		}

		return isPrime;
	}

	/**
	 * Phương thức tính giai thừa của n, n trong phạm vi từ 0-1000
	 * <br>
	 * <i>Cập nhật 16/08/22/<i>
	 * <br>
	 * @param n
	 * @return
	 */
	public static long getGT(int n) {
		long value = -1;

		if ((n <= 1000) && (n >= 0)) {
			if (n == 0) {
				value = 1;
			} else {
				value = 1;
				for (int v = 1; v <= n; v++) {
					value *= v;
				}
			}
		}

		return value;
	}

	/**
	 * This method is used to get UCLN from two parameters
	 * <br>
	 * <i>Update 16/08/22</i>
	 * <br>
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getUCLN(int a, int b) {
		int ucln = -1;
		if (a * b != 0) {
			while (a != b) {
				if (a > b) {
					a -= b; // a=a-b
				} else {
					b -= a;
				}
			}

			ucln = a; // b
		}

		return ucln;
	}

	/**
	 * This method is used to get UCLN from three parameters
	 * <br>
	 * <i>Update 16/08/22</i>
	 * <br>
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int getUCLN(int a, int b, int c) {
		return Ex2.getUCLN(Ex2.getUCLN(a, b), c);
	}
	
	
	public static void main(String[] args) {

		int n = (int) (Math.random() * 100);
		int m = (int) (Math.random() * 100);

		System.out.print("UCLN của n="+n+" và m="+m+" là: "+Ex2.getUCLN(n, m));

	}

}
