/**
 * 
 */
package core;

/**
 * @author Huyfit JSOFT
 *
 */
public class Ex1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Sinh ngẫu nhiên giá trị nguyên (int) n trong phạm vi 100
		int n = (int) (Math.random() * 100);

		// In ra màn hình
		System.out.print("Giá trị của n=" + n);

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

		// Thông báo kết quả
		if (isPrime) {
			System.out.print(" là nguyên tố");
		} else {
			System.out.print(" KHÔNG nguyên tố");
		}

	}

}
