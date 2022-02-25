package uz.pdp.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Asilbek Fayzullayev 25.02.2022 8:55

    public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[]{
                    WebMvcConfig.class
            };
        }

        @Override
        protected String[] getServletMappings() {
            return new String[]{
                    "/"
            };
        }
    }

