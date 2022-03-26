package day13;

public class Task1 {
    public static void main(String[] args) {
        User user1 = new User("Иван");
        User user2 = new User("Дима");
        User user3 = new User("Алекс");

        user1.sendMessage(user2, "Привет");
        user1.sendMessage(user2, "Алеееее");

        user2.sendMessage(user1, "Привет");
        user2.sendMessage(user1, "Что разорался");
        user2.sendMessage(user1, "Имей терпение!");

        user3.sendMessage(user1, "Привет");
        user3.sendMessage(user1, "Ты где?");
        user3.sendMessage(user1, "Эййй, ты где?");

        user1.sendMessage(user3, "Здороф");
        user1.sendMessage(user3, "Тут я");
        user1.sendMessage(user3, "Димона не видел?");

        user3.sendMessage(user1, "Видел, но тебе не скажу где он :D");

        MessageDatabase.showDialog(user1, user3);

        user1.subscribe(user3);
        user3.subscribe(user1);
        user1.subscribe(user2);

        System.out.println(user1.isSubscribed(user3) ? user1.getUsername() + " и " + user3.getUsername() + " друзья" : user1.getUsername() + " и " + user3.getUsername() + " недруги");
        System.out.println(user2.isSubscribed(user1) ? user1.getUsername() + " и " + user2.getUsername() + " друзья" : user1.getUsername() + " и " + user2.getUsername() + " недруги");
    }
}
