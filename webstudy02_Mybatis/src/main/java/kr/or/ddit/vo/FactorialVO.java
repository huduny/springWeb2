package kr.or.ddit.vo;

public class FactorialVO {
	private int operand;
	private int result;

	public int getOperand() {
		return operand;
	}

	public void setOperand(int operand) {
		this.operand = operand;
		result = factorial(operand);
	}
	
	public int getResult() {
		return result;
	}
	
	public String getExpression() {
		return String.format("%d! = %d", operand, result);
	}

	private int factorial(int number) {
		if(number<=0) {
			throw new IllegalArgumentException("음수는 팩토리얼 연산 불가");
		}
		if (number==1) {
			return number;
		}else {
			
			return number * factorial(number-1);
		}
	}
}
