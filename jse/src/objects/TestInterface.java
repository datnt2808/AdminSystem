package objects;

public class TestInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Khai báo
		ND nd1 = new NDImpl1();//BTX
		
		ND nd2_1 = new NDImpl2(); 
		BTX nd2_2 = new NDImpl2();
		BTH nd2_3 = new NDImpl2();
		TPTCT nd2_4 = new NDImpl2();
		BTTU nd2_5 = new NDImpl2();
		
		BTTU bt = new BTTUImpl();//BTX, BTH, TPTCT

	}

}
