package Entidades;

public class Peon extends Ficha{
	
	public Peon(){
		
	}
	
	
	public boolean validarMovimiento (int filaAnt, int colAnt, int filaN, int colN) {

		boolean ban = false;
	
		if(filaAnt!=filaN && colAnt==colN && this.getColor().equals("Negro")) { if(filaAnt-1==filaN) {ban=true;} }
		if(filaAnt!=filaN && colAnt==colN && this.getColor().equals("Blanco")) { if(filaAnt+1==filaN) {ban=true;} }
		if(filaAnt!=filaN && colAnt!=colN) { if(filaAnt+1==filaN && colAnt+1==colN) {ban=true;} }
		if(filaAnt!=filaN && colAnt!=colN) { if(filaAnt+1==filaN && colAnt-1==colN) {ban=true;} }
				
		return ban;
	}
	

}