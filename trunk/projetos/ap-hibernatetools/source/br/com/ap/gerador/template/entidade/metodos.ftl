<#foreach property in pojo.getAllPropertiesIterator()>
<#if pojo.getMetaAttribAsBool(property, "gen-property", true)>
<#if property.equals(clazz.identifierProperty)>
	/**
	 * @return O identificador desta entidade
	 */
	public ${pojo.importType("java.io.Serializable")} getIdentificador() {
		return getId();
	}
	
	/**
	 * @return O valor do atributo id
	 */
    ${pojo.getPropertyGetModifiers(property)} ${pojo.getJavaTypeName(property, jdk5)} getId() {
        return this.id;
    }
    
	/**
	 * @param id atribui um valor ao atributo id
	 */
    ${pojo.getPropertySetModifiers(property)} void setId(${pojo.getJavaTypeName(property, jdk5)} id) {
        this.id = id;
    }

<#else>
	/**
	 * @return O valor do atributo ${property.name}
	 */
	${pojo.getPropertyGetModifiers(property)} ${pojo.getJavaTypeName(property, jdk5)} ${pojo.getGetterSignature(property)}() {
        return this.${property.name};
    }
    
    /**
	 * @param ${property.name} atribui um valor ao atributo ${property.name}
	 */
	${pojo.getPropertySetModifiers(property)} void set${pojo.getPropertyName(property)}(${pojo.getJavaTypeName(property, jdk5)} ${property.name}) {
        this.${property.name} = ${property.name};
    }
    
</#if>
</#if>
</#foreach>
