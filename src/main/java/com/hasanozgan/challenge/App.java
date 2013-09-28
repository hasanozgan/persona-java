package com.hasanozgan.challenge;

import com.hasanozgan.challenge.model.Person;
import com.hasanozgan.challenge.service.CSVService;
import com.hasanozgan.challenge.service.PersonService;
import org.apache.commons.cli.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Persona is yet another challenge app");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        PersonService personService = ctx.getBean(PersonService.class);
        CSVService csvService = ctx.getBean(CSVService.class);

        // create Options object
        Options options = new Options();

        // add t option
        options.addOption("h", "help", false, "help description");
        options.addOption("i", "import", true, "input person csv file");
        options.addOption("s", "search", true, "search a person by name");

        try {
            CommandLineParser parser = new GnuParser();
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("i")) {
                List<String> csvList = csvService.readFile(cmd.getOptionValue("i"));
                List<Person> people = personService.toPersonList(csvList);
                personService.importPeople(people);

                System.out.println(String.format("\n%5s record(s) wrong", csvList.size() - people.size()));
                System.out.println(String.format("%5s record(s) imported", people.size()));
            }
            else if (cmd.hasOption("s")) {
                List<Person> people = personService.findByName(cmd.getOptionValue("s"));
                for (Person person : people) {
                    System.out.println(String.format("%20s\t%20s\t%s", person.getName(), person.getLastName(), person.getPhones()));
                }
                System.out.println(String.format("\n%5d record(s) found", people.size()));
            }
            else {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("persona", options);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
