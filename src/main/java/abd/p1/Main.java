package abd.p1;

import abd.p1.controller.MainController;
import abd.p1.model.Core;
import abd.p1.view.LoginFrame;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Ésta es la clase que arranca la aplicación. La ejecución del método main()
 * no reconstruirá la base de datos. La base de datos se supone ya construida
 * por el método CreateDB.main()
 *
 */
public class Main {
    
    private static SessionFactory buildSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            return null;
        } 
    }
   
    
    public static void main(String[] args) {
        try {
            SessionFactory sf = buildSessionFactory();

            Core core = new Core(sf);
            MainController controller = new MainController(core);
            LoginFrame loginFrame = new LoginFrame(controller);
            controller.addLoginView(loginFrame);

            loginFrame.setEnabled(true);
            loginFrame.setVisible(true);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
