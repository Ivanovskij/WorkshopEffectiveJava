package com.ivo.chapter4.item29;

import java.util.HashMap;
import java.util.Map;

/**
 * // Typesafe heterogeneous container - Pages 142-145
 * @author IOAdmin
 */
public class Favorites {

    // Typesafe heterogeneous container pattern - implementation
    private Map<Class<?>, Object> favorites =
            new HashMap<>();
    
    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        favorites.put(type, instance);
    }
    
    /*
        Метод Cast - динамический аналог оператора Java cast.
        Он просто проверяет, что его аргумент является экземпляром типа,
        представленного объектом Class. Если так, он возвращает аргумент;
        в противном случае он выводит ClassCastException, предполагая,
        что клиентский код компилируется без ошибок. Нужно сказать, что
        мы знаем, что значения в карте favorites всегда совпадают с типами
        ключей.
        Итак, что делает для нас метод cast, зная, что он просто возвра­
        щает свои аргументы? Подпись метода cast максимально использует
        преимущества того факта, что класс Class был обобщен. Его возвра­
        щаемый тип — это параметр типа объекта Class:
    
        public class Class<T> {
            T cast(Object obj);
        }
    */
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    
    
    // Typesafe heterogeneous container pattern - client
	public static void main(String[] args) {
            Favorites f = new Favorites();
            f.putFavorite(String.class, "Java");
            f.putFavorite(Integer.class, 0xcafebabe);
            f.putFavorite(Class.class, Favorites.class);

            String favoriteString = f.getFavorite(String.class);
            int favoriteInteger = f.getFavorite(Integer.class);
            Class<?> favoriteClass = f.getFavorite(Class.class);
            System.out.printf("%s %x %s%n", favoriteString, favoriteInteger,
                            favoriteClass.getName());
	}
    
}
