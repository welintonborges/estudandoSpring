package com.example.estudandorest;

import com.example.estudandorest.service.CrudCargoService;
import com.example.estudandorest.service.CrudFuncionarioService;
import com.example.estudandorest.service.CrudUnidadeTRabalhoService;
import com.example.estudandorest.service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class EstudandoRestApplication implements CommandLineRunner {

    private final CrudCargoService cargoService;
    private final CrudUnidadeTRabalhoService unidadeTRabalhoService;
    private final CrudFuncionarioService funcionarioService;
    private final RelatorioService relatorioService;
    private Boolean system = true;

    public EstudandoRestApplication(CrudCargoService cargoService, CrudUnidadeTRabalhoService unidadeTRabalhoService, CrudFuncionarioService funcionarioService, RelatorioService relatorioService){
        this.cargoService = cargoService;
        this.unidadeTRabalhoService = unidadeTRabalhoService;
        this.funcionarioService = funcionarioService;
        this.relatorioService = relatorioService;
    }
    public static void main(String[] args) {
        SpringApplication.run(EstudandoRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (system){
            System.out.println("Qual ação você quer executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargo");
            System.out.println("2 - Unidade de Trabalho ");
            System.out.println("3 - Funcionario ");
            System.out.println("4 - Relatorios de funcionario ");

            int action = scanner.nextInt();
           switch (action){
               case 1:
                   cargoService.inicial(scanner);
                   break;
               case 2:
                   unidadeTRabalhoService.inicial(scanner);
                   break;
               case 3:
                   funcionarioService.inicial(scanner);
                   break;
               case 4 :
                   relatorioService.inicial(scanner);
                   break;
               default:
                   system = false;
                   break;
           }
        }

    }
}
