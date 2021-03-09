public class LessonFive {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Сотрудники старше 40 лет");
        System.out.println();

        Person[] personArray = new Person[5];
        personArray[0] = new Person("Иванов Иван Иванович", "Сторож", "ivanovich@gmail.com", "892122211123", 50000, 35);
        personArray[1] = new Person("Сидоров Пётр Сидорович", "Разработчик", "sidor.coder@gmail.com", "892123211123", 35000, 35);
        personArray[2] = new Person("Феофанова Галина Феофановна", "Бухгалтер", "ffna@gmail.com", "892233211123", 80000, 55);
        personArray[3] = new Person("Петров Пётр Петрович", "Заведующий складом", "ppp.19.2@gmail.com", "8922324123", 59000, 45);
        personArray[4] = new Person("Игнатьев Игнат Игнатович", "Директор", "ignasha@gmail.com", "892233211123", 120000, 64);

        for (int i = 0; i < personArray.length; i++){
            if (personArray[i].getAge() > 40) {
                personArray[i].printInfo();
            }
        }
    }
}
