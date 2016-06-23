package abd.p1;

import abd.p1.controller.MainController;
import abd.p1.model.Core;
import abd.p1.view.LoginFrame;
import abd.p1.view.UserProfileEdit;

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

            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(UserProfileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(UserProfileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(UserProfileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(UserProfileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            Core core = new Core(sf);
            MainController controller = new MainController(core);
            LoginFrame loginFrame = new LoginFrame(controller);
            controller.addLoginView(loginFrame);

            loginFrame.init();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
