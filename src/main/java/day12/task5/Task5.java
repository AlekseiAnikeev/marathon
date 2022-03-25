package day12.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<MusicArtist> members = new ArrayList<>(Arrays.asList(new MusicArtist("Юрий Николаевич Клинских", 22),
                new MusicArtist("Игорь Геннадьевич Кущев", 21),
                new MusicArtist("Семён Всеволодович Титиевский", 25),
                new MusicArtist("Алексей Алексеевич Ушаков", 23)));

        MusicBand sectorGazaOld = new MusicBand("Сектор Газа", 1987, members);
        System.out.println(sectorGazaOld);
        List<MusicArtist> members2 = new ArrayList<>(Arrays.asList(new MusicArtist("Юрий Николаевич Клинских",  24),
                new MusicArtist("Владимир Михайлович Лобанов", 18),
                new MusicArtist("Виталий Васильевич Сукочёв", 33),
                new MusicArtist("Игорь Алексеевич Аникеев", 26)));
        MusicBand sectorGazaNew = new MusicBand("Сектор Газа", 1987, members2);
        System.out.println(sectorGazaNew);
        System.out.println();
        MusicBand.transferMembers(sectorGazaNew, sectorGazaOld);

        System.out.println(sectorGazaOld);
        System.out.println(sectorGazaNew);
        System.out.println();

        sectorGazaOld.printMembers();
        sectorGazaNew.printMembers();



    }
}
