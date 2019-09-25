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

import learnjava.StudentsHashMap.Skill;
import learnjava.StudentsHashMap.Student;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static  Map<Student, Skill> reestr= new HashMap<>();

    public static void main(String[] args) {
        ReadCommand();
    }

    static void ReadCommand(){
        System.out.print("Введите команду: ");
        String command = sc.next();
        if(command.equals("read")) { //вводим команду read{
            ReadFromFile();
        }else if(command.equals("write")){
            WriteToFile();
        }else if(command.equals("exit")){
            return;
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
                // System.out.println(name + "-" + age); //DEBUG
                reestr.put(new Student(name,age),new Skill("skill"));
            }
            System.out.println("Чтение из файла успешно завершено. Найдено "+reestr.size()+" студентов.");
            ReadCommand();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    static void WriteToFile(){
        if(reestr.isEmpty()){
            System.out.println("Реестр студентов пуст, сначала заполните его командой 'read'");
            ReadCommand();
        }else{
            //TODO добавить запись в файл
            System.out.println("Запись студентов из коллекции в файл выполнена успшено. (нет)");
            ReadCommand();
        }
    }
}
