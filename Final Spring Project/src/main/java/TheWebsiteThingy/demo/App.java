package TheWebsiteThingy.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class App
{
    @Autowired
    private TheWebsiteThingy.demo.Printers obj2;
    @Autowired
    private static ComputerController obj3;
    @Autowired
    private ComputerService service;
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        boolean notOn = true;
        while(true){
            String Userinput = sc.nextLine();
            if (Userinput.equals("Start Program")) {
                notOn = false;
                System.out.println("Began Starting!");
                SpringApplication.run(App.class, args);
            }
            if(Userinput.equals("End")){
                System.out.println("Ending!");
                break;
            }
        }
    }


    }
