package com.hobrum.mkadm;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.hobrum.mkadm")
public class MikrotikCommand {

    public void rebootAllMikrotik() throws MikrotikApiException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MikrotikList.class, MikrotikUser.class);

        MikrotikList ml = context.getBean("mikrotikList", MikrotikList.class);
        MikrotikUser mu = context.getBean("mikrotikUser", MikrotikUser.class);

        for (String l : ml.getIpMikrotikDevices()) {

            System.out.println(l);
            System.out.println(mu.getUserMikrotik());
            System.out.println(mu.getPasswordMikrotik());

            ApiConnection con = ApiConnection.connect(l);
            con.login(mu.getUserMikrotik(), mu.getPasswordMikrotik());
            con.execute("/system/reboot");
            con.close();
        }
    }

    public void rebootOneMikrotik(String ipMikrotik) throws MikrotikApiException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MikrotikList.class, MikrotikUser.class);

        MikrotikUser mu = context.getBean("mikrotikUser", MikrotikUser.class);

            ApiConnection con = ApiConnection.connect(ipMikrotik);
            con.login(mu.getUserMikrotik(), mu.getPasswordMikrotik());
            con.execute("/system/reboot");
            con.close();
    }


}
