package tw.org.iii.cma.labcargojsp;

import java.util.Locale;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

//	java 多國語系組態檔
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor =  new LocaleChangeInterceptor();
		interceptor.setParamName("languege");
		registry.addInterceptor(interceptor);
	}

	public WebMvcConfig()
	{
		super();
	}
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/index.html");
	      
    	
	}
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/**",
        		"/css/**",
                "/resources/**",
                "/js/**",
                "/script/**",
                "/images/**",
                "/api/**",
                "/font-awesome/**",
                "/introducePic/**",
                "/scss/**",
                "/assets/**",
                "/assets/img/**"
               )
		        .addResourceLocations(
        		   "classpath:/static/css/",
        		   "classpath:/static/script/",
        		   "classpath:/static/images/",
        		   "classpath:/static/api/",
        		   "classpath:/static/assets",
        		   "classpath:/static/introducePic",
        		   "classpath:/static/scss",
        		   "classpath:/static/assets/img/",
                   "classpath:/resources/",      
                   "classpath:/static/font-awesome/");
	}
	
	@Bean
    @ConditionalOnMissingBean(RequestContextListener.class)
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
	
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(Locale.TAIWAN);
		resolver.setCookieMaxAge(86400);
		resolver.setCookieName("langCookie");
		return resolver;
	}
}
