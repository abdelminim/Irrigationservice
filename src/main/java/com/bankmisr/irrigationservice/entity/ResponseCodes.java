package com.bankmisr.irrigationservice.entity;

import com.bankmisr.irrigationservice.utils.Value;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ResponseCodes {
    @Value(Value = "success")
    public static final int success = 200;


    @Value(Value = "general failure")
    public static final int noDataFound = 201;

    @Value(Value = "failure duplicated data")
    public static final int dataDuplicated = 202;
    @Value(Value = "failure mis matched data")
    public static final Object DATA_MIS_MATCHED = 203;

    public static String getDesc(int constantValue) {
        String Desc = "";
        Field[] interfaceFields = ResponseCodes.class.getFields();
        for (Field f : interfaceFields) {
            try {
                if (Integer.valueOf(f.get(null).toString()) == constantValue) {
                    Annotation annotation = f.getAnnotation(Value.class);
                    if (annotation instanceof Value) {
                        Value objValue = (Value) annotation;
                        Desc = objValue.Value();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Desc;

    }
}
