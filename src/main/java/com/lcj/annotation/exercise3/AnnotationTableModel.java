/*
package com.lcj.annotation.exercise3;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import cn.com.dzh.platform.context.PlatformContextHolder;
import cn.com.dzh.platform.service.IDictionaryService;
import cn.com.dzh.platform.util.ContextUtil;
import cn.com.dzh.platform.util.DateUtils;


public class AnnotationTableModel implements TableModel
{
    private Class<?> clazz;
    
    private List<?> records;
    
    private List<Field> columnFields;
    
    private IDictionaryService dictionaryService;
    
    public <T> AnnotationTableModel(Class<T> clazz, List<T> records)
    {
        this.clazz = clazz;
        this.records = records;
        resolve();
        dictionaryService = ContextUtil.getApplicationBean("dictionaryService", IDictionaryService.class);
    }
    
    protected void resolve()
    {
        columnFields = TableMarkerResolver.resolve(clazz);
    }
    
    @Override
    public int getRowCount()
    {
        return records.size();
    }
    
    @Override
    public int getColumnCount()
    {
        return columnFields.size();
    }
    
    @Override
    public String getColumnName(int columnIndex)
    {
        String nameKey = columnFields.get(columnIndex).getAnnotation(TableColumnMarker.class).name();
        return PlatformContextHolder.getContext().getMessage(nameKey);
    }
    
    @Override
    public Object getRecord(int rowIndex)
    {
        return records.get(rowIndex);
    }
    
    @Override
    public String getCellValue(int rowIndex, int columnIndex)
    {
        Object record = records.get(rowIndex);
        Field field = columnFields.get(columnIndex);
        
        try
        {
            field.setAccessible(true);
            Object value = field.get(record);
            
            if (value instanceof Date)
            {
                DateTimeFormat format = field.getAnnotation(DateTimeFormat.class);
                String pattern = format == null ? "yyyy-MM-dd" : format.pattern();
                value = DateUtils.format((Date)value, pattern);
            }
            //Double类型不用科学计数法表示 bwl
            if (value instanceof Double)
            {
                NumberFormat format = field.getAnnotation(NumberFormat.class);
                String pattern = format == null ? "#,##0.00" : format.pattern();
                value = new DecimalFormat(pattern).format(value);
            }
            
            // 数据字典国际化
            DictionaryFormat format = field.getAnnotation(DictionaryFormat.class);
            
            if (null != format)
            {
                if (!(value instanceof Number))
                {
                    throw new IllegalStateException("DictionaryFormat field value should be number.");
                }
                
                String category = format.category();
                value = dictionaryService.getEntryText(category, ((Number)value).intValue());
            }
            
            return null == value ? "" : String.valueOf(value);
        }
        catch (IllegalArgumentException e)
        {
            throw e;
        }
        catch (IllegalAccessException e)
        {
            throw new IllegalStateException();
        }
    }
}
*/