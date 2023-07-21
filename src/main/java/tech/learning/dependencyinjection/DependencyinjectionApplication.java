package tech.learning.dependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import tech.learning.dependencyinjection.config.SfgConfiguration;
import tech.learning.dependencyinjection.config.SfgConstructorConfig;
import tech.learning.dependencyinjection.controllers.*;
import tech.learning.dependencyinjection.datasource.FakeDataSource;
import tech.learning.dependencyinjection.services.PrototypeBean;
import tech.learning.dependencyinjection.services.SingletonBean;

//@ComponentScan(basePackages = {"tech.learning.dependencyinjection", "com.learning.pets"})
@SpringBootApplication
public class DependencyinjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DependencyinjectionApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);

		System.out.println("The ideal pet is:");

		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");

		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		String greeting = myController.getGreeting();

		System.out.println(greeting);

		System.out.println(">>>Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println(">>>Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println(">>>Constructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());

		System.out.println(">>>Bean Scopes");

		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getScope());
		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getScope());

		System.out.println(">>>Data Source");
		FakeDataSource fakeDataSource = ctx.getBean("fakeDataSource", FakeDataSource.class);
		System.out.println("username: " + fakeDataSource.getUsername());
		System.out.println("password: " + fakeDataSource.getPassword());
		System.out.println("jdbcurl: " + fakeDataSource.getJdbcurl());

		System.out.println(">>>Config Props Bean");
		SfgConfiguration sfgConfiguration = ctx.getBean("sfgConfiguration", SfgConfiguration.class);
		System.out.println("username: " + sfgConfiguration.getUsername());
		System.out.println("password: " + sfgConfiguration.getPassword());
		System.out.println("jdbcurl: " + sfgConfiguration.getJdbcurl());

		System.out.println(">>>Constructor Binding");
		SfgConstructorConfig sfgConstructorConfig = ctx.getBean(SfgConstructorConfig.class);
		System.out.println("username: " + sfgConstructorConfig.getUsername());
		System.out.println("password: " + sfgConstructorConfig.getPassword());
		System.out.println("jdbcurl: " + sfgConstructorConfig.getJdbcurl());
	}

}
