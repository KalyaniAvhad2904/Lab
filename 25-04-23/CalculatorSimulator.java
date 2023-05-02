package exception;

import java.util.Scanner;

class TaxCalculator
{
	public static double calculateTax(String empName,boolean isIndian,double empSal) throws 
								EmployeeNameInvalidException, CountryNotValidException, TaxNotEligibleException
	{
		if (empName == null || empName.isEmpty()) 
		{
            throw new EmployeeNameInvalidException("Employee name is null or empty");
        }
 
        if (!isIndian) 
        {
            throw new CountryNotValidException("Employee is not Indian");
        }
        
        double taxAmount = 0;
        
        if (empSal > 100000 && isIndian) 
        {
            taxAmount = empSal * 0.08;
        } 
        else if (empSal > 50000 && isIndian) 
        {
            taxAmount = empSal * 0.06;
        } 
        else if (empSal > 30000 && isIndian) 
        {
            taxAmount = empSal * 0.05;
        } 
        else if (empSal > 10000 && isIndian) 
        {
            taxAmount = empSal * 0.04;
        } 
        else 
        {
            throw new TaxNotEligibleException("Employee not eligible for tax");
        }
        
        return taxAmount;	
	}
}
public class CalculatorSimulator 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Enter your name:");
		String empName=sc.nextLine();
		System.out.println("Enter 1 if Indian and 0 if not:");
		boolean isIndian=sc.nextBoolean();
		System.out.println("Enter your Salary:");
		double empSal=sc.nextDouble();
		TaxCalculator obj=new TaxCalculator();
		//obj.calculateTax(empName, isIndian, empSal);
		
		try 
		{
            double taxAmount = obj.calculateTax(empName, isIndian, empSal);
            System.out.println("Tax amount for employee " + empName + " is " + taxAmount);
        } 
		catch (EmployeeNameInvalidException e) 
		{
            System.out.println(e.getMessage());
        }
		catch(CountryNotValidException e)
		{
			System.out.println(e.getMessage());
		}
		catch(TaxNotEligibleException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
