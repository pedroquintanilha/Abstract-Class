package application;

import entities.TaxPayer;
import entities.Individual;
import entities.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner s = new Scanner (System.in);
		List<TaxPayer> listOfTaxPayers= new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int N = s.nextInt();

		
		for(int i=0;i<N;i++) {
			System.out.println("Tax payer #"+(i+1)+" data:");
			System.out.print("Individual or company (i/c)? ");
			char ch=s.next().charAt(0);
			
			if(ch=='i') {
				System.out.print("Name: ");
				s.nextLine();
				String name=s.nextLine();
				System.out.print("Anual income: ");
				double anualIncome=s.nextDouble();
				System.out.print("Health expenditures: ");
				double healthExpenditures=s.nextDouble();
				listOfTaxPayers.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else {
				System.out.print("Name: ");
				s.nextLine();
				String name=s.nextLine();
				System.out.print("Anual income: ");
				double anualIncome=s.nextDouble();
				System.out.print("Number of employees: ");
				int numberOfEmployees=s.nextInt();
				listOfTaxPayers.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		
		double sum=0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		
		for(TaxPayer taxpayer : listOfTaxPayers) {
			System.out.println(taxpayer.getName()+": $ "+String.format("%.2f",taxpayer.tax()));
			sum+=taxpayer.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ "+String.format("%.2f",sum));	
		s.close();
	}

}
