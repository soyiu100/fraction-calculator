
public class FracCalcItem {
	private int numerator;
	private int denominator;
	
	public FracCalcItem(int whole) {
		this(whole, 1);
	}
	
	public FracCalcItem(int whole, int num, int den) {
		this.numerator = den*whole + num;
		this.denominator = den;
	}
	
	public FracCalcItem(int num, int den) {
		this.numerator = num;
		this.denominator = den;
	}
	
	public void add(int otherNum, int otherDen) {
		if (this.denominator == otherDen) {
			this.numerator += otherNum;			
		} else {
			this.numerator = numerator * denominator + otherNum;
			this.denominator = otherDen * denominator;
			simplify();
		}
	}


	public void subtract(int otherNum, int otherDen) {
		add(-otherNum, -otherDen);
	}
	
	public void multiply(int otherNum, int otherDen) {
		this.numerator *= otherNum;
		this.denominator *= otherDen;
		simplify();
	}
	
	public void divide(int otherNum, int otherDen) {
		multiply(otherDen, otherNum);
	}
	
	// post: numerator returned, when improper fraction is asked
	public int getNumImprop() {
		return numerator;
	}	
	
	// post: denominator returned, both for mixed and improper fracs
	public int getDen() {
		return denominator;
	}
	
	// post: numerator returned, when proper fraction is asked
	public int getNumWhole() {
		return numerator % denominator;
	}
	
	public int getWholeNum() {
		return numerator / denominator;
	}
	
	// post: simplifies the fraction given
	private void simplify() {
		if (numerator % denominator == 0) {
			denominator /= numerator;
			numerator = 1;
		} else if (numerator % 2 == 0 && denominator % 2 == 0) {
			numerator /= 2;
			denominator /= 2;
			simplify();
		} else {
			for (int i = 3; i <= denominator/2; i += 2) {
				if (numerator % i == 0 && denominator % i == 0) {
					numerator /= i;
					denominator /= i;
					simplify();
					break;
				}
			}
		}
	}
	
	
}
