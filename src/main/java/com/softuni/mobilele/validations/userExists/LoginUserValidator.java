package com.softuni.mobilele.validations.userExists;

import com.softuni.mobilele.domain.dtos.binding.UserLoginFormDTO;
import com.softuni.mobilele.domain.dtos.models.UserModel;
import com.softuni.mobilele.domain.entities.User;
import com.softuni.mobilele.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public record LoginUserValidator(UserRepository userRepository,
                                 ModelMapper modelMapper)
        implements ConstraintValidator<ValidateLoginUser, UserLoginFormDTO>  {

    @Override
    public void initialize(ValidateLoginUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginFormDTO userLogin, ConstraintValidatorContext constraintValidatorContext) {

        Optional<User> loginCandidate = this.userRepository.findByUsername(userLogin.getUsername());

        return loginCandidate.isPresent()
                && loginCandidate.get()
                .getPassword()
                .equals(userLogin.getPassword());
    }
}
