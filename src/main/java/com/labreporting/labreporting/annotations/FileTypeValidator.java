package com.labreporting.labreporting.annotations;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import com.labreporting.labreporting.services.FileService;

public class FileTypeValidator implements ConstraintValidator<FileType, String> {

	private FileService fileService;

	public FileTypeValidator(FileService fileService) {
		this.fileService = fileService;
	}

	String[] types;
	
	@Override
	public void initialize(FileType constraintAnnotation) {
		this.types = constraintAnnotation.types();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value==null || value.isEmpty()) {
			return true;
		}
		String fileType = fileService.detectType(value);
		for(String supportedType: this.types) {
			if(fileType.contains(supportedType)) {
				return true;
			}
		}
		
		String supportedTypes = Arrays.stream(this.types).collect(Collectors.joining(", "));
		
		context.disableDefaultConstraintViolation();
		HibernateConstraintValidatorContext hibernateConstraintValidatorContext = context.unwrap(HibernateConstraintValidatorContext.class);
		hibernateConstraintValidatorContext.addMessageParameter("types", supportedTypes);
		hibernateConstraintValidatorContext.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addConstraintViolation();
		return false;
	}

}
