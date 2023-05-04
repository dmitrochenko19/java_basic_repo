package fakes;

import api.IOService;

import java.io.*;
import java.util.Scanner;

public class IOServiceFake implements IOService {
    private final PrintStream out;
    private final Scanner in;
    public IOServiceFake(PrintStream out, Scanner in) throws FileNotFoundException, IOException{
        this.out = out;
        this.in = in;
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

    public Scanner getIn() {
        return in;
    }

    public PrintStream getOut() {
        return out;
    }
}
