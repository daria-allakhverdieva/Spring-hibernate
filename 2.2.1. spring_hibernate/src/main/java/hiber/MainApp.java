package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car = new Car("Camaro" , 2);
      User user = new User("Ivan", "Ivanov", "mail@mail.ru");
      user.setCar(car);
      car.setUser(user);
      userService.add(user);

      Car car2 = new Car("Spectra" , 3);
      User user2 = new User("Kirill", "Bedrosov", "kirill@mail.ru");
      user2.setCar(car2);
      car2.setUser(user2);
      userService.add(user2);

      Car car3 = new Car("C4" , 2);
      User user3 = new User("Roman", "Fedorenkov", "RF@mail.ru");
      user3.setCar(car3);
      car3.setUser(user3);
      userService.add(user3);

      System.out.println(userService.getUserByCar("Camaro", 2));
      System.out.println(userService.getUserByCar("Spectra" , 3));
      System.out.println(userService.getUserByCar("C4" , 2));

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();
   }
}
