/*
package com.lcj.annotation.exercise3;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;




public class ExtendedAnnotationTableModel extends AnnotationTableModel
{
    public static final int CHECKABLE_COLUMN_CHECKBOX = 0;
    
    public static final int CHECKABLE_COLUMN_RADIO = 1;
    
    private boolean containsCheckableColumn;
    
    private int checkableColumnType;
    
    private CheckboxValueProvider valueProvider;
    
    private List<TemplateColumn> templateColumns = new ArrayList<TemplateColumn>();
    
    private PaginationModel<?> paginationModel;
    
    public static <T> ExtendedAnnotationTableModel create(Class<T> clazz, Pagination<T> pagination, HttpServletRequest request)
    {
        return new ExtendedAnnotationTableModel(clazz, new PaginationModel<T>(pagination, request));
    }
    
    public <T> ExtendedAnnotationTableModel(Class<T> clazz, List<T> records)
    {
        super(clazz, records);
    }
    
    public <T> ExtendedAnnotationTableModel(Class<T> clazz, PaginationModel<T> paginationModel)
    {
        super(clazz, paginationModel.getPagination().getRecords());
        this.paginationModel = paginationModel;
    }
    
    public void bindCheckboxColumn(CheckboxValueProvider provider)
    {
        this.bindCheckableColumn(provider, CHECKABLE_COLUMN_CHECKBOX);
    }
    
    public void bindRadioColumn(CheckboxValueProvider provider)
    {
        this.bindCheckableColumn(provider, CHECKABLE_COLUMN_RADIO);
    }
    
    private void bindCheckableColumn(CheckboxValueProvider provider, int type)
    {
        this.valueProvider = provider;
        this.containsCheckableColumn = true;
        this.checkableColumnType = type;
    }
    
    public boolean isContainsCheckableColumn()
    {
        return containsCheckableColumn;
    }
    
    public int getCheckableColumnType()
    {
        return checkableColumnType;
    }
    
    public String getCheckedValue(int rowIndex)
    {
        return valueProvider.getValue(getRecord(rowIndex));
    }
    
    public void addTemplateColumn(TemplateColumn column)
    {
        this.templateColumns.add(column);
    }
    
    public List<TemplateColumn> getTemplateColumns()
    {
        return templateColumns;
    }
    
    public PaginationModel<?> getPaginationModel()
    {
        return paginationModel;
    }
}
*/