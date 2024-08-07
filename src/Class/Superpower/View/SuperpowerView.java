package Class.Superpower.View;

import Class.Superpower.Model.Entity.Superpower;
import Class.Superpower.Model.Repository.SuperpowerRepository;

import java.util.Scanner;

public class SuperpowerView {
    private Scanner scanner;

    public SuperpowerView()
    {
        this.scanner = new Scanner(System.in);
    }
    public void ShowSuperpower(SuperpowerRepository superpowerRepository)
    {
        for(Superpower s: superpowerRepository.superpowerList)
        {
            System.out.println(s);
            System.out.println("𝓛𝖊𝖛𝖊𝖑:" + s.getLevel() + " 𝓝𝖆𝖒𝖊:" + s.getName());
            System.out.println("--------------------------------");
        }
    }
}
