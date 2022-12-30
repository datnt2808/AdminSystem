package objects;

public class TestManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Địa chỉ
		Address addr = new Address("Hà Nội", "Bắc Từ Liêm", "Nhổn");

		Student s = new Student("Hải", "Nguyễn Văn", (byte) 20, addr, 22_09_09_123, "CNTT");
		Employee e = new Employee("Linh", "Nguyễn Phương", (byte) 25, addr, 15_000_000, "Nhân viên QTKD");
		
		//--------------------------------------------------------
		
		Manager sm = new StudentManager();
		Manager em = new EmployeeManager();
		
		System.out.println(sm.getInfo(s));
		System.out.println(em.getInfo(e));

	}

}
