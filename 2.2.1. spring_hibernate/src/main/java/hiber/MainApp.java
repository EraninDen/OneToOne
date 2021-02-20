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

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.add(new User("User5", "LN5","US5@ru"));

      Car BMW = new Car();
      BMW.setModel("M");
      BMW.setSeries(5);
      User user7 = new User("Oleg", "Bobkov", "nvrs@ru");
      BMW.setUser(user7);
      user7.setCar(BMW);

      Car ford = new Car();
      ford.setModel("Focus");
      ford.setSeries(2);
      User user6 = new User("Vasya","Pupkin","hbrvjs@ru");
      ford.setUser(user6);
      user6.setCar(ford);

      userService.add(user7);
      userService.add(user6);

      //System.out.println(userService.findByModelAndSeries("Focus", 2));
      //System.out.println(userService.findByModelAndSeries("M", 5));

      System.out.println(userService.getCar("M", 5));
      System.out.println(userService.getCar("Focus", 2));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      context.close();
   }
}
/*Задание:
1. Создайте соединение к своей базе данных и схему. Запустите приложение. Проверьте, что оно полностью работает.
2. Создайте сущность Car с полями String model и int series, на которую будет ссылаться User с помощью связи one-to-one.
3. Добавьте этот класс в настройки hibernate.
4. Создайте несколько пользователей с машинами, добавьте их в базу данных, вытащите обратно.
5. В сервис добавьте метод, который с помощью hql-запроса будет доставать юзера, владеющего машиной по ее модели и серии.*/
