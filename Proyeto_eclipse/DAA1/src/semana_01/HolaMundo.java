package semana_01;

public class HolaMundo {
	public static void main(String[] args) {
		int numero = 2345,suma;
		suma = numero/1000 + numero/100%10 + numero/10%10 + numero%10;
		System.out.println(suma);	
	}

}
