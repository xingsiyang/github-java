package xsy.lab3;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SqlUtil implements SqlUtilInterface
{
	//获取注解Table的值，即获取表名
	public String getTableName(Class clazz)
	{
		boolean flag = clazz.isAnnotationPresent(Table.class);
		if (flag)
		{
			Table table = (Table) clazz.getAnnotation(Table.class);
			return table.value();
		}
		else
		{
			return null;
		}
	}
	
	//获取注解Column的值，即获取表中属性名
	public String getColumnName(Field field)
	{
		boolean flag = field.isAnnotationPresent(Column.class);
		if (flag)
		{
			Column column = (Column) field.getAnnotation(Column.class);
			return column.value();
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public String query(User user) throws Exception
	{
		Class clazz = user.getClass();
		Field[] fields = clazz.getDeclaredFields();
		List<Field> list = new ArrayList<Field>();
		for (Field field : fields)
		{
			field.setAccessible(true);
			if (field.get(user) != null)
			{
				list.add(field);
			}
		}
		String str = "SELECT * FROM " + this.getTableName(clazz) + " WHERE ";
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).get(user) instanceof String)
			{
				str += this.getColumnName(list.get(i)) + " LIKE '" + list.get(i).get(user) + "' AND ";
			}
			else
			{
				str += this.getColumnName(list.get(i)) + " = " + list.get(i).get(user) + " AND ";
			}
		}
		str = str.substring(0, str.length() - 5);
		return str;
	}

	@Override
	public String insert(User user) throws Exception
	{
		Class clazz = user.getClass();
		Field[] fields = clazz.getDeclaredFields();
		List<Field> list = new ArrayList<Field>();
		for (Field field : fields)
		{
			field.setAccessible(true);
			if (field.get(user) != null)
			{
				list.add(field);
			}
		}
		String str = "INSERT INTO " + this.getTableName(clazz) + " (";
		for (int i = 0; i < list.size(); i++)
		{
			str += this.getColumnName(list.get(i)) + ", ";
		}
		str = str.substring(0, str.length() - 2);
		str += ") VALUES (";
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).get(user) instanceof String)
			{
				str += "'" + list.get(i).get(user) + "', ";
			}
			else
			{
				str += list.get(i).get(user) + ", ";
			}
		}
		str = str.substring(0, str.length() - 2);
		str += ")";
		return str;
	}

	@Override
	public String insert(List<User> users) throws Exception
	{
		List<Field> list = new ArrayList<Field>();
		for (int i = 0; i < users.size(); i++)
		{
			Class clazz = users.get(i).getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields)
			{
				field.setAccessible(true);
				if (field.get(users.get(i)) != null && !list.contains(field))
				{
					list.add(field);
				}
			}	
		}
		String str = "INSERT INTO " + this.getTableName(users.get(0).getClass()) + " (";
		for (int i = 0; i < list.size(); i++)
		{
			str += this.getColumnName(list.get(i)) + ", ";
		}
		str = str.substring(0, str.length() - 2);
		str += ") VALUES (";
		for (int i = 0; i < users.size(); i++)
		{
			for (int j = 0; j < list.size(); j++)
			{
				if (list.get(j).get(users.get(i)) instanceof String)
				{
					str += "'" + list.get(j).get(users.get(i)) + "', ";
				}
				else
				{
					str += list.get(j).get(users.get(i)) + ", ";
				}
			}
			str = str.substring(0, str.length() - 2);
			str += ") , (";
		}
		str = str.substring(0, str.length() - 4);
		return str;
	}

	@Override
	public String delete(User user) throws Exception
	{
		Class clazz = user.getClass();
		Field field = clazz.getDeclaredField("id");
		field.setAccessible(true);
		String str = "DELETE FROM " + this.getTableName(clazz) + " WHERE " + 
						this.getColumnName(field) + " = "  + field.get(user); 
		return str;
	}

	@Override
	public String update(User user) throws Exception
	{
		Class clazz = user.getClass();
		Field idField = clazz.getDeclaredField("id");
		idField.setAccessible(true);
		Field[] fields = clazz.getDeclaredFields();
		List<Field> list = new ArrayList<Field>();
		for (Field field : fields)
		{
			field.setAccessible(true);
			if (field.get(user) != null && !field.getName().equals("id"))
			{
				list.add(field);
			}
		}
		String str = "UPDATE " + this.getTableName(clazz) + " SET ";
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).get(user) instanceof String)
			{
				str += this.getColumnName(list.get(i)) + " = '" + list.get(i).get(user) + "', ";
			}
			else
			{
				str += this.getColumnName(list.get(i)) + " = " + list.get(i).get(user) + ", ";
			}
		}
		str = str.substring(0, str.length() - 2);
		str += " WHERE " + this.getColumnName(idField) + " = " + idField.get(user);
		return str;
	}

}
