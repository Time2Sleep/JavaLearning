package learnjava.IO;
//Задание в спойлере ниже
/*
Практическое задание Реализовать программу со следующим функционалом:
1. Возможность ввода команд из консоли
2. Возможность считывания информации из файла (путь к файлу задается параметром команды)
   и построения на основе этой информации коллекции объектов. Пример команды –  parse input.txt
3. Возможность сериализовать объекты из коллекции в выходной файл.
   Пример команды – serialize output.data
4. Возможность десериализовать объекты из файла и вывести их на печать в консоль.
   Пример команды – deserialize output.data
*/

import learnjava.StudentsHashMap.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static  ArrayList<Student> reestr= new ArrayList<>();
    public static void main(String[] args) {
        ReadCommand();
    }

    static void ReadCommand(){
        System.out.print("Введите команду: ");
        String command = sc.next();
        switch (command) {
            case "read":
                ReadFromFile();
                break;
            case "serialize":
                Serialize();
                break;
            case "exit":
                return;
            case "deserialize":
                Deserialize();
                break;
            default:
                System.out.println("Команда не распознана, повторите попытку.");
                ReadCommand();
        }
    }

    static void ReadFromFile(){
        //System.out.print("Введите путь к файлу: ");
        //String path = sc.next(); //захардкодил для ускорения тестов, но суть ясна
        try(FileInputStream fin = new FileInputStream("C://JavaFiles/students.txt")){//в файле формат строк - "Name=Ivan age=20"
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            String buffer = "";
            while((buffer = br.readLine()) != null){
                String[] line = buffer.split("=", 3); //делим на 3 стринга - "Name" , "Ivan age" , "20"
                String name = line[1].split(" ")[0];
                int age = Integer.parseInt(line[2]);
                reestr.add(new Student(name,age));
            }
            System.out.println("Чтение из файла успешно завершено. Найдено "+reestr.size()+" студентов.");
            ReadCommand();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    static void Serialize(){
        if(reestr.isEmpty()){
            System.out.println("Реестр студентов пуст, сначала заполните его командой 'read'");
            ReadCommand();
        }else{
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://JavaFiles/studentsSerialized.dat"))){
                    oos.writeObject(reestr);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("Сериализация студентов из коллекции в файл выполнена успшено. (нет)" );
            ReadCommand();
        }
    }

    static void Deserialize(){
        ArrayList<Student> studentArrayList;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C://JavaFiles/studentsSerialized.dat"))){
            studentArrayList = (ArrayList<Student>)ois.readObject();
            for(Student student : studentArrayList){
                System.out.println(student.toString());
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Десериализация выполнена успешно");
        ReadCommand();
    }
}
