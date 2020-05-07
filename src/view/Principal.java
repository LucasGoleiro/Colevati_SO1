package view;

import java.util.concurrent.Semaphore;

import controller.ThreadSemaforo;


public class Principal {

	public static void main(String[] args) {
		int permissoes  = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idCarro = 0; idCarro < 4; idCarro++) {
			Thread tCarro = new ThreadSemaforo(idCarro + 1,semaforo);
			tCarro.start();
		}

	}

}
