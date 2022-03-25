package day12.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<String> members = new ArrayList<>(Arrays.asList("Юрий Николаевич Клинских", "Игорь Геннадьевич Кущев", "Семён Всеволодович Титиевский", "Алексей Алексеевич Ушаков"));
        MusicBand sectorGazaOld = new MusicBand("Сектор Газа", 1987, members);
        List<String> members2 = new ArrayList<>(Arrays.asList("Юрий Николаевич Клинских", "Владимир Михайлович Лобанов", "Виталий Васильевич Сукочёв", "Игорь Алексеевич Аникеев"));
        MusicBand sectorGazaNew = new MusicBand("Сектор Газа", 1987, members2);
        sectorGazaOld.printMembers();
        MusicBand.transferMembers(sectorGazaNew, sectorGazaOld);
        sectorGazaOld.printMembers();
    }
}
