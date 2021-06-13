import java.util.Scanner;

/*
 *  ***Гостиница***
 *  1) Гостиница
 *  2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питаение(есть/нет), wifi(есть/нет), свободен/занят)
 *
 *   *Задание для лабораторной работы №4*
 *   Освободить комнату
 *   Вывести свойства комнаты
 *   Показать комнаты с WiFi
 *   Показать комнаты с WC
 *   Показать комнаты с Eat
 *   Показать комнаты по кол-ву спальных мест
 *   Отобразить список команд
 * */
public class Main {
    public static void main(String[] args) {
        Room[] rooms = {
                new Room((byte) 1,false,false,true,(byte) 11),
                new Room((byte) 2,true,true,false,(byte) 12),
                new Room((byte) 1,false,true,true,(byte) 13),
                new Room((byte) 3,true,false,false,(byte) 21),
                new Room((byte) 2,false,false,false,(byte) 22),
                new Room((byte) 1,true,true,true,(byte) 23),
                new Room((byte) 3,false,true,false,(byte) 31),
                new Room((byte) 3,true,true,false,(byte) 32),
                new Room((byte) 1,false,false,true,(byte) 33),
        };
        Hotel hotel = new Hotel(rooms);
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true){
            System.out.println("Введите команду: "+"\n"+"Количество свободных комнат: getFreeRooms"+"\n"+"Забронировать комнату: reserveRoom"+"\n"+"Освободить комнату: clearRoom"+"\n"+"Получить информацию о комнате: roomProperty"+"\n"+"Есть ли WiFi в команте: availableWifi"+"\n"+"Есть ли туалет в комнате: availableWC"+"\n"+"Есть ли питание: availableEat"+"\n"+"Сколько спальных мест в комнате: getQuantityRoom"+"\n"+"Выход: Exit");
            command = scanner.nextLine();
            if(command.equals("getFreeRooms")){
                hotel.getFreeRooms();
            }else if(command.equals("clearRoom")){
                System.out.print("Введите номер комнаты для освобождения: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.clearRoom(roomNumber);
            }else if(command.equals("reserveRoom")){
                System.out.print("Введите номер комнаты для бронирования: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.reserveRoom(roomNumber);
            }else if(command.equals("roomProperty")){
                System.out.print("Введите номер комнаты для получения информации: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.roomProperty(roomNumber);
            }else if(command.equals("availableWifi")){
                System.out.print("Список комнат с WiFi: ");
                hotel.availableWifi();
            }else if(command.equals("availableWc")){
                System.out.print("Список комнат с туалетом: ");
                hotel.availableWc();
            }else if(command.equals("availableEat")){
                System.out.print("Список комнат с питанием: ");
                hotel.availableEat();
            }else if(command.equals("getQuantityRoom")){
                hotel.getQuantityRoom();
            }else if (command.equals("exit")){
                break;
            }
        }
    }
}