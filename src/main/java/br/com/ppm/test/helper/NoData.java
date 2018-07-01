package br.com.ppm.test.helper;

import java.util.Objects;

/**
 * Class NoData
 *
 * @author Pedro T. Oliveira (pedrotoliveira)
 * @since 30/06/18 18:43
 */

public class NoData {
	
	private String value = "No Test Data";
	
	public String getValue() {
		return value;
	}
	
	public NoData setValue(String value) {
		this.value = value;
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof NoData)) return false;
		NoData noData = (NoData) o;
		return Objects.equals(value, noData.value);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
	
	@Override
	public String toString() {
		return "NoData[" +
				"value='" + value + '\'' +
				']';
	}
}
