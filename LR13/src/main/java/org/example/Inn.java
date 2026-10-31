package org.example;

import java.util.ArrayList;
import java.util.List;

public class Inn {
    private String name;
    private String location;
    private int rooms;
    private double pricePerNight;
    private double rating;
    private int availableRooms;
    private List<String> bookings;

    public Inn(String name, String location, int rooms, double pricePerNight, double rating) throws InvalidInnDataException {
        setName(name);
        setLocation(location);
        setRooms(rooms);
        setPricePerNight(pricePerNight);
        setRating(rating);
        this.availableRooms = this.rooms;
        this.bookings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidInnDataException {
        if (name == null || name.isEmpty()) {
            throw new InvalidInnDataException("Название гостиницы не может быть пустым");
        }
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) throws InvalidInnDataException {
        if (location == null || location.isEmpty()) {
            throw new InvalidInnDataException("Локация не может быть пустой");
        }
        this.location = location;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) throws InvalidInnDataException {
        if (rooms <= 0) {
            throw new InvalidInnDataException("Количество комнат должно быть больше 0");
        }
        this.rooms = rooms;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) throws InvalidInnDataException {
        if (pricePerNight <= 0) {
            throw new InvalidInnDataException("Цена за ночь должна быть больше 0");
        }
        this.pricePerNight = pricePerNight;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) throws InvalidInnDataException {
        if (rating < 1 || rating > 5) {
            throw new InvalidInnDataException("Рейтинг должен быть от 1 до 5");
        }
        this.rating = rating;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void bookRoom(String guest, int nights) throws BookingException {
        if (guest == null || guest.isEmpty()) {
            throw new BookingException("Имя гостя не может быть пустым");
        }
        if (nights <= 0) {
            throw new BookingException("Количество ночей должно быть больше 0");
        }
        if (availableRooms <= 0) {
            throw new BookingException("Нет свободных комнат в гостинице " + name);
        }
        availableRooms--;
        bookings.add(guest + " (" + nights + " ноч.)");
        System.out.println("Гость " + guest + " забронировал комнату в " + name + " на " + nights + " ночей. Стоимость: " + (nights * pricePerNight));
    }

    public void checkOut(String guest) throws InnNotFoundException, BookingException {
        if (guest == null || guest.isEmpty()) {
            throw new BookingException("Имя гостя не может быть пустым");
        }
        boolean found = false;
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).startsWith(guest + " ")) {
                bookings.remove(i);
                availableRooms++;
                found = true;
                System.out.println("Гость " + guest + " выселен из " + name);
                break;
            }
        }
        if (!found) {
            throw new InnNotFoundException("Гость " + guest + " не найден в списке бронирований гостиницы " + name);
        }
    }

    @Override
    public String toString() {
        return "Гостиница: " + name + ", Локация: " + location + ", Комнат: " + rooms +
                ", Свободно: " + availableRooms + ", Цена/ночь: " + pricePerNight + ", Рейтинг: " + rating;
    }
}