package save.data;
//javac save\data\shopping_carbean.java
public class shopping_carbean {
    String[] columnName;
    String [][] tableRecord=null;
    public void setColumnName(String[] e){
        columnName=e;
    }
    public String[] getColumnName(){
        return columnName;
    }
    public void setTableRecord(String[][] e){
        tableRecord=e;
    }
    public String[][] getTableRecord(){
        return tableRecord;
    }
}
