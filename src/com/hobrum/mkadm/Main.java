package com.hobrum.mkadm;

import me.legrange.mikrotik.MikrotikApiException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MikrotikApiException {

        MikrotikCommand mc = new MikrotikCommand();

        boolean isExit = false;
        
        while (!isExit) {

            System.out.println("Доступные команды:");
            System.out.println("list - Отобразить список устройств из файла mikrotik.properties.");
            System.out.println("reboot one - Перезагрузить одно устройство. " +
                    "Потребуется ввести ip адрес");
            System.out.println("reboot all - Перезагрузить все устройства," +
                    " которые указаны в файле mikrotik.properties");
            System.out.println("open internet - ");
            System.out.println("open site one - ");
            System.out.println("open site all - ");
            System.out.println("add mac - ");
            System.out.println("exit - завершить работу с программой");
            System.out.println("Введите команду: ");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextLine()) {
                case "reboot one":
                    System.out.println("Введите ip: ");
                    mc.rebootOneMikrotik(scanner.nextLine());
                    System.out.println("Устройство перезагружено");
                    System.out.println();
                    break;

                case "reboot all":
                    mc.rebootAllMikrotik();
                    break;

                case "exit":
                    System.out.println("До свидания!");
                    isExit = true;
                    break;

                case "list":
                    mc.listAllMikrotik();
                    System.out.println();
                    break;

                case "open internet":

                    System.out.println("Введите ip адрес устройства, которому требуется доступ в интернет:");
                    mc.openInternet(scanner.nextLine());
                    System.out.println("Доступ в интернет открыт");
                    System.out.println();
                    break;

                case "open site one":

                    System.out.println("Введите ip: ");
                    mc.rebootOneMikrotik(scanner.nextLine());
                    System.out.println("Доступ к сайту открыт");
                    System.out.println();
                    break;

                case "open site all":

                    System.out.println("Доступ к сайту открыт на всех устройствах");
                    System.out.println();
                    break;

                case "add mac":
                    System.out.println("Введите mac адрес устройства (XX:XX: ...), которому требуется доступ к WiFi:");
                    String macDevice = scanner.nextLine();
                    System.out.println("Введите ip адрес микротика:");
                    String ipMikrotik = scanner.nextLine();
                    mc.addMacWiFi(macDevice,ipMikrotik);


                default:
                    System.out.println("Команда не найдена");
                    System.out.println();
            }

        }

    }

}
