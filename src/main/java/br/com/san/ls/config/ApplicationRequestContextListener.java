package br.com.san.ls.config;

import javax.servlet.annotation.WebListener;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
@WebListener
public class ApplicationRequestContextListener extends RequestContextListener{

}
