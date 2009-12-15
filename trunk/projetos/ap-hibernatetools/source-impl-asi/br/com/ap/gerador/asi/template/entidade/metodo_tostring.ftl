<#if pojo.needsToString()>    
	<#include "javadoc_metodo_tostring.ftl"/>
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(getClass().getName());
		buffer.append("@").append(Integer.toHexString(hashCode()));
		buffer.append(" [");
<#foreach property in pojo.getToStringPropertiesIterator()>
		buffer.append("${property.getName()}");
		buffer.append("='");
		buffer.append(${pojo.getGetterSignature(property)}());
		buffer.append("' ");			
</#foreach>
		buffer.append("]");
		return buffer.toString();
	}

</#if>