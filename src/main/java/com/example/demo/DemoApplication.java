package com.example.demo;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.User;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args)  {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        UserRepository userRepository= context.getBean(UserRepository.class);
        userRepository.save( new User("user","pass"));

        ProductServiceImpl productService=context.getBean(ProductServiceImpl.class);

        productService.loadDB();



//        DataBaseUtil dataBaseUtil=new DataBaseUtil();
//        dataBaseUtil.loadProducts();
    }
}

////trebuie vazut ca se schimba de mai multe ori userName fara deconectare (nu se upadte @securinteContext)