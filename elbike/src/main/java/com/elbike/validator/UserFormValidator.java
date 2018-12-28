package com.elbike.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.elbike.model.User;
import com.elbike.service.UserService;

//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-mvc-configuring
@Component
public class UserFormValidator implements Validator {

//    @Autowired
//    @Qualifier("emailValidator")
//    EmailValidator emailValidator;

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date1", "NotEmpty.userForm.date1");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date2", "NotEmpty.userForm.date2");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.userForm.sex");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.userForm.country");

//        if (!emailValidator.valid(user.getEmail())) {
//            errors.rejectValue("email", "Pattern.userForm.email");
//        }

        if (user.getCountry().equalsIgnoreCase("none")) {
            errors.rejectValue("country", "NotEmpty.userForm.country");
        }

    }

}
