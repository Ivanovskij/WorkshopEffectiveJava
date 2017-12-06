package com.ivo.chapter1.creatingAndDestroyingObjects;

/**
 *
 * @author IOAdmin
 */
public class PrivateConstructor {

    private PrivateConstructor() {}
    
    
    /* Отсутствие экзе пляров обеспечивает закрытый конструктор 
    
        НЕВОЗМОЖНО СОЗДАТЬ ОБЪЕКТ ЭТОГО КЛАССА
        Такой подход используется во многих классах 
        исходников языка java: например Math
        Для того чтобы можно было использовать только статичные методы этого класса
    
    */
}
