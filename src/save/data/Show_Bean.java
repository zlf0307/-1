package save.data;
// javac save\data\Show_Bean.java
public class Show_Bean {
    int comNo;
    String comName;
    String comDes;
    String comSrc;
    int comPrice;
    public void setComNo(int newNo){
        comNo=newNo;
    }
    public int getComNo(){
        return comNo;
    }

    public void setComName(String newName){
        comName=newName;
    }
    public String getComName(){
        return comName;
    }

    public void setComDes(String newDes){
        comDes=newDes;
    }
    public String getComDes(){
        return comDes;
    }

    public void setComSrc(String newSrc){
        comSrc=newSrc;
    }
    public String getComSrc(){
        return comSrc;
    }

    public void setComPrice(int newPrice){
        comPrice=newPrice;
    }
    public int getComPrice(){
        return comPrice;
    }
}
