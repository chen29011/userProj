package com.cqlj.user.autoCoder.entity;

public class ${entityName} {
<#list fields as field>
  	private ${field.type} ${field.name};
</#list>

    public String getTableName() {
        return "${tableName?lower_case}";
    }
      
    public ${entityName}() {
        super();
    }

<#list fields as field>
	<#-- 根据不同的类型，设置不同的方法名-->     
    public void set${field.name?cap_first}(${field.type} ${field.name}){
		this.${field.name} = ${field.name};
	}
	
	public ${field.type} get${field.name?cap_first}(){
		return this.${field.name};
	}
	
</#list>    
}