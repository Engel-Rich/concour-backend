package mutrix.prepa.app.demo;

// import java.sql.Connection;
// import java.sql.ResultSet;

// import javax.sql.DataSource;


// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class PrepasConcoursApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrepasConcoursApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner testFlyerWCommandLineRunner(DataSource dataSource){
	// 	return args -> {
	// 		try(Connection connection = dataSource.getConnection()){
	// 			if (connection != null) {
	// 				System.out.println("Connexion à la BD réussie via : " + connection.getMetaData().getURL());
	// 				System.out.println("Utilisateur : " + connection.getMetaData().getUserName());
	// 				// Vérifier si la table Rules existe
    //             try (ResultSet tables = connection.getMetaData().getTables(null, null, "Rules", null)) {
    //                 if (tables.next()) {
    //                     System.out.println("La table Rules existe!");
    //                     // Afficher les colonnes
    //                     try (ResultSet columns = connection.getMetaData().getColumns(null, null, "Rules", null)) {
    //                         while (columns.next()) {
    //                             System.out.println("Colonne: " + columns.getString("COLUMN_NAME"));
    //                         }
    //                     }
    //                 } else {
    //                     System.out.println("La table Rules n'existe pas!");
    //                 }
    //             }
	// 			} else {
	// 				System.out.println("Échec de la connexion à la base de données.");
	// 			}
				
	// 		} catch (Exception e) {
	// 			System.err.println("Erreur de connexion à la BD : " + e.getMessage());
    //             e.printStackTrace();
	// 		}
	// 	};
	// }
}
