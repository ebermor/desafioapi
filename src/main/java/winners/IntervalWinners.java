package winners;

import java.util.ArrayList;
import java.util.List;


public class IntervalWinners {

	private List<Winners> min;

	private List<Winners> max;

	public List<Winners> getMin() {
		return min;
	}

	public void setMin(Winners min) {
		if (this.min == null) {
			this.min = new ArrayList<>();
		}
		this.min.add(min);
	}

	public List<Winners> getMax() {
		return max;
	}

	public void setMax(Winners max) {
		if (this.max == null) {
			this.max = new ArrayList<>();
		}
		this.max.add(max);
	}

}
