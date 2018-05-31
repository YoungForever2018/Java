package reflection;

import java.lang.reflect.Field;

public class ReflectFields {

	public static void main(String[] args) {

		Class<?> c = Reflect.getClass("reflect.Teacher");

		//Ϊ���г�Ա��������ֵ����ӡ
		Field[] declaredFields = getField(c, 2);
			
		try {
			Object object = c.getConstructor().newInstance();
			for (Field declaredField : declaredFields) {
				String fieldName = declaredField.getName();
				declaredField.setAccessible(true); //����ֵʱ���Է������η�
				
				switch (fieldName) {
				case "name":
					declaredField.set(object, "elvis");
					break;
				case "age":
					declaredField.set(object, 20);
					break;
				case "sex":
					declaredField.set(object, "man");
					break;
				default:
					break;
				}
			}
			
			Teacher teacher = (Teacher)object;
			System.out.println(teacher.sex);
			System.out.println(teacher.getName());
			System.out.println(teacher.getAge());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ���еĻ������Ѷ���ĳ�Ա����,modifier==1 ��ʾȡ����
	 */
	public static Field[] getField(Class<?> c , int modifier){
		Field[] fields  = null;
		if(modifier == 1){
			fields = c.getFields();
		}else if(modifier ==2){
			fields = c.getDeclaredFields();
		}
		return fields;
	}
	
	/**
	 * ��ȡ���еĻ������Ѷ���ĳ�Ա����,modifier==1 ��ʾȡ����
	 */
	public static Field getField(Class<?> c , String name , int modifier){
		Field field = null;
		try {
			if(modifier == 1){
				field = c.getField(name);
			}else if(modifier ==2){
				field = c.getDeclaredField(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return field;
	}
}
