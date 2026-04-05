package com.example.finance.dto;

public class SummaryDTO {

    private double totalIncome;
    private double totalExpense;
    private double netBalance;

    public SummaryDTO(double totalIncome, double totalExpense, double netBalance) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.netBalance = netBalance;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public double getNetBalance() {
        return netBalance;
    }
}