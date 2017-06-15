package com.xie.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.xie.annotation.ToString;
import com.xie.bean.Obj2StringDto;
import com.xie.bean.PersonBean;

public class Object2String {

  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
    PersonBean person = new PersonBean("name","age","add","career");
    System.out.println(object2String(person));
  }


  /**
   * ObjectがStringをタイプに転換する
   *
   *
   * @param @param cls
   * @param @param obj
   * @param @return
   * @return String
   * @throws IllegalAccessException
   * @throws IllegalArgumentException
   */
  public static String object2String(Object obj)
      throws IllegalArgumentException, IllegalAccessException {

    List<Obj2StringDto> dtos = new ArrayList<Obj2StringDto>();
    Obj2StringDto dto = null;
    Class<? extends Object> cls = obj.getClass();
    // クラスのフィールドアレイ
    Field[] fields = cls.getDeclaredFields();
    for (Field field : fields) {
      ToString toString = field.getAnnotation(ToString.class);
      // フィールドのアクセスがtrueにする
      field.setAccessible(true);
      if (toString == null || !toString.ignore()) {
        dto = new Obj2StringDto();
        dto.setField(field.getName());
        dto.setValue(field.get(obj)==null?"":field.get(obj).toString());
        dto.setIndex(toString == null ? fields.length : toString.sortIndex());
        dtos.add(dto);
      }
    }
    // list sort
    Collections.sort(dtos);

    // String 輸出
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (Obj2StringDto o2s : dtos) {
      i++;
      sb.append(o2s.getField() + ":" + o2s.getValue());
      if (i < dtos.size()) {
        sb.append(System.lineSeparator());
      }
    }
    return sb.toString();
  }
}
