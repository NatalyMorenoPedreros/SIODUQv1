package com.uniquindio.trabajogrado.SIODUQ.controlador;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ConfiguracionWeb implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registro) {
        registro.addViewController("/");
        registro.addViewController("/agregarNotificacion");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
        registro.addViewController("/errores/404").setViewName("/errores/404");
        registro.addViewController("/errores/errorCreacion").setViewName("/errores/errorCreacion");
        registro.addViewController("/errores/errorCreacionNotificacion").setViewName("/errores/errorCreacionNotificacion");
        registro.addViewController("/errores/errorInicioSesion").setViewName("/errores/errorInicioSesion");
        registro.addViewController("/errores/errorObtenerInformacion").setViewName("/errores/errorObtenerInformacion");
        registro.addViewController("/errores/errorProceso").setViewName("/errores/errorProceso");
    }
}
