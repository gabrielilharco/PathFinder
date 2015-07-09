package pathfinder.representations.primitives;

public class LineInfo {
	private int start;
	private int end;
	public final int sourceStart;
	public final int sourceEnd;
	
	public LineInfo(int start, int end, int sourceStart, int sourceEnd) {
		this.setStart(start);
		this.setEnd(end);
		this.sourceStart = sourceStart;
		this.sourceEnd = sourceEnd;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
