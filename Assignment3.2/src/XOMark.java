public class XOMark extends Mark {

private boolean isXMark;

public XOMark(int space, boolean isXMark) {
	super(space);
	this.isXMark = isXMark;
}

public boolean isEmpty() {
	return false;
}

public String toString() {
	if (isXMark) {
		return "X";
	}
	else {
		return "O";
	}
}

}