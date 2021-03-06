package learnjava.StudentsHashMap;

import java.util.HashMap;
import java.util.Map;
//Задание в спойлере ниже
/*Задание
Основная задача – создать реестр студентов и их знаний.
Ход исполнения:
1. Создать новый проект в Idea
2. Создать package
3. Создать сущность студент (POJO), содержащий набор свойств.
В первом варианте реализации не переопределять методы hashCode и equals
4. Создать сущность умение – Skill, содержащий набор свойств.
5. Создать основной класс с точкой входа main
6. В методе main создать map – реестр.
В качестве ключей использовать студентов, в качестве значения – список умений.
7. Наполнить реестр ассоциациями.
8. Показать обязательность переопределения hashCode и equals – создать еще один объект студент,
аналогичный тому, который уже есть в реестре. Попытаться получить его умения – результат должен быть null
9. Переопределить метод hashCode и equals в типе Student. После этого еще раз выполнить программу.
Результат предыдущего пункта должен возвращать значение из реестра
10. Написать код, пробегающий по списку умений студента и выводящий их на экран
11. Показать недостатки использования Mutable объектов в качестве ключа.
Сохранить прямую ссылку на любого студента, после того, как он будет добавлен в реестр,
изменить свойство, участвующее в вычислении hashCode. После это попробовать получить список его умений.
Результат должен быть null – изменение хеш-кода привело к тому, что ассоциация ищется в другой корзине.
12. Сделать тип Student immutable, показать, что теперь такая ситуация невозможна програмно.
13. Написать код, выводящий все содержимое мап на печать

*/

public class Main {
    public static void main(String[] args) {
        Map<Student, Skill> reestr = new HashMap<>(); //Реестр студентов и их умений
        reestr.put(new Student("Airat",23),new Skill("Lazy"));
        reestr.put(new Student("Aliya",20),new Skill("Drawing"));
        reestr.put(new Student("Daniya",80),new Skill("Cooking"));
        reestr.put(new Student("Persik",10),new Skill("Sleeping"));
        Student newStudent = new Student("Airat",23); //студент аналогичный первому

        //System.out.println(reestr.get(newStudent)); // без оверрайда equals и hashCode выводит null, с оверрайдом выводит 'skill - Lazy'

        //выводит всю мапу
        for(Student student : reestr.keySet()){
            System.out.println(student + " - " + reestr.get(student));
        }
    }
}
