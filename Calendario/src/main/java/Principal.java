import java.io.IOException;

public class Principal {
	
	public static void main(String[] args) throws IOException {
		
		String dateI = "2019/05/20";//Lo ingresa en el feature
		String [] dateIParts = dateI.split("\\/");
		int dateYear = Integer.parseInt(dateIParts[0]);
		int dateMonth = Integer.parseInt(dateIParts[1]);
		int dateDay = Integer.parseInt(dateIParts[2]);
		String dateA = "Marzo 2019"; //Lo lee del calendario
		String [] dateAParts = dateA.split("\\s+");
		String monthA = dateAParts[0];
		int yearA = Integer.parseInt(dateAParts[1]);
		int numberMonthA = 0;		
		
		if(dateYear!=yearA) {
			System.out.println("Año ingresado invalido");
		}
		
		switch (monthA) {//Convierte los meses del calendario en enteros
		  case "Enero":
			numberMonthA = 1;
		    System.out.println(numberMonthA);
		    break;
		  case "Febrero":
			  numberMonthA = 2;
			    System.out.println(numberMonthA);
		    break;
		  case "Marzo":
			  numberMonthA = 3;
			    System.out.println(numberMonthA);
		    break;
		  case "Abril":
			  numberMonthA = 4;
			    System.out.println(numberMonthA);
		    break;
		  case "Mayo":
			  numberMonthA = 5;
			    System.out.println(numberMonthA);
		    break;
		  case "Junio":
			  numberMonthA = 6;
			    System.out.println(numberMonthA);
		    break;
		  case "Julio":
			  numberMonthA = 7;
			    System.out.println(numberMonthA);
		    break;
		  case "Agosto":
			  numberMonthA = 8;
			    System.out.println(numberMonthA);
			break;
		  case "Septiembre":
			  numberMonthA = 9;
			    System.out.println(numberMonthA);
			break;
		  case "Octubre":
			  numberMonthA = 10;
			    System.out.println(numberMonthA);
			break;
		  case "Noviembre":
			  numberMonthA = 11;
			    System.out.println(numberMonthA);
			break;
		  case "Diciembre":
			  numberMonthA = 12;
			    System.out.println(numberMonthA);
			break;
		}
			
		if(numberMonthA>dateMonth) {
			System.out.println("No se puede! Es Menos el mes ingresado al mes actual!");
		}
		else if(numberMonthA==dateMonth) {
			System.out.println("true");
		}
		else if(numberMonthA==(dateMonth+1)) {
			System.out.println("false");
		}
		else {
			System.out.println("La fecha ingresada no está habilitada!");
		}
		
		
		
		
		
		System.out.println("Mes:"+monthA+"\n"+"Año:"+yearA);
		System.out.println("Año:"+dateYear+"\n"+"Mes:"+dateMonth+"\n"+"Día:"+dateDay);
		
	}
		
}