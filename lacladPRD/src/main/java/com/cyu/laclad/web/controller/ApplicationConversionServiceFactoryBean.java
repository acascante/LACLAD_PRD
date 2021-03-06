package com.cyu.laclad.web.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

import com.cyu.laclad.domain.Admin;
import com.cyu.laclad.domain.ClassGroup;
import com.cyu.laclad.domain.Company;
import com.cyu.laclad.domain.Idiom;
import com.cyu.laclad.domain.Location;
import com.cyu.laclad.domain.Quiz;
import com.cyu.laclad.domain.QuizChoice;
import com.cyu.laclad.domain.QuizQuestion;
import com.cyu.laclad.domain.QuizStudent;
import com.cyu.laclad.domain.Student;
import com.cyu.laclad.domain.SystemUser;
import com.cyu.laclad.domain.Teacher;


@Configurable
/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

	@SuppressWarnings("deprecation")
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		registry.addConverter(createEnumConverter());
	}
	
	private Converter<Enum<?>, String> createEnumConverter() {
        return new Converter<Enum<?>, String>() {
            @Override
            public String convert(Enum<?> value) {
                String output = value.toString();
                try {
                    output = applicationContext.getMessage(value.toString(), null, LocaleContextHolder.getLocale());
                } catch (NoSuchMessageException e) {
                    System.err.println("No message resource found for " + value + " add this to the resource bundle");
                }
                return output;
            }
        };
    }
	
	public Converter<Admin, String> getAdminToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.Admin, java.lang.String>() {
            public String convert(Admin admin) {
                return new StringBuilder().append(admin.getPersonalId())
                		.append(' ')
                		.append(admin.getName())
                		.append(' ')
                		.append(admin.getPhoneNumber())
                		.append(' ')
                		.append(admin.getLastName()).toString();
            }
        };
    }

	public Converter<Long, Admin> getIdToAdminConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.Admin>() {
            public com.cyu.laclad.domain.Admin convert(java.lang.Long id) {
                return Admin.findAdmin(id);
            }
        };
    }

	public Converter<String, Admin> getStringToAdminConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.Admin>() {
            public com.cyu.laclad.domain.Admin convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Admin.class);
            }
        };
    }

	public Converter<ClassGroup, String> getClassGroupToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.ClassGroup, java.lang.String>() {
            public String convert(ClassGroup classGroup) {
                return new StringBuilder().append(classGroup.getCompany().getName())
                		.append(" -- ")
                		.append(classGroup.getName())
                		.append(" -- ")
                		.append(classGroup.getDescription()).toString();
            }
        };
    }

	public Converter<Long, ClassGroup> getIdToClassGroupConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.ClassGroup>() {
            public com.cyu.laclad.domain.ClassGroup convert(java.lang.Long id) {
                return ClassGroup.findClassGroup(id);
            }
        };
    }

	public Converter<String, ClassGroup> getStringToClassGroupConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.ClassGroup>() {
            public com.cyu.laclad.domain.ClassGroup convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ClassGroup.class);
            }
        };
    }

	public Converter<Company, String> getCompanyToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.Company, java.lang.String>() {
            public String convert(Company company) {
                return new StringBuilder().append(company.getName()).toString();
            }
        };
    }

	public Converter<Long, Company> getIdToCompanyConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.Company>() {
            public com.cyu.laclad.domain.Company convert(java.lang.Long id) {
                return Company.findCompany(id);
            }
        };
    }

	public Converter<String, Company> getStringToCompanyConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.Company>() {
            public com.cyu.laclad.domain.Company convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Company.class);
            }
        };
    }

	public Converter<Idiom, String> getIdiomToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.Idiom, java.lang.String>() {
            public String convert(Idiom idiom) {
                return new StringBuilder().append(idiom.getDescription()).toString();
            }
        };
    }

	public Converter<Long, Idiom> getIdToIdiomConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.Idiom>() {
            public com.cyu.laclad.domain.Idiom convert(java.lang.Long id) {
                return Idiom.findIdiom(id);
            }
        };
    }

	public Converter<String, Idiom> getStringToIdiomConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.Idiom>() {
            public com.cyu.laclad.domain.Idiom convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Idiom.class);
            }
        };
    }

	public Converter<Location, String> getLocationToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.Location, java.lang.String>() {
            public String convert(Location location) {
                return new StringBuilder().append(location.getDescription()).toString();
            }
        };
    }

	public Converter<Long, Location> getIdToLocationConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.Location>() {
            public com.cyu.laclad.domain.Location convert(java.lang.Long id) {
                return Location.findLocation(id);
            }
        };
    }

	public Converter<String, Location> getStringToLocationConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.Location>() {
            public com.cyu.laclad.domain.Location convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Location.class);
            }
        };
    }

	public Converter<Teacher, String> getTeacherToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.Teacher, java.lang.String>() {
            public String convert(Teacher teacher) {
                return new StringBuilder().append(teacher.getPersonalId()).append(' ').append(teacher.getName()).append(' ').append(teacher.getPhoneNumber()).append(' ').append(teacher.getLastName()).toString();
            }
        };
    }

	public Converter<Long, Teacher> getIdToTeacherConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.Teacher>() {
            public com.cyu.laclad.domain.Teacher convert(java.lang.Long id) {
                return Teacher.findTeacher(id);
            }
        };
    }

	public Converter<String, Teacher> getStringToTeacherConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.Teacher>() {
            public com.cyu.laclad.domain.Teacher convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Teacher.class);
            }
        };
    }

	public Converter<Student, String> getStudentToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.Student, java.lang.String>() {
            public String convert(Student student) {
                return new StringBuilder()
                		.append(student.getName())
                		.append(' ')
                		.append(student.getLastName()).toString();
            }
        };
    }

	public Converter<Long, Student> getIdToStudentConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.Student>() {
            public com.cyu.laclad.domain.Student convert(java.lang.Long id) {
                return Student.findStudent(id);
            }
        };
    }

	public Converter<String, Student> getStringToStudentConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.Student>() {
            public com.cyu.laclad.domain.Student convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Student.class);
            }
        };
    }
	
	public Converter<SystemUser, String> getSystemUserToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.SystemUser, java.lang.String>() {
            public String convert(SystemUser systemUser) {
                return new StringBuilder().append(systemUser.getUserName()).toString();
            }
        };
    }

	public Converter<Long, SystemUser> getIdToSystemUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.SystemUser>() {
            public com.cyu.laclad.domain.SystemUser convert(java.lang.Long id) {
                return SystemUser.findSystemUser(id);
            }
        };
    }

	public Converter<String, SystemUser> getStringToSystemUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.SystemUser>() {
            public com.cyu.laclad.domain.SystemUser convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), SystemUser.class);
            }
        };
    }

	public Converter<Quiz, String> getQuizToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.Quiz, java.lang.String>() {
            public String convert(Quiz quiz) {
                return new StringBuilder()
                		.append(quiz.getName()).toString();
            }
        };
    }

	public Converter<Long, Quiz> getIdToQuizConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.Quiz>() {
            public com.cyu.laclad.domain.Quiz convert(java.lang.Long id) {
                return Quiz.findQuiz(id);
            }
        };
    }

	public Converter<String, Quiz> getStringToQuizConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.Quiz>() {
            public com.cyu.laclad.domain.Quiz convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Quiz.class);
            }
        };
    }

	public Converter<QuizChoice, String> getQuizChoiceToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.QuizChoice, java.lang.String>() {
            public String convert(QuizChoice quizChoice) {
                return new StringBuilder().append(quizChoice.getOptionNumber()).append(' ').append(quizChoice.getDescription()).toString();
            }
        };
    }

	public Converter<Long, QuizChoice> getIdToQuizChoiceConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.QuizChoice>() {
            public com.cyu.laclad.domain.QuizChoice convert(java.lang.Long id) {
                return QuizChoice.findQuizChoice(id);
            }
        };
    }

	public Converter<String, QuizChoice> getStringToQuizChoiceConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.QuizChoice>() {
            public com.cyu.laclad.domain.QuizChoice convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), QuizChoice.class);
            }
        };
    }

	public Converter<QuizQuestion, String> getQuizQuestionToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.QuizQuestion, java.lang.String>() {
            public String convert(QuizQuestion quizQuestion) {
                return new StringBuilder().append(quizQuestion.getQuestionNumber())
                		.append(" - ")
                		.append(quizQuestion.getStatement()).toString();
            }
        };
    }

	public Converter<Long, QuizQuestion> getIdToQuizQuestionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.QuizQuestion>() {
            public com.cyu.laclad.domain.QuizQuestion convert(java.lang.Long id) {
                return QuizQuestion.findQuizQuestion(id);
            }
        };
    }

	public Converter<String, QuizQuestion> getStringToQuizQuestionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.QuizQuestion>() {
            public com.cyu.laclad.domain.QuizQuestion convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), QuizQuestion.class);
            }
        };
    }
	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }

	public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getAdminToStringConverter());
        registry.addConverter(getIdToAdminConverter());
        registry.addConverter(getStringToAdminConverter());
        
        registry.addConverter(getClassGroupToStringConverter());
        registry.addConverter(getIdToClassGroupConverter());
        registry.addConverter(getStringToClassGroupConverter());
        
        registry.addConverter(getCompanyToStringConverter());
        registry.addConverter(getIdToCompanyConverter());
        registry.addConverter(getStringToCompanyConverter());
        
        registry.addConverter(getIdiomToStringConverter());
        registry.addConverter(getIdToIdiomConverter());
        registry.addConverter(getStringToIdiomConverter());
        
        registry.addConverter(getLocationToStringConverter());
        registry.addConverter(getIdToLocationConverter());
        registry.addConverter(getStringToLocationConverter());
        
        registry.addConverter(getTeacherToStringConverter());
        registry.addConverter(getIdToTeacherConverter());
        registry.addConverter(getStringToTeacherConverter());
        
        registry.addConverter(getSystemUserToStringConverter());
        registry.addConverter(getIdToSystemUserConverter());
        registry.addConverter(getStringToSystemUserConverter());
        
        registry.addConverter(getQuizToStringConverter());
		registry.addConverter(getIdToQuizConverter());
		registry.addConverter(getStringToQuizConverter());
		
		registry.addConverter(getQuizChoiceToStringConverter());
		registry.addConverter(getIdToQuizChoiceConverter());
		registry.addConverter(getStringToQuizChoiceConverter());
		
		registry.addConverter(getQuizQuestionToStringConverter());
		registry.addConverter(getIdToQuizQuestionConverter());
		registry.addConverter(getStringToQuizQuestionConverter());
		
		registry.addConverter(getStudentToStringConverter());
    }

	public Converter<QuizStudent, String> getQuizStudentToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.QuizStudent, java.lang.String>() {
            public String convert(QuizStudent quizStudent) {
                return "(no displayable fields)";
            }
        };
    }

	public Converter<Long, QuizStudent> getIdToQuizStudentConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.QuizStudent>() {
            public com.cyu.laclad.domain.QuizStudent convert(java.lang.Long id) {
                return QuizStudent.findQuizStudent(id);
            }
        };
    }

	public Converter<String, QuizStudent> getStringToQuizStudentConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.QuizStudent>() {
            public com.cyu.laclad.domain.QuizStudent convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), QuizStudent.class);
            }
        };
    }
}
