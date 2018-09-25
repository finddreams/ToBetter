package com.finddreams.tobetter.app;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Gson反射解析
 *
 * @author liuxiang
 *         2016/5/24 14:04
 */
public class ClassTypeReflect {

    public static Type getModelClazz(Class<?> subclass) {
        return getGenericType(0, subclass);
    }

    private static Type getGenericType(int index, Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (!(superclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) superclass).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            throw new RuntimeException("Index outof bounds");
        }

        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return params[index];
    }
}