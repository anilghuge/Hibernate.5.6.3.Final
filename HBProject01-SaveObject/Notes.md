### **Signature of session.save(-) Method**
1. Serializable save(Object object):
	 	This method Generate id value ,keeps in id property,gives save object persistence
 	instruction to Hibernate f/w and return the generated id value back to Application
- Note: if no generator is configuration .. the value kept in identity 
 	property will be taken and will be return as the id value. in form     of Serializable Object
- Note: All Wrapper class Object are Serialiable Object in Java             Integer,Float,Long,String etc.
 
     1.With out generator Configuration
```
Product.hbm.xml
----------------
<hibernate-mapping>
 	<class name="com.hb.entity.Product">
 		<id name="pid" column="pid">
 		</id>
 		<property name="pname" column="pname"></property>
 		<property name="price" column="price"></property>
 		<property name="qty" column="qty"></property>
 	</class>
</hibernate-mapping>

Product prod=new Product();
			prod.setPid(1003);
			prod.setPname("Sofa2");
			prod.setPrice(5678.5f);
			prod.setQty(1.0f);
			Integer saveId = (Integer) session.save(prod);
System.out.println("Generated Id value :"+saveId);
 ```
    2.With generator Configuration
```
Product.hbm.xml
---------------
<hibernate-mapping>
 	<class name="com.hb.entity.Product">
 		<id name="pid" column="pid">
 		<generator class="increment"></generator> => uses max val+1 formula
 		</id>
 		<property name="pname" column="pname"></property>
 		<property name="price" column="price"></property>
 		<property name="qty" column="qty"></property>
 	</class>
 </hibernate-mapping>
 
 Product prod=new Product();
			prod.setPid(1003);
			prod.setPname("Sofa2");
			prod.setPrice(5678.5f);
			prod.setQty(1.0f);
			Integer saveId = (Integer) session.save(prod);
System.out.println("Generated Id value :"+saveId);=> gives max val+1 value

 let us assume max value in pk column of database table is 4561 then
 the "increment" generator generates 4561+1 as id value,keeps in id property return to client application

```