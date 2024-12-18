package fr.seishin.application;

import fr.seishin.librairies.Library;
import fr.seishin.libs.*;
import fr.seishin.libs.data.AddData;

public class Run {
    private static Run instance = new Run();

    private Run() {
    }

    public static Run getInstance() {
        return instance;
    }

    public void run() {
        Library library = new Library("Bibliothèque de Castres");
        AddData.addData(library);
        do {
            Display.displayMenu(library);
        } while (true);
    }
}