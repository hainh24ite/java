package Chap1;

public class InvoiceITem {

    private int qty;

    private String id,desc;

    private double unitPrice;

    public InvoiceITem(String id,String desc,int qty,double unitPrice) {
        this.id=id;
        this.desc=desc;
        this.unitPrice=unitPrice;
        this.qty=qty;
    }

    public String getId() {
        return id;
    }

    public String getDesc(){
        return desc;
    }

    public int getQty(){
        return qty;
    }

    public double getUnitPrice(){
        return unitPrice;
    }

    public double getTotal(){
        return unitPrice*qty;
    }
    public void setQty(int qty){
        this.qty=qty;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice=unitPrice;
    }
    public String toString(){
        return "InvoiceItem[Id="+id+",desc="+desc+",qty="+qty+",unitPrice="+unitPrice+"]";
    }
}
