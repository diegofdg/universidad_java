package gm.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

// Indicamos que esta clase es de configuración
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Definimos el Bean para resolver el idioma de la sesión
    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        // Establecemos el idioma por defecto (Español)
        slr.setDefaultLocale(Locale.forLanguageTag("es"));
        return slr;
    }

    // Definimos el Bean para permitir el cambio de idioma mediante un parámetro
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        // Indicamos que el parámetro para cambiar de idioma será "lang"
        lci.setParamName("lang");
        return lci;
    }

    // Registramos el interceptor para que Spring MVC detecte cambios de idioma
    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/errores/403").setViewName("/errores/403");
    }
}
