package com.mxs.project;

import com.mxs.project.factory.ApplicationFactory;
import com.mxs.project.factory.CommandFactory;
import com.mxs.project.projection.CommandProjection;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws CmdLineException {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationFactory.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a command:");
            String[] input = scanner.nextLine().split(" ");
            CommandProjection commandProjection = CommandFactory.getInstance().getCommandCatalog(input);
            CmdLineParser cmdLineParser = new CmdLineParser(commandProjection);
            String[] commandArray = Arrays.copyOfRange(input, 1, input.length);
            String commands = String.join(" ", commandArray);
            cmdLineParser.parseArgument(commands);
        }
    }
}
