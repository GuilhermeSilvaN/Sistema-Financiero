package com.sytem.financeiropersonal.test;

import com.sytem.financeiropersonal.model.Dashboard;
import com.sytem.financeiropersonal.model.Despesa;
import com.sytem.financeiropersonal.model.Entrada;
import com.sytem.financeiropersonal.model.UserEntity;
import com.sytem.financeiropersonal.repository.DashboardRepository;
import com.sytem.financeiropersonal.repository.DespesaRepository;
import com.sytem.financeiropersonal.repository.EntradaRepository;
import com.sytem.financeiropersonal.repository.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

    private final UserEntityRepository userEntityRepository;
    private final EntradaRepository  entradaRepository;
    private final DespesaRepository despesaRepository;
    private final DashboardRepository dashboardRepository;

    public TestConfig(
            UserEntityRepository userEntityRepository,
            DashboardRepository dashboardRepository,
            EntradaRepository entradaRepository,
            DespesaRepository despesaRepository
    ) {
        this.userEntityRepository = userEntityRepository;
        this.dashboardRepository = dashboardRepository;
        this.entradaRepository = entradaRepository;
        this.despesaRepository = despesaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        entradaRepository.deleteAll();
        despesaRepository.deleteAll();
        dashboardRepository.deleteAll();

        UserEntity user = userEntityRepository.findByEmailAndIsActiveTrue("isagi@gmail.com", true);


        // DASHBOARD
        Dashboard dashboard_1 = new Dashboard(user);

        dashboardRepository.save(dashboard_1);

        // ENTRADAS
        Entrada entrada1 = new Entrada(
                LocalDate.of(2026, 5, 5),
                "Salário",
                3500.0
        );
        entrada1.setDashboard(dashboard_1);

        Entrada entrada2 = new Entrada(
                LocalDate.of(2026, 5, 15),
                "venda",
                120.00
        );
        entrada2.setDashboard(dashboard_1);

        dashboard_1.getEntradas().add(entrada1);
        dashboard_1.getEntradas().add(entrada2);

        // DESPESAS
        Despesa despesa1 = new Despesa(
                LocalDate.of(2026, 5, 15),
                "Aluguel",
                "Moradia",
                "PIX",
                1200.0
        );
        despesa1.setDashboard(dashboard_1);

        Despesa despesa2 = new Despesa(
                LocalDate.of(2026, 5, 10),
                "Internet",
                "Serviços",
                "Cartão",
                139.0
        );
        despesa2.setDashboard(dashboard_1);

        dashboard_1.getDespesas().add(despesa1);
        dashboard_1.getDespesas().add(despesa2);

        entradaRepository.save(entrada1);
        entradaRepository.save(entrada2);

        despesaRepository.save(despesa1);
        despesaRepository.save(despesa2);

        dashboardRepository.save(dashboard_1);

        System.out.println("Banco populado com sucesso!");


    }
}
