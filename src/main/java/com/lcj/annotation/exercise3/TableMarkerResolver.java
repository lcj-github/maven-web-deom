
package com.lcj.annotation.exercise3;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public abstract class TableMarkerResolver
{
    
    public static List<Field> resolve(Class<?> clazz)
    {
        if (null == clazz.getAnnotation(TableRecordMarker.class))
        {
            System.out.println("Class {}, does not contains TableMarker annotation.");
            throw new IllegalArgumentException("Class was unsupported.");
        }
        
        Field[] fields = clazz.getDeclaredFields();
        
        List<Field> columnFields = new ArrayList<Field>();
        
        for (Field field : fields)
        {
            if (null == field.getAnnotation(TableColumnMarker.class))
            {
                continue;
            }
            
            columnFields.add(field);
        }
        
        Collections.sort(columnFields, new Comparator<Field>()
        {
            @Override
            public int compare(Field base, Field compared)
            {
                int baseIndex = base.getAnnotation(TableColumnMarker.class).index();
                int comparedIndex = compared.getAnnotation(TableColumnMarker.class).index();
                return baseIndex - comparedIndex;
            }
        });
        
        return columnFields;
    }
}
