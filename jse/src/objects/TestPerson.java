package objects;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Địa chỉ
		Address addr = new Address("Hà Nội", "Bắc Từ Liêm", "Nhổn");

		Person s = new Student("Hải", "Nguyễn Văn", (byte) 20, addr, 22_09_09_123, "CNTT");
		Person e = new Employee("Linh", "Nguyễn Phương", (byte) 25, addr, 15_000_000, "Nhân viên QTKD");

		System.out.println(e.toString());
		System.out.println(s.toString());

	}

}
