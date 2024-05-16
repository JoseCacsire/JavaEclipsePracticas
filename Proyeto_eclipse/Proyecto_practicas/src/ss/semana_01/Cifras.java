package semana_01;

public class Cifras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero = 2345; //abcd
		
		int a = numero/1000;
		int b = numero/100%10;
		int c = numero/10%10;
		int d = numero%10;
		
		int suma = a + b + c + d;
		
		System.out.println(suma);


	}

}
