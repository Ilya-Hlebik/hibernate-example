import entity.Developer;
import service.DeveloperService;

import java.util.List;

public class DeveloperRunner {

    public static void main(String[] args) {
        DeveloperService developerService = new DeveloperService();

        System.out.println("Adding developer's records to the DB");
        /**
         *  Adding developer's records to the database (DB)
         */
        Integer firstDeveloperId = developerService.addDeveloper("Test", "Developer", "Java Developer", 2);
        Integer secondDeveloperId = developerService.addDeveloper("Some", "Developer", "C++ Developer", 2);
        developerService.addDeveloper("Peter", "UI", "UI Developer", 4);

        System.out.println("List of developers");
        /**
         * List developers
         */
        List<Developer> developers = developerService.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer);
        }
        System.out.println("===================================");
        System.out.println("Removing Some Developer and updating Test");
        /**
         * Update and Remove developers
         */
        developerService.updateDeveloper(firstDeveloperId, 3);
        developerService.removeDeveloper(secondDeveloperId);

        System.out.println("Final list of developers");
        /**
         * List developers
         */
        developers = developerService.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer);
        }
        System.out.println("===================================");
    }


}
