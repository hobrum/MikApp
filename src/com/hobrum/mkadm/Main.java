package com.hobrum.mkadm;

import me.legrange.mikrotik.MikrotikApiException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MikrotikApiException {

        boolean isExit = false;
        
        while (!isExit) {

            System.out.println("Доступные команды:");
            System.out.println("list - Отобразить список устройств из файла mikrotik.properties.");
            System.out.println("reboot one - Перезагрузить одно устройство. " +
                    "Потребуется ввести ip адрес");
            System.out.println("reboot all - Перезагрузить все устройства," +
                    " которые указаны в файле mikrotik.properties");
            System.out.println("exit - завершить работу с программой");
            System.out.println("Введите команду: ");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextLine()) {
                case "reboot one":
                    MikrotikCommand mcOne = new MikrotikCommand();
                    System.out.println("Введите ip: ");
                    mcOne.rebootOneMikrotik(scanner.nextLine());
                    break;

                case "reboot all":
                    MikrotikCommand mcAll = new MikrotikCommand();
                    mcAll.rebootAllMikrotik();
                    break;

                case "exit":
                    System.out.println("До свидания!");
                    isExit = true;
                    break;

                case "list":
                    MikrotikCommand mcList = new MikrotikCommand();
                    mcList.listAllMikrotik();
                    System.out.println();
                    break;

                default:
                    System.out.println("Команда не найдена");
                    System.out.println();
            }

        }

    }

}
