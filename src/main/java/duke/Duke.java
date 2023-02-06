package duke;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import storage.Storage;
import parser.Parser;
import tasklist.TaskList;
import ui.Ui;

public class Duke {

    Storage storage;
    Ui ui;
    TaskList list;
    Parser parser;
    final static String DEFAULT_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator + "duke.txt";

    Duke(String path) throws IOException {
        this.ui = new Ui();
        this.storage = new Storage(path);
        this.list = this.storage.load();
        this.parser = new Parser();
    }

    public void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        ui.printEntry();
        while (!this.ui.isClosed) {
            String input = sc.nextLine();
            this.parser.parse(input, this.ui, this.list);
        }
        this.storage.save(this.list);
        sc.close();
    }

    public static void main(String[] args) throws IOException {
        new Duke(DEFAULT_PATH).run();
    }



}






