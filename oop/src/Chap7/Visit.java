package Chap7;

import java.util.Date;

public class Visit {

    private Customer customer;

    private Date date;

    private double serviceExpense;

    private double productExpense;

    public Visit(String name,Date date){
        this.customer=new Customer(name);
        this.date=date;
    }

    public String getName(){
        return this.customer.getName();
    }

    public double getServiceExpense(){
        return serviceExpense;
    }

    public void setServiceExpense(double ex){
        if(customer.isMember())
        {
            serviceExpense=ex-ex*DiscountRate.getServiceDiscountRate(customer.getMemberType());
        }
        else
        {
            this.serviceExpense=ex;
        }
    }

    public double getProductExpense(){
        return productExpense;
    }

    public void setProductExpense(double ex){
        productExpense=ex-ex*DiscountRate.getProductDiscountRate(customer.getMemberType());
    }

    public double getTotal(){
        return serviceExpense+productExpense;
    }

    @Override
    public String toString(){
        return  "Visit{" +
                "customer=" + customer +
                ", date=" + date +
                ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense +
                ", totalExpense=" + (serviceExpense + productExpense) +
                '}';

    }

    

}
