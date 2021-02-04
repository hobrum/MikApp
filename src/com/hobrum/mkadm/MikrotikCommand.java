package com.hobrum.mkadm;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("com.hobrum.mkadm")
public class MikrotikCommand {

    private MikrotikList getMikrotikList() {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MikrotikList.class, MikrotikUser.class);

        MikrotikList ml = context.getBean("mikrotikList", MikrotikList.class);

        return ml;
    }

    private  MikrotikUser getMikrotikUser() {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MikrotikUser.class);

        MikrotikUser mu = context.getBean("mikrotikUser", MikrotikUser.class);

        return mu;

    }

    private ApiConnection connectToMikrotik(String ipMikrotik) throws MikrotikApiException{

        ApiConnection con = null;
        con = ApiConnection.connect(ipMikrotik);
        con.login(getMikrotikUser().getUserMikrotik(), getMikrotikUser().getPasswordMikrotik());
        return con;



    }


    public void openInternet(String ipDevice)  throws MikrotikApiException {

        ApiConnection mc = connectToMikrotik(ipDevice.split(".\\w+$")[0] + ".1");
        mc.execute("/ip/hotspot/ip-binding/add address=" +ipDevice +" server=all");
        mc.execute("/ip/hotspot/walled-garden/ip/add action=accept src-address=" +ipDevice);
        mc.close();

    }

    public void hotspotSiteOne(String ipMikrotik, String siteAddress)  throws MikrotikApiException {



    }

    public void hotspotSiteAll(String siteAddress)  throws MikrotikApiException {

        for (String l : getMikrotikList().getIpMikrotikDevices()) {


            ApiConnection con = ApiConnection.connect(l);
            con.login(getMikrotikUser().getUserMikrotik(), getMikrotikUser().getPasswordMikrotik());
            con.execute("/system/reboot");
            con.close();

            System.out.println(l +" - доступ открыт");
        }

    }

    public void rebootAllMikrotik() throws MikrotikApiException {

        for (String l : getMikrotikList().getIpMikrotikDevices()) {

            System.out.println(l);
            ApiConnection mc = connectToMikrotik(l);
            mc.execute("/system/reboot");
            mc.close();
        }
    }

    public void rebootOneMikrotik(String ipMikrotik) throws MikrotikApiException {

            ApiConnection mc = connectToMikrotik(ipMikrotik);
            mc.execute("/system/reboot");
            mc.close();
    }

    public void listAllMikrotik() throws MikrotikApiException {

            for (String l : getMikrotikList().getIpMikrotikDevices()) {

                System.out.println(l);

        }
    }

    public void addMacWiFi (String macDevice, String ipMikrotik) {

    }

}
