public class TempConversion {

public TempConversion() {

}

public int ktoC(double k) {
	return (int) (k - 273.15);
}

public int ktoF(double k) {
	return (int) ((k - 273.15) * 9 / 5 + 32);
}
}
