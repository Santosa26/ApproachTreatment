package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados da conta");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        System.out.print("Titular: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Saldo Inicial Conta: ");
        double balance = sc.nextDouble();
        System.out.print("Limite de saque: ");
        double withDrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, balance, withDrawLimit);

        System.out.println();
        System.out.print("Informe uma quantia para sacar: ");
        double amount = sc.nextDouble();

        try {
            acc.withDraw(amount);
            System.out.println("Novo saldo: " + String.format("%.2f", acc.getBalance()));
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
