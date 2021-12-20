package kr.or.ddit.vo;

import kr.or.ddit.enumpkg.OperatorType;

public class CalculateVO {
	private long leftOp;
	private long rightOp;
	
	private OperatorType operator; //오퍼레이터는 name만 넘어옴, 오퍼레이터가 가지고 있다.
	
	private long result;
	
	public long getLeftOp() {
		return leftOp;
	}
	public void setLeftOp(long leftOp) {
		this.leftOp = leftOp;
	}
	public long getRightOp() {
		return rightOp;
	}
	public void setRightOp(long rightOp) {
		this.rightOp = rightOp;
	}
	public OperatorType getOperator() {
		return operator;
	}
	public void setOperator(OperatorType operator) {
		this.operator = operator;
		
	}
	public long getResult() {
		result = operator.operate(leftOp, rightOp);
		return result;
	}
	
	public String getExpression() {
// 2*1=2
		return String.format("%d %s %d = %d", leftOp, operator.getSign(),rightOp,getResult());
		
	}
	
	
}
