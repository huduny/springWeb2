package kr.or.ddit.enumpkg;

public enum OperatorType {
   PLUS('+', new RealOperator() {
      public long operate(long leftOp, long rightOp) {
         return leftOp + rightOp;
      }
   }),
   MINUS('-', (leftOp, rightOp)->{return leftOp - rightOp;}),
   MULTIPLY('*', (leftOp, rightOp)->{ return leftOp * rightOp;}),
   DIVIDE('/', (leftOp, rightOp)->{ return leftOp / rightOp;}),
   MODULAR('%', (leftOp, rightOp)->{ return leftOp % rightOp;});
   
   private OperatorType(char sign, RealOperator operator) {
      this.sign = sign;
      this.operator = operator;
   }
   private RealOperator operator;
   
   
   private char sign;
   
   public char getSign() {
      return sign;
   }
   
   public long operate(long leftOp, long rightOp) {
	   return operator.operate(leftOp, rightOp);
   }
   
   @FunctionalInterface
   public static interface RealOperator {
      public long operate(long leftOp, long rightOp);
   }
   
}






















