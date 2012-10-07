package com.example.calculator;

public class Processor {

	private String calculation;
	
	Processor(){
		this.calculation = "";		
	}

	public String getResult() {
		return calculation;
	}
	
	/**
	 * The button pressed will append the operand to the existing list or operands if not "equals."
	 * Otherwise, "equals" will attempt to calculate the result.
	 * @param calculation
	 */

	public void insert(String calculation) {
		
		if(calculation.equals("C")){
			this.calculation = "";
		}else if (!calculation.equals("=")){
			this.calculation = this.calculation.concat(calculation);
		}else{
			calculate(this.calculation);
		}
	}
	
	/**
	 * This method will parse the string into tokens then calculate the desired result
	 * @param calculation
	 */
	
	private void calculate(String calculation){
		
		/* Variable Declaration */
		int result = 0;
		int numOfOperands = 1;
		
		String[] operand;
		String[] operator = new String[10];  // Maximum of 10 operators are allowed
		
		operand = calculation.split("[+-/*]"); // Will parse all digits into separate tokens
		
		/**
		 * The following will attempt to calcuate the desired result.
		 * Many errors can be made due to invalid user input. Our catch method will catch these errors upon input.
		 */
		
		try{
			
			result = Integer.parseInt(operand[0]);
		
			for(int i = 0, j = 0; i < calculation.length() ; i++){
				if(!Character.isDigit(calculation.charAt(i))){
					numOfOperands++;
					operator[j] = calculation.charAt(i) + "";
					j++;
				}
			}
		
			for(int i = 1; i < numOfOperands; i++){
				if(operator[i-1].equals("+"))
					result += Integer.parseInt(operand[i]);
				if(operator[i-1].equals("-"))
					result -= Integer.parseInt(operand[i]);
				if(operator[i-1].equals("/"))
					result = result / Integer.parseInt(operand[i]);
				if(operator[i-1].equals("*"))
					result = result * Integer.parseInt(operand[i]);
			}
			
			if(calculation.equals("1+1")){
				this.calculation = "I thought you were smart ... \n:-)";
			}else{
				this.calculation = result + "";
			}
		}catch(NumberFormatException e){
			this.calculation = "0";
		}catch(ArrayIndexOutOfBoundsException e){
			this.calculation = "Need moar operands!";
		}catch(ArithmeticException e){
			this.calculation = "To Infinity!\nAnd Beyond!";
		}
	}
}
