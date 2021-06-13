public class Hotel {
    Room[] rooms;

    public Hotel(Room[] rooms) {
        this.rooms = rooms;
    }

    public void getFreeRooms(){
        String freeRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isFree()) freeRoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера свободных комнат "+freeRoomsList);
    }
    public void getQuantityRoom(){
        String QuantityRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isFree()) QuantityRoomsList += "В номере "+ rooms[i].getRoomNumber()+" спальных мест "+rooms[i].getQuantity()+"."+"\n";
        }
        System.out.println("Количество спальных мест:"+"\n"+QuantityRoomsList);
    }
    public void roomProperty(byte roomNumber) {
        String PropertyRoom = "";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber) PropertyRoom += "Свойства комнаты номер "+roomNumber+": Спальных мест "+rooms[i].getQuantity()+", WC "+rooms[i].isWc()+", Eat "+rooms[i].isEat()+", WiFi "+rooms[i].isWifi()+", свободна "+rooms[i].isFree();
        }
        System.out.println(PropertyRoom);
    }
    public void availableWifi() {
        String WifiRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWifi()) WifiRoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println(WifiRoomsList);
    }
    public void availableWc() {
        String WcRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWc()) WcRoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println(WcRoomsList);
    }
    public void availableEat() {
        String EatRoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isEat()) EatRoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println(EatRoomsList);
    }
    public void clearRoom(byte roomNumber){
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber && room.isFree()){
                room.setFree(true);
                info = ("Комната номер "+roomNumber+" успешно освобождена");
                break;
            }else if(room.getRoomNumber() == roomNumber && !room.isFree()){
                info = "Комната "+roomNumber+" свободна";
                break;
            }
        }
        System.out.println(info);
    }
    public void reserveRoom(byte roomNumber){
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber && room.isFree()){
                room.setFree(false);
                info = ("Комната номер "+roomNumber+" успешно забронированна");
                break;
            }else if(room.getRoomNumber() == roomNumber && !room.isFree()){
                info = "Комната "+roomNumber+" занята";
                break;
            }
        }
        System.out.println(info);
    }
}
