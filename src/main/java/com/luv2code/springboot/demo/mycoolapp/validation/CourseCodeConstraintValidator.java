package com.luv2code.springboot.demo.mycoolapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {



        boolean result ;
        System.out.println("theCode: " + theCode);

        if(theCode != null){
            result = theCode.startsWith(coursePrefix);
        }else{
            result = true;
        }

        return result;
    }
}
