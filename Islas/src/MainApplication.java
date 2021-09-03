
public class MainApplication {

	public static void main(String[] args) {
		int [][] datosPrueba = {
		                   {1, 0, 1, 0, 0},
		                   {1, 0, 0, 1, 0},
		                   {0, 0, 0, 0, 1},
		                   {1, 1, 1, 0, 0},
		                   {0, 0, 0, 0, 1}
		                   };
		int [][] datosPrueba1 = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
                };
		
		int total = getIslas(datosPrueba);
		
		System.out.println("El total de islas es: " + total);
	}

	
	
	public static int getIslas (int [][] matrizIslas) {
		int total = 0;
		
		for (int i=0; i<matrizIslas.length;i++) {
			for(int j=0;j<matrizIslas[i].length;j++) {
				if(matrizIslas[j][i] == 1) {
					total ++;
					//System.out.println("Isla: " +total);
					//Hacemos zeros todos los adyacentes
					matrizIslas = setZeros(matrizIslas,j,i);
				}
				
			}
		
		}
		return total;
	}
	
	
	public static int[][] setZeros(int [][] matrizIslas, int posX,int  posY){
		//imprime(matrizIslas, posX, posY);
		if(matrizIslas[posX][posY] == 0) {
			return matrizIslas;
		}
		
		matrizIslas[posX][posY] = 0;
		
		if(posX < matrizIslas.length-1) {
			matrizIslas = setZeros(matrizIslas,posX+1,posY);
		}
		
		if(posY < matrizIslas.length-1) {
			matrizIslas = setZeros(matrizIslas,posX,posY+1);
		}
		 
		if(posX < matrizIslas.length-1 && posY < matrizIslas.length-1) {
			matrizIslas = setZeros(matrizIslas,posX+1,posY+1);
		}
		
		if(posX > 0) {
			matrizIslas = setZeros(matrizIslas,posX-1,posY);	
		}

		if(posY > 0) {
			matrizIslas = setZeros(matrizIslas,posX,posY-1);	
		}
		
		if(posX > 0 && posY > 0) {
			matrizIslas = setZeros(matrizIslas,posX-1,posY-1);
		}
		if(posX < matrizIslas.length-1 && posY > 0) {
			matrizIslas = setZeros(matrizIslas,posX+1,posY-1);
		}
		if(posY < matrizIslas.length-1 && posX > 0) {
			matrizIslas = setZeros(matrizIslas,posX-1,posY+1);
		}
		return matrizIslas;
	}
	
	
	public static void imprime(int [][] matriz, int x, int y) {
		System.out.println("pos X :"+ x + " pos Y: " + y);
		for (int i=0; i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				//if(matrizIslas[j][i] == 1) {
					System.out.print(matriz[i][j] + " ");
				
			}
			System.out.println("");
		}
		System.out.println("********************************");
	}
}
 