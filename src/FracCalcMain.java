
public class FracCalcMain implements Runnable {
	
	public FracCalcMain() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		FracCalcFrame fcf = new FracCalcFrame();		
	}
	
	public static void main(String[] args) {
		new FracCalcMain();
	}
}
