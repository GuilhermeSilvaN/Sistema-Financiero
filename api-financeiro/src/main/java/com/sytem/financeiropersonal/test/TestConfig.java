package com.sytem.financeiropersonal.test;

import com.sytem.financeiropersonal.model.*;
import com.sytem.financeiropersonal.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {


    public TestConfig(
    ) {

    }

    @Override
    public void run(String... args) throws Exception {
//        entradaRepository.deleteAll();
//        despesaRepository.deleteAll();
//        mesDashboardRepository.deleteAll();
//        dashboardRepository.deleteAll();
//
//        UserEntity user1 = userEntityRepository
//                .findByEmailAndIsActiveTrue("isagi@gmail.com", true);
//
//        Dashboard dashboard1 = new Dashboard();
//
//        dashboard1.addEntrada(
//                new Entrada(
//                        LocalDate.of(2026, 7, 5),
//                        "salario",
//                        1400.00)
//        );
//        dashboard1.addDespesa(
//                new Despesa(
//                       LocalDate.of(2026, 7, 6),
//                       "chocolates",
//                       "besteiras",
//                       "PIX",
//                       7.99
//                )
//        );
//
//        MesDashboard mesDashboard1 = new MesDashboard(7, 2026, user1,  dashboard1);
//        mesDashboardRepository.save(mesDashboard1);
    }

}
