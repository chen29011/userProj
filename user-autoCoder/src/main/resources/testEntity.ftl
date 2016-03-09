package com.cqlj.user.autoCoder.entity;
import java.math.BigDecimal;

public class ${entityName} {
<#list fields as field>
	/** ${field.comment} */
  	private ${field.dataType} ${field.columnName};
</#list>
	
	/** 获取表名 */
    public String getTableName() {
        return "${tableName?lower_case}";
    }
    /** 不带参数的构造方法 */
    public ${entityName}() {
        super();
    }
	
<#list fields as field>
	<#-- 根据不同的类型，设置不同的方法名-->     
    public void set${field.columnName?cap_first}(${field.dataType} ${field.columnName}){
		this.${field.columnName} = ${field.columnName};
	}
	
	public ${field.dataType} get${field.columnName?cap_first}(){
		return this.${field.columnName};
	}
	
</#list>    
}