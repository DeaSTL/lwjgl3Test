package gameLoop;

public class Execute {
	public static void main(String[] args){
		Thread gameThread =new Thread(new GameThread("game thread"));
		gameThread.start();
	}
}
