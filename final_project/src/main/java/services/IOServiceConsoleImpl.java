package services;

import api.IOService;

import java.io.PrintStream;
import java.util.Scanner;

public class IOServiceConsoleImpl implements IOService {
    private final PrintStream out;
    private final Scanner in;

    public IOServiceConsoleImpl() {
        out = System.out;
        in = new Scanner(System.in);
    }
    @Override
    public void outputStr(String str) {
        out.println(str);
    }

    @Override
    public String readString() {
        return in.nextLine();
    }

    @Override
    public String readString(String prompt) {
        outputStr(prompt);
        return readString();
    }
}
