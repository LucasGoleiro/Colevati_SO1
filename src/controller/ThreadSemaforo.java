package controller;

import java.util.concurrent.Semaphore;

public class ThreadSemaforo extends Thread{
	private int idCarro;
	private String sentido;
	private Semaphore semaforo;
	
	
	public ThreadSemaforo(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		
		if(this.idCarro == 1) {
			sentido = "Norte";
		} else if(this.idCarro == 2) {
			sentido = "Sul";
		} else if(this.idCarro == 3) {
			sentido = "Leste";
		}else if(this.idCarro == 4) {
			sentido = "Oeste";
		}
	}
	
	@Override
	public void run() {
		
		try {
			semaforo.acquire();
			Atravessa();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void Atravessa() {
		System.out.println("Carro " + idCarro + " atravessando sentido " + sentido);
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Carro " + idCarro + " atravessou");
	}
}
