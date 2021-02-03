package com.hobrum.mkadm;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;


public class ConfigBase {

    public static void main(String[] args) throws MikrotikApiException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MikrotikList.class, MikrotikUser.class);
        MikrotikList ml = context.getBean("mikrotikList", MikrotikList.class);

        MikrotikUser mu = context.getBean("mikrotikUser", MikrotikUser.class);

        for (String l : ml.getIpMikrotikDevices()) {

            System.out.println(l);
            System.out.println(mu.getUserMikrotik());
            System.out.println(mu.getPasswordMikrotik());
            ///ip/hotspot/walled-garden/add action=allow dst-host=*yandex.ru

            ApiConnection con = ApiConnection.connect(l);
            con.login(mu.getUserMikrotik(), mu.getPasswordMikrotik());
            //con.execute("/system/reboot");
            con.execute("/ip/hotspot/walled-garden/add action=allow dst-host=*yandex.ru");
            con.close();
        }
    }

}
