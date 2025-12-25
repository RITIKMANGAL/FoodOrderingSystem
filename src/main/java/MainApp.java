import model.*;
import pojo.MenuItem;
import repository.*;
import serviceImpl.*;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        RestaurantRepository rr = new RestaurantRepository();
        OrderRepository or = new OrderRepository();
        UserRepository ur = new UserRepository();

        Restaurant r1 = new Restaurant("R1", 5, 4.5);
        r1.getMenu().put("Veg Biryani", new MenuItem("Veg Biryani", 100));
        r1.getMenu().put("Chicken Biryani", new MenuItem("Chicken Biryani", 150));

        Restaurant r2 = new Restaurant("R2", 5, 4);
        r2.getMenu().put("Idli", new MenuItem("Idli", 10));
        r2.getMenu().put("Dosa", new MenuItem("Dosa", 50));
        r2.getMenu().put("Veg Biryani", new MenuItem("Veg Biryani", 80));
        r2.getMenu().put("Chicken Biryani", new MenuItem("Chicken Biryani", 175));

        Restaurant r3 = new Restaurant("R3", 1, 4.9);
        r3.getMenu().put("Idli", new MenuItem("Idli", 15));
        r3.getMenu().put("Dosa", new MenuItem("Dosa", 30));

        rr.save(r1); rr.save(r2); rr.save(r3);

        OrderServiceImpl os = new OrderServiceImpl(rr, or);

        Map<String,Integer> items = Map.of("Idli",3,"Dosa",1);
        os.placeOrder(new Order(1, ur.save("Ashwin"), items));
        os.placeOrder(new Order(2, ur.save("Harish"), items));

        os.completeOrder(1);

        os.placeOrder(new Order(3, ur.save("Harish"), items));
        os.placeOrder(new Order(4, ur.save("Diya"), Map.of("Idli",3,"Paneer Tikka",1)));
    }
}
