
package com.lcj.annotation.exercise3;


public interface TableModel
{
    int getRowCount();
    
    int getColumnCount();
    
    String getColumnName(int columnIndex);
    
    Object getRecord(int rowIndex);
    
    String getCellValue(int rowIndex, int columnIndex);
}
