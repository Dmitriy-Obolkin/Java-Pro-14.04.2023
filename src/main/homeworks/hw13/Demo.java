package src.main.homeworks.hw13;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add("C:\\Users\\4xxdo\\HillelJavaPro\\Java Pro 14.04.2023\\hw13-Files\\test1.txt");
        fileNavigator.add("hw13-Files\\Screenshot.png");
        fileNavigator.add("Screenshot2.png");
        fileNavigator.add("hw13-Files\\testFolder\\111");
        fileNavigator.add("hw13-Files\\testFolder\\New Text Document.txt");
        fileNavigator.add("hw13-Files\\testFolder\\123fdsfsdf.txt");
        System.out.println("\nAll files:");
        System.out.println(fileNavigator);

        System.out.println("\nfind(hw13-Files\\testFolder):");
        System.out.println(fileNavigator.find("hw13-Files\\testFolder"));
        //System.out.println("\nfind(hw13-Files\\\\test):");
        //System.out.println(fileNavigator.find("hw13-Files\\test")); //Error demo

        System.out.println("\nfilterBySize(2000 byte):");
        System.out.println(fileNavigator.filterBySize(2000L));

        System.out.println("\nsortBySize:");
        System.out.println(fileNavigator.sortBySize());

        System.out.println("\nremove(\"hw13-Files\\\\testFolder\"):");
        fileNavigator.remove("hw13-Files\\testFolder");
        System.out.println(fileNavigator);



        System.out.println();
    }
}
