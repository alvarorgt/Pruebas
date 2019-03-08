import java.io.IOException;

public class Principal {
	
	public static void main(String[] args) throws IOException {
		
		String dateI = "2019/04/01";//Lo ingresa en el feature
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
		else if((numberMonthA+1)==dateMonth) {
			System.out.println("false");
		}
		else {
			System.out.println("La fecha ingresada no está habilitada!");
		}
		
		int [][] matriz = {{1,2,3,4,5,6,7},{8,9,10,11,12,13,14},{15,16,17,18,19,20,21},{22,23,24,25,26,27,28},{29,30,31,1,2,3,4},{5,6,7,8,9,10,11}};
		System.out.println(matriz[5][6]);
		for(int i=0; i<=5;i++) {
			for(int j=0; j<=6;j++) {
				int x = matriz [i][j]; //leer el elemento en la posicion i j
				if(x==dateDay) {
					String attribute = "Day"; //leer el atributo del elemento en la posicion i j
					if(attribute.equals("Day")) {
						System.out.println("Click en el dia"+dateDay);//hacer click en el elemento en la posicion i j
					}
					else {
						System.out.println("System error");						
					}
				}
				
			}
		}
		
		
		
		
		
		System.out.println("Mes:"+monthA+"\n"+"Año:"+yearA);
		System.out.println("Año:"+dateYear+"\n"+"Mes:"+dateMonth+"\n"+"Día:"+dateDay);
		
	}
		
}